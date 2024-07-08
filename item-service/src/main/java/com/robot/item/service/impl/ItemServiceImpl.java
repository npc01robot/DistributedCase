package com.robot.item.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.item.domain.dto.ItemDTO;
import com.robot.item.domain.dto.OrderDto;
import com.robot.item.domain.po.Item;
import com.robot.item.mapper.ItemMapper;
import com.robot.item.service.IItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Override
    public boolean deductStock(OrderDto orderDto) {
        // 库存扣减
        Item item = baseMapper.selectById(orderDto.getProductId());
        Assert.notNull(item,"未找到该商品");
        // 下架或删除
        if (item.getStatus().equals(2) || item.getStatus().equals(3)){
            return false;
        }
        //检查库存
        if (item.getStock() < orderDto.getQuantity()) {
            return false;
        }
        item.setStock(item.getStock() - orderDto.getQuantity());
        lambdaUpdate()
                .set(Item::getStock, item.getStock())
                .set(item.getStock() <= 0,Item::getStatus,2)
                .eq(Item::getId,item.getId())
                .update();
        return true;
    }

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        List<Item> item = lambdaQuery().in(Item::getId, ids).list();
        return BeanUtil.copyToList(item, ItemDTO.class);
    }
}
