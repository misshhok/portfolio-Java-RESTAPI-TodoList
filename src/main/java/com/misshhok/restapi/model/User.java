package com.misshhok.restapi.model;


import com.misshhok.restapi.entity.TodoEntity;
import com.misshhok.restapi.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;

    private List<TodoEntity> todos;
    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos());
        return model;
    }

    public User() {

    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

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
}
