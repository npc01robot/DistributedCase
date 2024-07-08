package com.robot.item.controller;

import cn.hutool.core.bean.BeanUtil;
import com.robot.item.domain.po.ItemPo;
import com.robot.item.domain.vo.ItemVo;
import com.robot.item.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final IItemService itemService;

    @GetMapping("{id}")
    public ItemVo getItem(@PathVariable("id") int id) {
        ItemPo itemPo = itemService.getById(id);
        return BeanUtil.copyProperties(itemPo, ItemVo.class);
    }

}
