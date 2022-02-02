package data.dto;

/**
 * This DTO represents the structure of the PeopleDO table.
 * contain storage and methods related to the table.
 */
public class PeopleDTO {
    String id;
    String name, emails, favoriteProgrammingLanguage;


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
