package com.boot.todo.websocket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.todo.websocket.model.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, String> {
}