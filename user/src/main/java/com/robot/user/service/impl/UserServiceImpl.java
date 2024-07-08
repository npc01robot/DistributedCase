package com.robot.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.user.domain.dto.UserDto;
import com.robot.user.domain.po.User;
import com.robot.user.domain.vo.UserVo;
import com.robot.user.mapper.UserMapper;
import com.robot.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{

    @Override
    public UserVo createUser(UserDto userDto) {
        Assert.notNull(lambdaQuery().eq(User::getUsername, userDto.getUsername()).one(),"已存在该用户");
        User user = BeanUtil.copyProperties(userDto,User.class);
        save(user);
        return BeanUtil.copyProperties(user,UserVo.class);
    }
}
