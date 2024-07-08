package com.robot.user.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private Integer balance;
}
