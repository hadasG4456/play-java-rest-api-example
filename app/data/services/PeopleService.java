package data.services;
import com.google.inject.Inject;
import data.domain.PeopleDAO;
import data.domain.PeopleDO;
import data.domain.TasksDO;
import data.dto.PeopleDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


public class PeopleService {
    @Inject
    private PeopleDAO peopleDAO;

    public List<PeopleDTO> getAll() {
        List<PeopleDO> peopleDOList = peopleDAO.find();
        return peopleDOList.stream().map(domain -> PeopleMapper.toTransfer(domain)).collect(Collectors.toList());
    }
    public Optional<PeopleDTO> getById(String id) {
        PeopleDO peopleDO =peopleDAO.find(id);
        if (peopleDO == null) {
            return Optional.empty();
        }

        return Optional.of(PeopleMapper.toTransfer(peopleDO));
    }

    public PeopleDTO create(PeopleDTO peopleDTO) {
        PeopleDO peopleDO = PeopleMapper.fromTransfer(peopleDTO);
        peopleDO = peopleDAO.create(peopleDO);
        return PeopleMapper.toTransfer(peopleDO);
    }

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

    public void delete(String id) {
        peopleDAO.delete(id);
    }
}
