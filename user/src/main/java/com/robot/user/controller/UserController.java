package com.robot.user.controller;

import cn.hutool.core.bean.BeanUtil;
import com.robot.user.domain.dto.UserDto;
import com.robot.user.domain.po.User;
import com.robot.user.domain.vo.UserVo;
import com.robot.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @GetMapping("{id}")
    public UserVo user(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return BeanUtil.copyProperties(user,UserVo.class);
    }
    @GetMapping
    public List<UserVo> users() {
        List<User> users = userService.list();
        return BeanUtil.copyToList(users,UserVo.class);
    }

    @PostMapping
    public UserVo addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }


}
