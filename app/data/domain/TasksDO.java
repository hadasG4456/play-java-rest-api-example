package data.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TasksDO {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column (name = "title", nullable = false)
    private String title;

    @Column (name = "details", nullable = false)
    private String details;

    @Temporal(value = TemporalType.DATE)
    @Column (name = "dueDate", nullable = false)
    private Date dueDate;

    @Column (name = "status", nullable = false)
    private String status; //TODO: create a status class

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

    public String getStatus() {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
