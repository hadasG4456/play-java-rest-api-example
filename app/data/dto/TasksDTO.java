package data.dto;

import data.domain.Status;

import java.util.Date;

/**
 * This DTO represents the structure of the TaskDO table.
 * contain storage and methods related to the table.
 */
public class TasksDTO {
    String id, ownerId;
    String title, details;
    Status status;
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

    public Status getStatus() {
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
