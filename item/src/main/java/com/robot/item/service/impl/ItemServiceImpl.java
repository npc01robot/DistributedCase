package com.robot.item.service.impl;

import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.item.domain.po.ItemPo;
import com.robot.item.mapper.ItemMapper;
import com.robot.item.service.IItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemPo> implements IItemService {
    // 库存扣减
    @Override
    public boolean inventoryDeduction(Integer id,Integer quantity) {
        // 1、库存查询
        ItemPo itemPo = lambdaQuery().eq(ItemPo::getId, id).one();
        if (itemPo == null) {
            return false;
        }

        if (quantity > itemPo.getQuantity()) {
            return false;
        }

        // 2、库存扣减
        lambdaUpdate()
                .eq(ItemPo::getId, itemPo.getId())
                .set(quantity < itemPo.getQuantity(),ItemPo::getQuantity,
                        itemPo.getQuantity() - quantity);
        return true;
    }
}
