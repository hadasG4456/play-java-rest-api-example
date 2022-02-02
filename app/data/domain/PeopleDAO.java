package data.domain;

import com.google.inject.Inject;
import play.db.jpa.JPAApi;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class PeopleDAO {
    private static final String ENTITY_MANAGER_NAME = "default";

    @Inject
    protected JPAApi jpaApi;

    public PeopleDO create(PeopleDO peopleDO) {
        jpaApi.withTransaction(entityManager -> { entityManager.persist(peopleDO); });
        return peopleDO;
    }

    public PeopleDO find(String id) {
        return jpaApi.em(ENTITY_MANAGER_NAME).find(PeopleDO.class, id);
    }

    public List<PeopleDO> find() {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PeopleDO> criteriaQuery = criteriaBuilder.createQuery(PeopleDO.class);
        Root<PeopleDO> root = criteriaQuery.from(PeopleDO.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void delete(String id) {
        jpaApi.withTransaction(entityManager -> {
            PeopleDO peopleDO = entityManager.find(PeopleDO.class, id);
            if (peopleDO != null) {
                entityManager.remove(peopleDO);
            }
        });
    }

    public PeopleDO update(PeopleDO peopleDO) {
        jpaApi.withTransaction(entityManager -> {entityManager.merge(peopleDO);
            entityManager.flush();});
        return peopleDO;
    }
}
