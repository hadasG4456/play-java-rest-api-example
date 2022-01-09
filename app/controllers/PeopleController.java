package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;

import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PeopleController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result allPeople() {return ok("success");}

    public Result createPerson(Http.Request request){
       JsonNode json = request.body().asJson();
       return ok(json);
    }
    public Result getPerson(UUID id){
        return ok("placeholder to get id " +id);
    }
    public Result patchPerson(UUID id, Http.Request request){
        return ok("place holder for id to patch"+id);
    }
    public  Result deletePerson(UUID id){
        return ok("placeholder for id to delete"+id);
    }

}
