package com.backend.code.pomodoro_timer.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserDTO {

    private Long id;
    private String name;
}
