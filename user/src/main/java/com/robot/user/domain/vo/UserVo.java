package com.robot.user.domain.vo;

import lombok.Data;

@Data
public class UserVo {
    private int id;
    private String username;
    private String password;
    private Integer balance;
}
