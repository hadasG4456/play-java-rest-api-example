package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import data.dto.PeopleDTO;
import data.dto.TasksDTO;
import data.services.TaskService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

public class TasksController extends Controller {
    private TaskService taskService;

    //GET     /api/people/:id/tasks
    public Result allTasks(String ownerId){
        System.out.println("allTasks in Controller");
        List<TasksDTO> tasksDTOList = taskService.getAll(ownerId);
        return ok(Json.toJson(tasksDTOList));
    }
    public Result createTask(String id, Http.Request request) {
//        JsonNode json = request.body().asJson();
//        TasksDTO tasksDTO = Json.fromJson(json, TasksDTO.class);
//        try {
//            tasksDTO = taskService.create(tasksDTO);
//            return ok(Json.toJson(tasksDTO));
//        } catch (RuntimeException e) {
//            notFound("A person with email '" + tasksDTO.getOwnerId() + "' does not exist.");
//        }
//        return notFound("A person with email '" + tasksDTO.getOwnerId() + "' does not exist.");
    }
    //GET     /api/tasks/:id
    public Result getTask(String id){
        return ok(Json.toJson(taskService.getById(id)));
    }
}
