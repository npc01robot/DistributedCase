package com.robot.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.robot.user.domain.dto.UserDto;
import com.robot.user.domain.po.User;
import com.robot.user.domain.vo.UserVo;

public interface IUserService extends IService<User> {
    UserVo createUser(UserDto userDto);
}
