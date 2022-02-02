package data.services;

import com.google.inject.Inject;
import data.domain.Status;
import data.domain.TasksDAO;
import data.domain.TasksDO;
import data.dto.TasksDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService {
    @Inject
    private TasksDAO tasksDAO;

    public List<TasksDTO> getAll(String ownerId) {
        List<TasksDO> tasksDOList = tasksDAO.find(ownerId, true);
        return tasksDOList.stream().map(domain -> TasksMapper.toTransfer(domain)).collect(Collectors.toList());
//        return new LinkedList<TasksDTO>();
    }
    public List<TasksDTO> getAll(String ownerId, Status status) {
        List<TasksDO> tasksDOList = tasksDAO.find(ownerId, status);
        return tasksDOList.stream().map(domain -> TasksMapper.toTransfer(domain)).collect(Collectors.toList());
    }

    public Optional<TasksDTO> getById(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }

        return Optional.of(TasksMapper.toTransfer(tasksDO));
    }
    public Optional<TasksDTO> getByTitle(String title) {
        TasksDO tasksDO = tasksDAO.findByTitle(title);
        if (tasksDO == null) {
            return Optional.empty();
        }

        return Optional.of(TasksMapper.toTransfer(tasksDO));
    }

    public TasksDTO create(TasksDTO tasksDTO) {
        TasksDO tasksDO = TasksMapper.fromTransfer(tasksDTO);
        tasksDO = tasksDAO.create(tasksDO);
        return TasksMapper.toTransfer(tasksDO);
    }

    public Optional<TasksDTO> update(TasksDTO tasksDTO, String id) {
        TasksDO fromDb = tasksDAO.find(id);
        if (fromDb == null) {
            return Optional.empty();
        }
        TasksDO tasksDO = TasksMapper.fromTransfer(tasksDTO);

        if (tasksDO.getDueDate() != null) {
            fromDb.setDueDate(tasksDTO.getDueDate());
        }
        if (tasksDO.getTitle() != null) {
            fromDb.setTitle(tasksDTO.getTitle());
        }
        if (tasksDO.getDetails() != null) {
            fromDb.setDetails(tasksDTO.getDetails());
        }
        if (tasksDO.getStatus() != null) {
            fromDb.setStatus(tasksDTO.getStatus());
        }
        if (tasksDO.getOwnerId() != null) {
            fromDb.setOwnerId(tasksDTO.getOwnerId());
        }
        tasksDO = tasksDAO.update(fromDb);
        return Optional.of(TasksMapper.toTransfer(fromDb));
    }


    public void delete(String id, String ownerId) {
        tasksDAO.delete(id, ownerId);
    }

    public Optional<Status> getStatus(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO).getStatus());
    }
    public Optional<String> getOwner(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO).getOwnerId());
    }

}
