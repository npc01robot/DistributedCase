package com.robot.cart.domain.vo;

import lombok.Data;

@Data
public class CartVo {
    private int id;
    private int userId;
    private int productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private int newProductPrice;
}
