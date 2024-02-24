package com.anuj.learnSpringMVC.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    @Size(min = 1, max = 20, message = "Username should be between 1 and 20 inclusive")
    private String userName;

    @Column(name = "description")
    @Size(min = 1, max = 200, message = "Username should be between 1 and 20 inclusive")
    private String description;

    @Column(name = "target_date", columnDefinition = "DATE")
    @FutureOrPresent
    private LocalDate targetDate;

    @Column(name = "is_done")
    private Boolean isDone;

    public TodoEntity(Integer id, String userName, String description, LocalDate targetDate, Boolean isDone) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public TodoEntity(String userName, String description, LocalDate targetDate, Boolean isDone) {
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public TodoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }
}
