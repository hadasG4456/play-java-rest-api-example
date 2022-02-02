package data.domain;

import com.google.inject.Inject;
import play.db.jpa.JPAApi;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TasksDAO {
    private static final String ENTITY_MANAGER_NAME = "default";


    @Inject
    protected JPAApi jpaApi;

    public TasksDO create(TasksDO tasksDO) {
        System.out.println("create DO");
        jpaApi.withTransaction(entityManager -> { entityManager.persist(tasksDO); });
        System.out.println("end create");
        return tasksDO;
    }

    public TasksDO find(String id) {
        return jpaApi.em(ENTITY_MANAGER_NAME).find(TasksDO.class, id);
    }

    public TasksDO findByTitle(String title) {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForTitle = criteriaBuilder.equal(root.get("title"), title); // get only tasks with owner id
        criteriaQuery.select(root).where(predicateForTitle);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<TasksDO> find(String ownerId, boolean bool) { //bool just to seperate between find by person and find all
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForPersonId = criteriaBuilder.equal(root.get("ownerId"), ownerId); // get only tasks with owner id
        criteriaQuery.select(root).where(predicateForPersonId);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public List<TasksDO> find(String ownerId, Status status) { //bool just to seperate between find by person and find all
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);

        Predicate predicateForPersonId = criteriaBuilder.equal(root.get("ownerId"), ownerId); // get only tasks with owner id
        Predicate predicateForTaskStatus = criteriaBuilder.equal(root.get("status"), status);
        Predicate finalPred = criteriaBuilder.and(predicateForPersonId, predicateForTaskStatus);
        criteriaQuery.select(root).where(finalPred);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void delete(String id, String ownerId) {
        jpaApi.withTransaction(entityManager -> {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
            Root<TasksDO> root = criteriaQuery.from(TasksDO.class);
            Predicate predicateForPersonId = criteriaBuilder.equal(root.get("ownerId"), ownerId); // get only tasks with owner id
            Predicate predicateForTaskId = criteriaBuilder.equal(root.get("id"),id);
            Predicate conj = criteriaBuilder.and(predicateForTaskId, predicateForPersonId);
            criteriaQuery.select(root).where(conj);
            TasksDO tasksDO = entityManager.createQuery(criteriaQuery).getSingleResult();
//            TasksDO tasksDO = entityManager.find(TasksDO.class, id);
            if (tasksDO != null) {
                entityManager.remove(tasksDO);
            }
        });
    }

    public TasksDO update(TasksDO tasksDO) {
        jpaApi.withTransaction(entityManager -> {entityManager.merge(tasksDO);});

        return tasksDO;
    }

}
