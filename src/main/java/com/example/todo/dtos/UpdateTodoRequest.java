package com.example.todo.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoRequest {

    private Long id;
    private String title;
    private String description;
    private boolean done;
}
