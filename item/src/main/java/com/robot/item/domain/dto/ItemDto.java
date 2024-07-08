package com.robot.item.domain.dto;

import lombok.Data;

@Data
public class ItemDto {
    private String name;
    private String type;
    private String content;
    private Integer price;
    private Integer quantity;
}
