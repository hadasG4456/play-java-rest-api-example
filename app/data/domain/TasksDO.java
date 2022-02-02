package data.domain;

import com.typesafe.config.Optional;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;

/**
 * This DO is the definition of the TaskDO database in H2- it defines all the columns and the
 * primary key of the table, and it has all the setters and getters for al of the fields.
 * Columns - id (unique), title (unique), details, duedate, status and ownerId.
 * Primary key - id.
 */

@Entity
@Table(name = "TasksDO")
public class TasksDO {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column (name = "title", nullable = false, unique = true)
    private String title;

    @Column (name = "details", nullable = false)
    private String details;

    @Temporal(value = TemporalType.DATE)
    @Column (name = "dueDate", nullable = false)
    private Date dueDate;

    @Column (name = "status", nullable = false)
    @Optional
    private Status status = Status.active;

    @Type(type = "string")
    @Lob
    @Column (name = "ownerId", nullable = false)
    private String ownerId;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOwnerId(String ownerId) {this.ownerId = ownerId;}

    public void setId(String id) { this.id = id;}
}
