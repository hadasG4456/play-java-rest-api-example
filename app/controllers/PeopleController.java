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

import java.util.Optional;
import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PeopleController extends Controller {
    @Inject
    private PeopleService peopleService;


//    public Result index() {
//        return ok(views.html.index.render());
//    }

    public Result allPeople() {
        System.out.println("all people");
        return ok(Json.toJson(peopleService.getAll()));}

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
    public Result getPerson(String id){

    Optional<PeopleDTO> person = peopleService.getById(id);
    return person.isPresent() ? ok(Json.toJson(person.get())) : notFound();

    }
    public Result patchPerson(String id, Http.Request request){
    JsonNode json = request.body().asJson();
    try {
        PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
        Optional<PeopleDTO> person = peopleService.update(peopleDTO, id);
        return person.isPresent() ? ok(Json.toJson(person.get())) : notFound();
    } catch (Exception e) {
        return badRequest(request.body().asJson());
    }
    }
    public  Result deletePerson(String id){
        return ok("placeholder for id to delete"+id);
    }

}
