package data.dto;

import java.util.UUID;

public class PeopleDTO {
    String id;
    String name, emails, favoriteProgrammingLanguage;

//    public PeopleDTO(String name, String emails, String favoriteProgrammingLanguage) {
//        this.name = name;
//        this.emails = emails;
//        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
//    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmails() {
        return emails;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public void setId(String id) {
        this.id = id;
    }
}
