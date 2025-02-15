package com.example.todo.mapper;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.dtos.TodoResponse;
import com.example.todo.dtos.UpdateTodoRequest;
import com.example.todo.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo toEntity(TodoRequest request){
        return Todo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .done(request.isDone())
                .build();
    }

    public TodoResponse toDTO(Todo todo){
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isDone()
        );
    }

}
