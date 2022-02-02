package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import data.domain.Status;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;
import data.services.PeopleService;
import data.services.TaskService;
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
            System.out.println(json);
            TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
            tasksDTO.setOwnerId(ownerid);
//            tasksDTO.setOwnerId(person.get().getEmails());
            tasksDTO = taskService.create(tasksDTO);
            return ok(Json.toJson(tasksDTO));
        } catch (RuntimeException e) {
            return badRequest(e.getMessage());
        }
//        return notFound("A person with id '" + ownerid + "' does not exist.");
    }
    //GET     /api/people/:id/tasks/?status
    public Result allTasks(String ownerId, String status){
        System.out.println("allTasks in Controller");
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
}
