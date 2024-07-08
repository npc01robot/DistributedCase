package com.robot.cart.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.cart.client.ItemClient;
import com.robot.cart.domain.dto.CartFormDTO;
import com.robot.cart.domain.dto.ItemDTO;
import com.robot.cart.domain.dto.OrderDto;
import com.robot.cart.domain.po.Cart;
import com.robot.cart.domain.vo.CartVO;
import com.robot.cart.mapper.CartMapper;
import com.robot.cart.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    // private final IItemService itemService;
    private final ItemClient itemClient;

    @Override
    public List<CartVO> queryMyCarts() {
        // 1.查询我的购物车列表
        List<Cart> cartList = lambdaQuery().eq(Cart::getUserId, 1).list();
        // 2.转换VO
        List<CartVO> cartVOList = BeanUtil.copyToList(cartList,CartVO.class);
        // 3.处理VO中的商品信息
        handleCartItems(cartVOList);
        // 4.返回
        return cartVOList;
    }

    @Override
    public String submitCart() {
        List<Cart> cartList = lambdaQuery().eq(Cart::getUserId, 1).list();

        for (Cart cart: cartList){
            OrderDto orderDto = new OrderDto();
            orderDto.setProductId(Math.toIntExact(cart.getItemId()));
            orderDto.setQuantity(cart.getNum());
            try{
                if (itemClient.deductItem(orderDto)){
                    lambdaUpdate().eq(Cart::getId,cart.getId())
                            .set(Cart::getNum,0)
                            .update();
                }
            } catch (Exception e){
                System.out.println("e = " + e);
            }
        }

        return "成功";
    }

    private void handleCartItems(List<CartVO> vos) {
        // 1.获取商品id TODO 处理商品信息
        Set<Long> itemIds = vos.stream().map(CartVO::getItemId).collect(Collectors.toSet());
        // 2.查询商品
        List<ItemDTO> items = itemClient.queryItemByIds(itemIds);
        if (CollUtil.isEmpty(items)) {
        }
        // 3.转为 id 到 item的map
        Map<Long,ItemDTO> itemDTOMap = items.stream().collect(Collectors.toMap(ItemDTO::getId, Function.identity()));
        // 4.写入vo
        for (CartVO cartVO : vos) {
            ItemDTO item = itemDTOMap.get(cartVO.getItemId());

            if (item == null) {
                continue;
            }
            cartVO.setNewPrice(item.getPrice());
            cartVO.setStatus(item.getStatus());
            cartVO.setStock(item.getStock());
        }
    }
}