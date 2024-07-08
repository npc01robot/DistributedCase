package com.robot.cart.controller;


import com.robot.cart.domain.dto.CartFormDTO;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVO;
import com.robot.cart.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @GetMapping
    public List<CartVO> queryMyCarts(){
        return cartService.queryMyCarts();
    }

    @GetMapping("/submit")
    public String submit(){
        return cartService.submitCart();

    }
}
