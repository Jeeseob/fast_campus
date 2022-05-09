package com.todoList.todoListDemo.Todo.controller;

import com.todoList.todoListDemo.Dto.TodoRequest;
import com.todoList.todoListDemo.Dto.TodoResponse;
import com.todoList.todoListDemo.Todo.model.TodoModel;
import com.todoList.todoListDemo.Todo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/")
public class TodoController {
    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("CREATE");

        if(ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(request.getOrder())) {
            request.setOrder(0L);
        }
        if(ObjectUtils.isEmpty(request.getCompleted())) {
            request.setCompleted(false);
        }
        TodoModel result = this.service.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        log.info("READ ONE");
        TodoModel result = service.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }


    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        log.info("READ ALL");
        List<TodoModel> list = service.searchAll();
        List<TodoResponse> response = list.stream().map(TodoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest request) {
        log.info("UPDATE");
        TodoModel result = service.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        log.info("DELETE ONE");
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        log.info("DELETE ALL");
        service.deleteAll();
        return ResponseEntity.ok().build();
    }
}


