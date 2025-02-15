package com.example.todo.service;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.dtos.TodoResponse;
import com.example.todo.dtos.UpdateTodoRequest;
import com.example.todo.mapper.TodoMapper;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoMapper mapper;

    public Long addTodo(TodoRequest request) {
        Todo todo = mapper.toEntity(request);
        return repository.save(todo).getId();
    }

    public TodoResponse getTodo(Long id) {
        //Todo todo=repository.findById(id).get();
        //or
        Optional<Todo> todo = repository.findById(id);
        return todo.map(value -> mapper.toDTO(value)).orElse(null);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }

    public List<TodoResponse> getAll() {
        List<Todo> todos = repository.findAll();
        return todos.stream().map(m -> mapper.toDTO(m)).toList();
    }

    public Todo updateTodo(UpdateTodoRequest request) {
        Optional<Todo> optionalTodo = repository.findById(request.getId());
        if (optionalTodo.isPresent()) {
            Todo existTodo = optionalTodo.get();
            existTodo.setTitle(request.getTitle());
            existTodo.setDescription(request.getDescription());
            existTodo.setDone(request.isDone());
            return repository.save(existTodo);
        }
        return null;
    }
}
