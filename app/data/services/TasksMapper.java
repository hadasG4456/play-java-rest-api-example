package data.services;

import data.domain.TasksDO;
import data.dto.TasksDTO;
import java.util.UUID;

/**
 * Mapper responsible for transfer 2 objects- to input and from input.
 */
public class TasksMapper {
    /**
     * copy the argument from the DO to a DTO and returns it.
     * Calling it means that we want to get data from the database.
     */
    public static TasksDTO toTransfer(TasksDO domain) {
        TasksDTO dto = new TasksDTO();
        dto.setId(domain.getId());
        dto.setTitle(domain.getTitle());
        dto.setDueDate(domain.getDueDate());
        dto.setOwnerId(domain.getOwnerId());
        dto.setDetails(domain.getDetails());
        dto.setStatus((domain.getStatus()));
        return dto;
    }

    /**
     * copy the argument to the DTO to the DO and returns it.
     * Calling it means that we want to send data the database.
     */
    public static TasksDO fromTransfer(TasksDTO dto) {
        TasksDO domain = new TasksDO();
        domain.setId(UUID.randomUUID().toString());
        domain.setTitle(dto.getTitle());
        domain.setDetails(dto.getDetails());
        domain.setDueDate(dto.getDueDate());
        domain.setStatus(dto.getStatus());
        domain.setOwnerId(dto.getOwnerId());
        return domain;
    }
}
