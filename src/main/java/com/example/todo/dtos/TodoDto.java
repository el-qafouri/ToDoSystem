package com.example.todo.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TodoDto {

    @Id
    private Long id;
    private String title;
    private String description;
    private boolean done;
}
