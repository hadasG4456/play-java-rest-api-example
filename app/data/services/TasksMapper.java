package data.services;

import data.domain.PeopleDO;
import data.domain.TasksDO;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;

import java.util.UUID;

public class TasksMapper {
    public static TasksDTO toTransfer(TasksDO domain) {
        TasksDTO dto = new TasksDTO();
        dto.setId(domain.getId());
        dto.setTitle(domain.getTitle());
        dto.setDueDate(domain.getDueDate());
        dto.setOwnerId(domain.getOwnerId());
        dto.setDetails(domain.getDetails());
        dto.setStatus((domain.getStatus()));
        System.out.println(dto.getId());
        return dto;
    }

    public static TasksDO fromTransfer(TasksDTO dto) {
        TasksDO domain = new TasksDO();
        domain.setId(UUID.randomUUID().toString());
        domain.setTitle(dto.getTitle());
        domain.setDetails(dto.getDetails());
        domain.setDueDate(dto.getDueDate());
        domain.setStatus(dto.getStatus());
        domain.setOwnerId(dto.getOwnerId());
        System.out.println(domain.getId());
        System.out.println(domain.getTitle());
        System.out.println(domain.getDetails());
        System.out.println(domain.getStatus());
        System.out.println(domain.getOwnerId());
        return domain;
    }
}
