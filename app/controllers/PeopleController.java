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

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PeopleController extends Controller {
    @Inject
    private PeopleService peopleService;


    public Result allPeople() {
        return ok(Json.toJson(peopleService.getAll()));}

    public Result createPerson(Http.Request request) {
        JsonNode json = request.body().asJson();
        PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
        try {
            peopleDTO = peopleService.create(peopleDTO);
            return ok(Json.toJson(peopleDTO));
        } catch (RuntimeException e) {
            badRequest("A person with email '" + peopleDTO.getEmails() + "' already exists.");
        }
       return badRequest("A person with email '" + peopleDTO.getEmails() + "' already exists.");
    }
    public Result getPerson(String id){
        try {
            Optional<PeopleDTO> person = peopleService.getById(id);
            if (person.isPresent())
               return ok(Json.toJson(person.get()));
        } catch (Exception e) {
            return notFound("A person with the id '" + id + "' does not exist.");
        }
        return notFound("A person with the id '" + id + "' does not exist.");
    }
    public Result patchPerson(String id, Http.Request request){
        try {
            JsonNode json = request.body().asJson();
            PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
            Optional<PeopleDTO> person = peopleService.update(peopleDTO, id);
            return person.isPresent() ? ok(Json.toJson(person.get())) : notFound("A person with the id '" + id + "' does not exist.");
        } catch (Exception e) {
            notFound("A person with the id '" + id + "' does not exist.");
        }
            return notFound("A person with the id '" + id + "' does not exist.");
        }
        public  Result deletePerson(String id){
            Optional<PeopleDTO> person = peopleService.getById(id);
            if (person.isPresent()){
                peopleService.delete(id);
                return ok("Person with id: "+id + " removed successfully");
            }
            return notFound("A person with the id '" + id + "' does not exist.");
        }

}
