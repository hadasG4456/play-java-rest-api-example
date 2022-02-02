package data.domain;

import com.google.inject.Inject;
import play.db.jpa.JPAApi;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This DAO responsible for the connection to the database of the TasksDO table.
 * it holds queries for the table depending on the function uses.
 */
public class TasksDAO {
    private static final String ENTITY_MANAGER_NAME = "default";

    @Inject
    protected JPAApi jpaApi;

    /**
     * Create a new task in the database.
     */
    public TasksDO create(TasksDO tasksDO) {
        jpaApi.withTransaction(entityManager -> { entityManager.persist(tasksDO); });
        return tasksDO;
    }

    /**
     * Find a task by its id.
     * The id is the primary key so no special query necessary.
     */
    public TasksDO find(String id) {
        return jpaApi.em(ENTITY_MANAGER_NAME).find(TasksDO.class, id);
    }

    /**
     * Find a task by its title.
     * Creates a new query to the table to get the record of the task which has the given title.
     */
    public TasksDO findByTitle(String title) {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForTitle = criteriaBuilder.equal(root.get("title"), title); // get the task which has this title
        criteriaQuery.select(root).where(predicateForTitle);

        List<TasksDO> tasksDOList = entityManager.createQuery(criteriaQuery).getResultList();
        if (tasksDOList.size() == 0)
            return null;
        return entityManager.createQuery(criteriaQuery).getResultList().get(tasksDOList.size()-1);
    }

    /**
     * Find all tasks by their ownerId.
     * Creates a new query to the table to get the record of the task which has the given ownerId.
     * The bool argument is meant to separate between find by task id and find by owner id.
     */
    public List<TasksDO> find(String ownerId, boolean bool) {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForPersonId = criteriaBuilder.equal(root.get("ownerId"), ownerId); // get only tasks with owner id
        criteriaQuery.select(root).where(predicateForPersonId);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Find all tasks by its ownerId that has the required status.
     * Creates a new query to the table to get the record of the task which has the given ownerId.
     * Creates a new query to the table to get the record of the task which has the given status.
     * Combine these queries to one and gets the record that matches both.
     */
    public List<TasksDO> find(String ownerId, Status status) {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForPersonId = criteriaBuilder.equal(root.get("ownerId"), ownerId); // get only tasks with owner id
        Predicate predicateForTaskStatus = criteriaBuilder.equal(root.get("status"), status); // get only tasks with status
        Predicate finalPred = criteriaBuilder.and(predicateForPersonId, predicateForTaskStatus); // combine them
        criteriaQuery.select(root).where(finalPred);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Deletes a record of a task with the given id.
     * Creates a new query to the table to get the record of the task which has the given id.
     * Delete the record that matches to the query.
     */
    public void delete(String id) {
        jpaApi.withTransaction(entityManager -> {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
            Root<TasksDO> root = criteriaQuery.from(TasksDO.class);
            Predicate predicateForTaskId = criteriaBuilder.equal(root.get("id"),id);
            criteriaQuery.select(root).where(predicateForTaskId);
            TasksDO tasksDO = entityManager.createQuery(criteriaQuery).getSingleResult();
            if (tasksDO != null) {
                entityManager.remove(tasksDO);
            }
        });
    }

    /**
     * Updates a record of a task given a taskDO and send it back.
     */
    public TasksDO update(TasksDO tasksDO) {
        jpaApi.withTransaction(entityManager -> {entityManager.merge(tasksDO);
            entityManager.flush();});
        return tasksDO;
    }

}
