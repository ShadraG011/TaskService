package ru.shadrag.hw6.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //region КОНСТРУКТОРЫ
    public User() {
    }

    public User(String username) {
        this.username = username;
    }
    //endregion

    //region ГЕТТЕРЫ И СЕТТЕРЫ
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Task> getUserTasksList() {
        return userTasksList;
    }

    public void setUserTasksList(List<Task> userTasksList) {
        this.userTasksList = userTasksList;
    }

    //endregion

    //region ПОЛЯ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Task> userTasksList;
    //endregion
}
