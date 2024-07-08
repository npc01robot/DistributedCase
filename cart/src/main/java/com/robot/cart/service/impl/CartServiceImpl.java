package com.robot.cart.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVo;
import com.robot.cart.mapper.CartMapper;
import com.robot.cart.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    // 查询信息  注意分布式 熔断限流
    @Override
    public List<CartVo> getCartDetails(List<Integer> cartIds) {
        // 1、获取cartids 包含的所有信息

        // 2、获取cartids下属Product信息

        // 3、合并信息并返回

        return List.of();
    }

    // 下订单  该部分需要支持seata进行分布式事务
    @Override
    public boolean order(List<Integer> cartIds) {
        // 1、订单状态修改

        // 2、库存扣减

        // 3、余额扣减
        return false;
    }
}
