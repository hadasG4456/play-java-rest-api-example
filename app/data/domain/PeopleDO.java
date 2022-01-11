package data.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "people")
public class PeopleDO {
    @Id
    @Column(name = "id")
    private String id;

    @Column (name = "name")
    private String name;

    @Column (name = "emails")
    private String emails;

    @Column (name = "favoriteProgrammingLanguage")
    private String favoriteProgrammingLanguage;

    //TODO: connect tasks to person

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
//    @Column
//    private Tasks
}
