package data.dto;

import java.util.Date;
import java.util.UUID;

public class TasksDTO {
    String id, ownerId;
    String title, details, status;
    Date dueDate;

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
