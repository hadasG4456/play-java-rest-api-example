package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
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

import java.util.List;
import java.util.Optional;

public class TasksController extends Controller {
    @Inject
    private TaskService taskService;
    @Inject
    private PeopleService peopleService;


    public Result createTask(String ownerid, Http.Request request) {
        // If the person doesnt exists the getPerson function will throw bad request
//        Result person = peopleController.getPerson(ownerid);
        try {

            Optional<PeopleDTO> person = peopleService.getById(ownerid);
            if (!person.isPresent())
                return notFound("A person with id '" + ownerid + "' does not exist.");
            JsonNode json = request.body().asJson();
            TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
            if (taskService.getByTitle(tasksDTO.getTitle()).isPresent())
                return badRequest("A task with title: " + tasksDTO.getTitle() + "already exists.");
            tasksDTO.setOwnerId(ownerid);
            if (tasksDTO.getStatus() == null) {
                tasksDTO.setStatus(Status.active);
            }
//            tasksDTO.setOwnerId(person.get().getEmails());
            tasksDTO = taskService.create(tasksDTO);
            return ok(Json.toJson(tasksDTO));
        } catch (RuntimeException e) {
            return badRequest("A person with id '" + ownerid + "' does not exist.");
        }
//        return notFound("A person with id '" + ownerid + "' does not exist.");
    }
    //GET     /api/people/:id/tasks/?status
    public Result allTasks(String ownerId, String status){
        if (status != null) {
            Status st = Status.valueOf(status);
            return ok(Json.toJson(taskService.getAll(ownerId, st)));
        }
        return ok(Json.toJson(taskService.getAll(ownerId)));
    }

    //GET     /api/tasks/:id
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
                return notFound("Didn't find the task outside of update.");
//            return task.isPresent() ? ok(Json.toJson(task.get())) : notFound("A task with the id '" + id + "' does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
            return notFound("A task with the id '" + id + "' does not exist.");
        }
    }

    public  Result deleteTask(String id){
        Optional<TasksDTO> task = taskService.getById(id);
        if (task.isPresent()){
            taskService.delete(id, task.get().getOwnerId());
            return ok("task with id: "+id + " removed successfully");
        }
        return notFound("A task with the id '" + id + "' does not exist.");
    }

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
            return ok(Json.toJson(task.get()));
        }
        else
            return notFound("A task with the id '" + id + "' does not exist.");

    }

    public Result putOwner(String id, Http.Request request){
        JsonNode jsonBody = request.body().asJson();
        JsonNode json = Json.parse("{ \"ownerId\" : "+jsonBody+"}");
        TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
        tasksDTO.setId(id);
        Optional<TasksDTO> changedOwner = taskService.getById(json.asText());
        if (!changedOwner.isPresent()) {
            return notFound("A person with the id '" + jsonBody.asText() + "' does not exist.");
        }
        Optional<TasksDTO> task = taskService.getById(id);
        if (task.isPresent()) {
            task = taskService.update(tasksDTO, id);
            return ok(Json.toJson(task.get()));
        }
        else
            return notFound("A task with the id '" + id + "' does not exist.");

    }
}
