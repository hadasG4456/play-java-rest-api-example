package data.services;

import com.google.inject.Inject;
import data.domain.Status;
import data.domain.TasksDAO;
import data.domain.TasksDO;
import data.dto.TasksDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service that connects between the DTOs to the DOs.
 * For each function here- there is a helping function in TaskDAO.
 */
public class TaskService {
    @Inject
    private TasksDAO tasksDAO;

    /**
     * Find every task with the given owner id and make a list to sent as a response (to later
     * create a JSON out of it).
     */
    public List<TasksDTO> getAll(String ownerId) {
        List<TasksDO> tasksDOList = tasksDAO.find(ownerId, true);
        return tasksDOList.stream().map(domain -> TasksMapper.toTransfer(domain)).collect(Collectors.toList());
    }

    /**
     * Find every task with the given owner id and status and make a list to sent as a response (to later
     * create a JSON out of it).
     */
    public List<TasksDTO> getAll(String ownerId, Status status) {
        List<TasksDO> tasksDOList = tasksDAO.find(ownerId, status);
        return tasksDOList.stream().map(domain -> TasksMapper.toTransfer(domain)).collect(Collectors.toList());
    }

    /**
     * Find the task with the given id and returns it (to later create a JSON out of it).
     */
    public Optional<TasksDTO> getById(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO));
    }

    /**
     * Find the task with the given title and returns it (to later create a JSON out of it).
     */
    public Optional<TasksDTO> getByTitle(String title) {
        TasksDO tasksDO = tasksDAO.findByTitle(title);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO));
    }

    /**
     * create a new record of the taskDTO in the database using a helping DO.
     */
    public TasksDTO create(TasksDTO tasksDTO) {
        TasksDO tasksDO = TasksMapper.fromTransfer(tasksDTO);
        tasksDO = tasksDAO.create(tasksDO);
        return TasksMapper.toTransfer(tasksDO);
    }

    /**
     * Check if the id is valid (meaning the database stores a task with the id).
     * If not- returns empty Optional that will cause error in TaskController.
     * If yes- update the relevant information that we got from the JSON's body
     * and then update the database accordingly.
     */
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

    /**
     * Sending the task with the given id to be deleted from the database.
     */
    public void delete(String id) {
        tasksDAO.delete(id);
    }

    /**
     * Check if the id is valid (meaning the database stores a task with the id).
     * If not- returns empty Optional that will cause error in TaskController.
     * If yes- returns its status from the database.
     */
    public Optional<Status> getStatus(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO).getStatus());
    }

    /**
     * Check if the id is valid (meaning the database stores a task with the id).
     * If not- returns empty Optional that will cause error in TaskController.
     * If yes- returns its ownerId from the database.
     */
    public Optional<String> getOwner(String id) {
        TasksDO tasksDO = tasksDAO.find(id);
        if (tasksDO == null) {
            return Optional.empty();
        }
        return Optional.of(TasksMapper.toTransfer(tasksDO).getOwnerId());
    }

}
