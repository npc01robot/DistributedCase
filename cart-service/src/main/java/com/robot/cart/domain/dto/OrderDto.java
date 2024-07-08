package com.robot.cart.domain.dto;

import lombok.Data;

// 简化开发这里舍去订单
@Data
public class OrderDto {
    private Integer productId;
    private Integer quantity;
}
