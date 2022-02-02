package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import data.domain.Status;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;
import data.services.PeopleService;
import data.services.TaskService;
import org.apache.commons.lang3.EnumUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import java.util.Optional;

/**
 * This controller contains the actions to handle HTTP requests for tasks
 * Responsible for the TasksDO table.
 * (HTTP requests that have the beginning URL http://localhost:9000/api/people/?:id/tasks/ or
 * http://localhost:9000/api/tasks/:id).
 * For each function here- there is a helping function in TaskService.
 */

public class TasksController extends Controller {
    @Inject
    private TaskService taskService;
    @Inject
    private PeopleService peopleService;

    /**
     *  GET http://localhost:9000/api/people/?:id/tasks/?status=active|done
     *  Returns all the tasks of a person whose id is given.
     *  If the status flag matches with the ENUM of Status- returns only the tasks
     *  that have this status.
     *  If there are is not a person with the id - returns an error.
     *  If there are not any tasks - returns an empty list.
     */
    public Result allTasks(String ownerId, String status){
        if (status != null) {
            Status st = Status.valueOf(status);
            return ok(Json.toJson(taskService.getAll(ownerId, st)));
        }
        return ok(Json.toJson(taskService.getAll(ownerId)));
    }

    /**
     *  POST http://localhost:9000/api/people/:id/tasks/
     *  Creates a new task for the person whose id is given.
     *  In the body of the request are the details of the person - for example :
     *  {
     *    "title": "string",
     *    "details": "string",
     *    "dueDate": "2022-02-02",
     *    ?"status" : "active"
     *  }
     *  If the status field is not in the request- the default is ACTIVE.
     *  If there is a task with the same title- returns an error.
     *  If there is not someone with the given id- returns an error.
     *  On success returns details of the task.
     */
    public Result createTask(String ownerid, Http.Request request) {
        try {
            Optional<PeopleDTO> person = peopleService.getById(ownerid);
            if (!person.isPresent())
                return notFound("A person with id '" + ownerid + "' does not exist.");
            JsonNode json = request.body().asJson();
            TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
            if (taskService.getByTitle(tasksDTO.getTitle()).isPresent())
                return badRequest("A task with title: " + tasksDTO.getTitle() + " already exists.");
            tasksDTO.setOwnerId(ownerid);
            if (tasksDTO.getStatus() == null) {
                tasksDTO.setStatus(Status.active);
            }
            tasksDTO = taskService.create(tasksDTO);
            return created(Json.toJson(tasksDTO));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return badRequest("something went wrong");
        }
    }

    /**
     *  GET http://localhost:9000/api/tasks/:id
     *  Returns the task with the given id.
     *  If there is not any task with that id - returns an error.
     *  On success returns the details of the task.
     */
    public Result getTask(String id){
        try {
            Optional<TasksDTO> task = taskService.getById(id);
            if (task.isPresent())
                return ok(Json.toJson(task.get()));
        } catch (Exception e) {
            return notFound("A task with the id '" + id + "' does not exist.");
        }
        return notFound("A task with the id '" + id + "' does not exist.");
    }

    /**
     *  PATCH http://localhost:9000/api/tasks/:id
     *  Change details of the task whose id is the same as in the URL.
     *  Not all fields are required to be changed.
     *  In the body of the request are the details that are need to be changed  - for example :
     *  {
     *   "dueDate": "2022-02-04",
     * }
     *  If there is not any task with that id - returns an error.
     *  If there is a task with the title that is given - returns an error.
     *  On success returns the new details of the task.
     */
    public Result patchTask(String id, Http.Request request){
        try {
            JsonNode json = request.body().asJson();
            TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
            tasksDTO.setId(id);
            if (tasksDTO.getTitle() != null && taskService.getByTitle(tasksDTO.getTitle()).isPresent())
                return badRequest("A task with title: " + tasksDTO.getTitle() + " already exists.");
            Optional<TasksDTO> task = taskService.getById(id);
            if (task.isPresent()) {
                task = taskService.update(tasksDTO, id);
                return ok(Json.toJson(task.get()));
            }
            else
                return notFound("A task with the id '" + id + "' does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
            return notFound("A task with the id '" + id + "' does not exist.");
        }
    }

    /**
     *  DELETE http://localhost:9000/api/tasks/:id
     *  Delete the task with that id in the server.
     *  If there is not any task with that id - returns an error.
     *  On success returns the id of the task which got deleted.
     */
    public  Result deleteTask(String id){
        Optional<TasksDTO> task = taskService.getById(id);
        if (task.isPresent()){
            taskService.delete(id);
            return ok("task with id: "+id + " removed successfully");
        }
        return notFound("A task with the id '" + id + "' does not exist.");
    }

    /**
     *  GET http://localhost:9000/api/tasks/:id/status
     *  Returns the status of task with the given id.
     *  If there is not any task with that id - returns an error.
     *  On success returns the status of the task.
     */
    public Result getStatus(String id){
        try {
            Optional<Status> taskStatus = taskService.getStatus(id);
            if (taskStatus.isPresent())
                return ok(Json.toJson(taskStatus.get()));
        } catch (Exception e) {
            return notFound("A task with the id '" + id + "' does not exist.");
        }
        return notFound("A task with the id '" + id + "' does not exist.");
    }

    /**
     *  PUT http://localhost:9000/api/tasks/:id/status
     *  Change the status of the task whose id is the same as in the URL.
     *  In the body of the request is the new status that need to be changed  - for example :
     *  {
     *   "active"
     * }
     *  If there is not any task with that id - returns an error.
     *  If the body is not a valid Status - returns an error.
     *  On success returns no content HTTP signal.
     *  (the function uses the same logic as the patchTask - as it is a specific case of it)
     */
    public Result putStatus(String id, Http.Request request){
        JsonNode jsonBody = request.body().asJson();
        if (!EnumUtils.isValidEnum(Status.class, jsonBody.asText()))
            return badRequest("value "+ jsonBody.asText() + " is not a legal task status.");
        JsonNode json = Json.parse("{ \"status\" : "+jsonBody+"}");
        TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
        tasksDTO.setId(id);
        Optional<TasksDTO> task = taskService.getById(id);
        if (task.isPresent()) {
            task = taskService.update(tasksDTO, id);
            return noContent();
        }
        else
            return notFound("A task with the id '" + id + "' does not exist.");
    }

    /**
     *  GET http://localhost:9000/api/tasks/:id/owner
     *  Returns the ownerId of task with the given id.
     *  If there is not any task with that id - returns an error.
     *  On success returns the ownerId of the task.
     */
    public Result getOwner(String id){
        try {
            Optional<String> taskStatus = taskService.getOwner(id);
            if (taskStatus.isPresent())
                return ok(Json.toJson(taskStatus.get()));
        } catch (Exception e) {
            return notFound("A task with the id '" + id + "' does not exist.");
        }
        return notFound("A task with the id '" + id + "' does not exist.");
    }

    /**
     *  PUT http://localhost:9000/api/tasks/:id/owner
     *  Change the ownerId of the task whose id is the same as in the URL.
     *  In the body of the request is the new ownerId that need to be changed  - for example :
     *  {
     *   "22875dfb-489b-4a11-95e6-5914112b6a4b"
     * }
     *  If there is not any task with that id - returns an error.
     *  If there is not a person with new ownerId - returns an error.
     *  On success returns no content HTTP signal.
     *  (the function uses the same logic as the patchTask - as it is a specific case of it)
     */
    public Result putOwner(String id, Http.Request request){
        JsonNode jsonBody = request.body().asJson();
        Optional<PeopleDTO> changedOwner = peopleService.getById(jsonBody.asText());
        if (!changedOwner.isPresent()) {
            return notFound("A person with the id '" + jsonBody.asText() + "' does not exist.");
        }
        JsonNode json = Json.parse("{ \"ownerId\" : "+jsonBody+"}");
        TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
        tasksDTO.setId(id);

        Optional<TasksDTO> task = taskService.getById(id);
        if (task.isPresent()) {
            task = taskService.update(tasksDTO, id);
            return noContent();
        }
        else
            return notFound("A task with the id '" + id + "' does not exist.");

    }
}
