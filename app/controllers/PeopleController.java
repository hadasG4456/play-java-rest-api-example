package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import data.dto.PeopleDTO;
import data.services.PeopleService;
import org.h2.engine.ConnectionInfo;
import org.h2.engine.Database;
import org.springframework.asm.SpringAsmInfo;
import play.libs.Json;
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
        try {
            PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
            System.out.println("copied input to peopleDTO");
            peopleDTO = peopleService.create(peopleDTO);
            System.out.println("Created peopleDTO in db");
            return ok(Json.toJson(peopleDTO));
        } catch (RuntimeException e) {
            // Most probably invalid data
            throw e;
        }
//       return ok(json);
    }
    public Result getPerson(UUID id){
        return ok("placeholder to get id " +id);
    }
    public Result patchPerson(UUID id, Http.Request request){
        return ok("place holder for id to patch"+id);
    }
    public  Result deletePerson(String id){
        return ok("placeholder for id to delete"+id);
    }

}
