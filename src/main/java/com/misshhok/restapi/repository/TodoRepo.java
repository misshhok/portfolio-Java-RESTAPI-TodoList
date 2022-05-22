package com.misshhok.restapi.repository;



import com.misshhok.restapi.entity.TodoEntity;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}