package com.robot.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robot.item.domain.po.ItemPo;
import com.robot.item.mapper.ItemMapper;
import com.robot.item.service.IItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemPo> implements IItemService {
}
