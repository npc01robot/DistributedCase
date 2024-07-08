package com.robot.item.controller;


import cn.hutool.core.bean.BeanUtil;
import com.robot.item.domain.dto.ItemDTO;
import com.robot.item.domain.dto.OrderDto;
import com.robot.item.domain.po.Item;
import com.robot.item.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final IItemService itemService;

    @GetMapping
    public List<ItemDTO> queryItemByIds(@RequestParam("ids") List<Long> ids){
        return itemService.queryItemByIds(ids);
    }

    @GetMapping("{id}")
    public ItemDTO queryItemById(@PathVariable("id") Long id) {
        return BeanUtil.copyProperties(itemService.getById(id), ItemDTO.class);
    }

    @PostMapping
    public void saveItem(@RequestBody ItemDTO item) {
        // 新增
        itemService.save(BeanUtil.copyProperties(item, Item.class));
    }

    @DeleteMapping("{id}")
    public void deleteItemById(@PathVariable("id") Long id) {
        itemService.removeById(id);
    }


    @PostMapping("/deduct")
    public Boolean  deductItem(@RequestBody OrderDto orderDto) {
        //库存扣减
        return itemService.deductStock(orderDto);

    }
}
