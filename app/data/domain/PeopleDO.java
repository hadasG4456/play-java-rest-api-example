package data.domain;

import javax.persistence.*;

/**
 * This DO is the definition of the PeopleDO database in H2- it defines all the columns and the
 * primary key of the table, and it has all the setters and getters for al of the fields.
 * Columns - id (unique), name, emails (unique) and favoriteProgrammingLanguage.
 * Primary key - id.
 */
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
