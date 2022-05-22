package com.misshhok.restapi.service;

import com.misshhok.restapi.entity.TodoEntity;
import com.misshhok.restapi.entity.UserEntity;
import com.misshhok.restapi.model.Todo;
import com.misshhok.restapi.repository.TodoRepo;
import com.misshhok.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        todoRepo.save(todo);
        return Todo.toModel(todo);
    }

    public TodoEntity compliteTodo (Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return todoRepo.save(todo);
    }
}
