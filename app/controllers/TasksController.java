package controllers;

import data.services.TaskService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class TasksController extends Controller {
    private TaskService taskService;

    public Result allTasks(String ownerId){
        return ok(Json.toJson(taskService.getAll(ownerId)));
    }

    public Result getTask(String id){
        return ok(Json.toJson(taskService.getById(id)));
    }
}
