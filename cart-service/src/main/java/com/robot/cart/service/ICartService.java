package com.robot.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.robot.cart.domain.dto.CartFormDTO;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 订单详情表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface ICartService extends IService<Cart> {

    List<CartVO> queryMyCarts();

    String submitCart() ;
}
