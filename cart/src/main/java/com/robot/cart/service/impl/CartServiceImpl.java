package com.robot.cart.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.mapper.CartMapper;
import com.robot.cart.service.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
}
