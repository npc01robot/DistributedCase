package com.robot.item.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.robot.item.domain.dto.ItemDTO;
import com.robot.item.domain.dto.OrderDto;
import com.robot.item.domain.po.Item;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface IItemService extends IService<Item> {
    List<ItemDTO> queryItemByIds(Collection<Long> ids);
    boolean deductStock(OrderDto orderDto);
}
