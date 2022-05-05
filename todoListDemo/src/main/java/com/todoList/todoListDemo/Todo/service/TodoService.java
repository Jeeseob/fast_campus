package com.todoList.todoListDemo.Todo.service;

import com.todoList.todoListDemo.Dto.TodoRequest;
import com.todoList.todoListDemo.Todo.model.TodoEntity;
import com.todoList.todoListDemo.Todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository todoRepository;

    /**
     * todo 리스트 목록에 아이템을 추가
     * @param todoRequest
     * @return
     */
    public TodoEntity add(TodoRequest todoRequest) {
        TodoEntity todoEntity = new TodoEntity();

        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setOrder(todoRequest.getOrder());
        todoEntity.setCompleted(todoRequest.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    /**
     * todo  리스트 목록 중 특정 아이템을 조회
     * @param id
     * @return
     */
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * todo 리스트 전체 목록을 조회
     * @return
     */
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    /**
     * todo 리스트 목록 중 특정 아이템을 수정
     * @param id
     * @param todoRequest
     * @return
     */
    public TodoEntity updateById(Long id, TodoRequest todoRequest) {
        TodoEntity todoEntity = this.searchById(id);

        if(todoRequest.getTitle() != null) {
            todoEntity.setTitle(todoRequest.getTitle());
        }

        if(todoRequest.getOrder() != null) {
            todoEntity.setOrder(todoRequest.getOrder());
        }

        if (todoRequest.getCompleted() != null) {
            todoEntity.setCompleted(todoRequest.getCompleted());
        }

        return this.todoRepository.save(todoEntity);
    }

    /**
     * todo 리스트 목록 중 특정 아이템을 삭제
     * @param id
     */
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    /**
     *	todo 리스트 전체 목록을 삭제
     */
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
