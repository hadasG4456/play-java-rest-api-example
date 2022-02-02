package data.services;

import com.google.inject.Inject;
import data.domain.PeopleDAO;
import data.domain.PeopleDO;
import data.domain.TasksDO;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service that connects between the DTOs to the DOs.
 * For each function here- there is a helping function in PeopleDAO.
 */
public class PeopleService {
    @Inject
    private PeopleDAO peopleDAO;

    /**
     * Find every people in the server and make them as a list to sent as a response (to later
     * create a JSON out of it).
     */
    public List<PeopleDTO> getAll() {
        List<PeopleDO> peopleDOList = peopleDAO.find();
        return peopleDOList.stream().map(domain -> PeopleMapper.toTransfer(domain)).collect(Collectors.toList());
    }

    /**
     * Find the person with the given id and returns it (to later create a JSON out of it).
     */
    public Optional<PeopleDTO> getById(String id) {
        PeopleDO peopleDO =peopleDAO.find(id);
        if (peopleDO == null) {
            return Optional.empty();
        }
        return Optional.of(PeopleMapper.toTransfer(peopleDO));
    }

    /**
     * Find the task with the given title and returns it (to later create a JSON out of it).
     */
    public Optional<PeopleDTO> getByEmails(String emails) {
        PeopleDO peopleDO = peopleDAO.findByEmails(emails);
        if (peopleDO == null) {
            return Optional.empty();
        }
        return Optional.of(PeopleMapper.toTransfer(peopleDO));
    }

    /**
     * create a new record of the peopleDTO in the database using a helping DO.
     */
    public PeopleDTO create(PeopleDTO peopleDTO) {
        PeopleDO peopleDO = PeopleMapper.fromTransfer(peopleDTO);
        peopleDO = peopleDAO.create(peopleDO);
        return PeopleMapper.toTransfer(peopleDO);
    }

    /**
     * Check if the id is valid (meaning the database stores a people with the id).
     * If not- returns empty Optional that will cause error in PeopleController.
     * If yes- update the relevant information that we got from the JSON's body
     * and then update the database accordingly.
     */
    public Optional<PeopleDTO> update(PeopleDTO peopleDTO,String id) {
        PeopleDO fromDb = peopleDAO.find(id);
        if (fromDb == null) {
            return Optional.empty();
        }
        PeopleDO peopleDO = PeopleMapper.fromTransfer(peopleDTO);
        if(peopleDO.getName() != null) {
            fromDb.setName(peopleDTO.getName());
        }
        if(peopleDO.getEmails() != null) {
            fromDb.setEmails(peopleDTO.getEmails());
        }
        if(peopleDO.getFavoriteProgrammingLanguage() != null) {
            fromDb.setFavoriteProgrammingLanguage(peopleDTO.getFavoriteProgrammingLanguage());
        }
        peopleDO = peopleDAO.update(fromDb);
        return Optional.of(PeopleMapper.toTransfer(fromDb));
    }

    /**
     * Sending the person with the given id to be deleted from the database.
     */
    public void delete(String id) {
        peopleDAO.delete(id);
    }
}
