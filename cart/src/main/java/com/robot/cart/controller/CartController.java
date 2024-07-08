package com.robot.cart.controller;


import cn.hutool.core.bean.BeanUtil;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVo;
import com.robot.cart.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
    private final ICartService cartService;

    @GetMapping
    public List<CartVo> getCarts() {
        List<Cart> list = cartService.list();
        return BeanUtil.copyToList(list, CartVo.class);
    }
}
