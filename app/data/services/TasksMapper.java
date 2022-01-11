package data.services;

import data.domain.PeopleDO;
import data.domain.TasksDO;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;

public class TasksMapper {
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

    public static TasksDO fromTransfer(TasksDTO dto) {
        TasksDO domain = new TasksDO();
        domain.setTitle(dto.getTitle());
        domain.setDetails(dto.getDetails());
        domain.setDueDate(dto.getDueDate());
        domain.setStatus(dto.getStatus());
        domain.setOwnerId(dto.getOwnerId());

        return domain;
    }
}
