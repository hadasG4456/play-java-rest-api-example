package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import data.dto.PeopleDTO;
import data.services.PeopleService;
import play.libs.Json;
import play.mvc.*;
import java.util.Optional;

/**
 * This controller contains tha actions to handle HTTP requests for people.
 * Responsible for the PeopleDO table.
 * (HTTP requests that have the beginning URL http://localhost:9000/api/people/?:id).
 * For each function here- there is a helping function in PeopleService.
 */
public class PeopleController extends Controller {
    @Inject
    private PeopleService peopleService;

    /**
     *  POST http://localhost:9000/api/people/
     *  Creates a new person.
     *  In the body of the request are the details of the person - for example :
     *  {
     *   "name": "D. J. Wheeler",
     *   "emails": "djw@ESDAC.uk",
     *   "favoriteProgrammingLanguage": "EDSAC Assembly"
     * }
     *  If there is someone with the same email- returns an error.
     *  On success returns details of the person.
     */
    public Result createPerson(Http.Request request) {
        JsonNode json = request.body().asJson();
        PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
        try {
            peopleDTO = peopleService.create(peopleDTO);
            return created(Json.toJson(peopleDTO));
        } catch (RuntimeException e) {
            badRequest("A person with email '" + peopleDTO.getEmails() + "' already exists.");
        }
        return badRequest("A person with email '" + peopleDTO.getEmails() + "' already exists.");
    }

    /**
     *  GET http://localhost:9000/api/people/
     *  Returns all the people in the server.
     *  If there are not any people- returns an empty list
     */
    public Result allPeople() {
        return ok(Json.toJson(peopleService.getAll()));}

    /**
     *  GET http://localhost:9000/api/people/:id
     *  Returns the person with that id in the server.
     *  If there is not any person with that id - returns an error.
     *  On success returns the details of the person.
     */
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

    /**
     *  PATCH http://localhost:9000/api/people/:id
     *  Change details of the person whose id is the same as in the URL.
     *  Not all fields are required to be changed.
     *  In the body of the request are the details that are need to be changed  - for example :
     *  {
     *   "favoriteProgrammingLanguage": "JS"
     * }
     *  If there is not any person with that id - returns an error.
     *  If there is a person with the emails that is given - returns an error.
     *  On success returns the new details of the person.
     */
    public Result patchPerson(String id, Http.Request request){
        try {
            JsonNode json = request.body().asJson();
            PeopleDTO peopleDTO = Json.fromJson(json, PeopleDTO.class);
            if (peopleDTO.getEmails() != null && peopleService.getByEmails(peopleDTO.getEmails()).isPresent()) {
                return badRequest("A person with emails: " + peopleDTO.getEmails() + " already exists.");
            }
            Optional<PeopleDTO> person = peopleService.update(peopleDTO, id);
            return person.isPresent() ? ok(Json.toJson(person.get())) : notFound("A person with the id '" + id + "' does not exist.");
        } catch (Exception e) {
            notFound("A person with the id '" + id + "' does not exist.");
        }
            return notFound("A person with the id '" + id + "' does not exist.");
    }

    /**
     *  DELETE http://localhost:9000/api/people/:id
     *  Delete the person with that id in the server.
     *  If there is not any person with that id - returns an error.
     *  On success returns the id of the person who got deleted.
     */
    public  Result deletePerson(String id){
        Optional<PeopleDTO> person = peopleService.getById(id);
        if (person.isPresent()){
            peopleService.delete(id);
            return ok("Person with id: "+id + " removed successfully");
        }
        return notFound("A person with the id '" + id + "' does not exist.");
    }

}
