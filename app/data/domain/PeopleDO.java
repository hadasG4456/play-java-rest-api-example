package data.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PeopleDO")
public class PeopleDO {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "emails", unique = true, nullable = false)
    private String emails;

    @Column (name = "favoriteProgrammingLanguage", nullable = false)
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
