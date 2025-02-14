package com.example.todo.controller;

import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping("")
    public String addTodo() {
        service.addTod();
                return "ssss";
    }

}
