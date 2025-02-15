package com.example.todo.controller;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.dtos.TodoResponse;
import com.example.todo.dtos.UpdateTodoRequest;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public String addTodo(@RequestBody TodoRequest request) {
        Long savedId = service.addTodo(request);
        return "Todo saved with Id: " + savedId;
    }

    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable("id") Long id) {
        return service.getTodo(id);
    }


    @GetMapping("/todos")
    public List<TodoResponse> getAllTodos() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return "deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateTodo(@PathVariable Long id , @RequestBody UpdateTodoRequest request) {
        request.setId(id);
        service.updateTodo(request);
        return "updated";
    }

}
