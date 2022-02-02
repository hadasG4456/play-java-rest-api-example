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
 * This DAO responsible for the connection to the database of the PeopleDO table.
 * it holds queries for the table depending on the function uses.
 */
public class PeopleDAO {
    private static final String ENTITY_MANAGER_NAME = "default";

    @Inject
    protected JPAApi jpaApi;

    /**
     * Create a new person in the database.
     */
    public PeopleDO create(PeopleDO peopleDO) {
        jpaApi.withTransaction(entityManager -> { entityManager.persist(peopleDO); });
        return peopleDO;
    }

    /**
     * Find a person by its id.
     * The id is the primary key so no special query necessary.
     */
    public PeopleDO find(String id) {
        return jpaApi.em(ENTITY_MANAGER_NAME).find(PeopleDO.class, id);
    }

    /**
     * Find all people in the server.
     * Creates a new query to the table to get the record of all the people.
     */
    public List<PeopleDO> find() {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PeopleDO> criteriaQuery = criteriaBuilder.createQuery(PeopleDO.class);
        Root<PeopleDO> root = criteriaQuery.from(PeopleDO.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Find a person by its emails.
     * Creates a new query to the table to get the record of the person which has the given emails.
     */
    public PeopleDO findByEmails(String emails) {
        EntityManager entityManager = jpaApi.em(ENTITY_MANAGER_NAME);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PeopleDO> criteriaQuery = criteriaBuilder.createQuery(PeopleDO.class);
        Root<PeopleDO> root = criteriaQuery.from(PeopleDO.class);

        Predicate predicateForTitle = criteriaBuilder.equal(root.get("emails"), emails); // get the task which has this title
        criteriaQuery.select(root).where(predicateForTitle);

        List<PeopleDO> peopleDOList = entityManager.createQuery(criteriaQuery).getResultList();
        if (peopleDOList.size() == 0)
            return null;
        return entityManager.createQuery(criteriaQuery).getResultList().get(peopleDOList.size()-1);
    }

    /**
     * Deletes a record of a person with the given id.
     * Creates a new query to the table to get the record of the person which has the given id.
     * Delete the record that matches to the query.
     */
    public void delete(String id) {
        jpaApi.withTransaction(entityManager -> {
            PeopleDO peopleDO = entityManager.find(PeopleDO.class, id);
            if (peopleDO != null) {
                entityManager.remove(peopleDO);
            }
        });
    }

    /**
     * Updates a record of a person given a personDO and send it back.
     */
    public PeopleDO update(PeopleDO peopleDO) {
        jpaApi.withTransaction(entityManager -> {entityManager.merge(peopleDO);
            entityManager.flush();});
        return peopleDO;
    }
}
