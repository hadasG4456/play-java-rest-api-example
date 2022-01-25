package data.services;
import com.google.inject.Inject;
import data.domain.PeopleDAO;
import data.domain.PeopleDO;
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
        System.out.println("create in peopleservice");
        PeopleDO peopleDO = PeopleMapper.fromTransfer(peopleDTO);
        peopleDO = peopleDAO.create(peopleDO);
        return PeopleMapper.toTransfer(peopleDO);
    }

    public Optional<PeopleDTO> update(PeopleDTO peopleDTO,String id) {
        PeopleDO fromDb = peopleDAO.find(id);
        if (fromDb == null) {
            return Optional.empty();
        }

//        fromDb.setId(peopleDTO.getId());
        fromDb.setName(peopleDTO.getName());
        fromDb.setEmails(peopleDTO.getEmails());
        fromDb.setFavoriteProgrammingLanguage(peopleDTO.getFavoriteProgrammingLanguage());
        fromDb = peopleDAO.update(fromDb);

        return Optional.of(PeopleMapper.toTransfer(fromDb));
    }

    public void delete(String id) {
        peopleDAO.delete(id);
    }
}
