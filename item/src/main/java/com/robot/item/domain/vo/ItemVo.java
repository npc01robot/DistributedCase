package com.robot.item.domain.vo;

import lombok.Data;

@Data
public class ItemVo {
    private Integer id;
    private String name;
    private String type;
    private String content;
    private Integer price;
    private Integer quantity;
}
