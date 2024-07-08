package com.robot.cart.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart")
public class Cart {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private int userId;
    private int productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private Boolean isSubmit;
}
