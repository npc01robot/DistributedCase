package com.robot.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVo;

import java.io.Serializable;
import java.util.List;

public interface ICartService extends IService<Cart>, Serializable {
    List<CartVo> getCartDetails(List<Integer> cartIds);

    boolean order(List<Integer> cartIds);

}
