package com.todoList.todoListDemo.Todo.repository;

import com.todoList.todoListDemo.Todo.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
