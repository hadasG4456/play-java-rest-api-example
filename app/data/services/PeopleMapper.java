package data.services;

import data.domain.PeopleDO;
import data.dto.PeopleDTO;
import java.util.UUID;

/**
 * Mapper responsible for transfer 2 objects- to input and from input.
 */
public class PeopleMapper {
    /**
     * copy the argument from the DO to a DTO and returns it.
     */
    public static PeopleDTO toTransfer(PeopleDO domain) {
        PeopleDTO dto = new PeopleDTO();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setEmails(domain.getEmails());
        dto.setFavoriteProgrammingLanguage(domain.getFavoriteProgrammingLanguage());

        return dto;
    }

    /**
     * copy the argument to the DTO to the DO and returns it.
     */
    public static PeopleDO fromTransfer(PeopleDTO dto) {
        PeopleDO domain = new PeopleDO();
        domain.setId(UUID.randomUUID().toString());
        domain.setName(dto.getName());
        domain.setEmails(dto.getEmails());
        domain.setFavoriteProgrammingLanguage(dto.getFavoriteProgrammingLanguage());

        return domain;
    }

}
