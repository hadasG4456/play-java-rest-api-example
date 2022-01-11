package data.domain;

import com.google.inject.Inject;
import play.db.jpa.JPAApi;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class TasksDAO {
    private static final String ENTITY_MANAGER_NAME = "default";

    @Inject
    protected JPAApi jpaApi;

    public TasksDO create(TasksDO tasksDO) {
        jpaApi.withTransaction(entityManager -> { entityManager.persist(tasksDO); });
        return tasksDO;
    }

    public TasksDO find(String id) {
        return jpaApi.em(ENTITY_MANAGER_NAME).find(TasksDO.class, id);
    }

    public List<TasksDO> find() {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TasksDO> criteriaQuery = criteriaBuilder.createQuery(TasksDO.class);
        Root<TasksDO> root = criteriaQuery.from(TasksDO.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void delete(String id) {
        jpaApi.withTransaction(entityManager -> {
            TasksDO tasksDO = entityManager.find(TasksDO.class, id);
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
