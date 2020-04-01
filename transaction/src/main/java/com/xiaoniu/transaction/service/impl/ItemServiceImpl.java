package com.xiaoniu.transaction.service.impl;

import com.xiaoniu.transaction.controller.Valid.ItemValid;
import com.xiaoniu.transaction.dao.ItemDetailDOMapper;
import com.xiaoniu.transaction.dao.ItemInfoDOMapper;
import com.xiaoniu.transaction.dataObject.ItemDetailDO;
import com.xiaoniu.transaction.dataObject.ItemDetailDOWithBLOBs;
import com.xiaoniu.transaction.dataObject.ItemInfoDO;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.error.EmBusinessError;
import com.xiaoniu.transaction.service.ItemService;
import com.xiaoniu.transaction.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemInfoDOMapper itemInfoDOMapper;
    @Autowired
    private ItemDetailDOMapper itemDetailDOMapper;


    @Override
    public ItemModel getItemModelByItemId(Integer itemId) throws BusinessException {
        if (itemId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "itemId为空");
        }
        //查info
        ItemInfoDO itemInfoDO = itemInfoDOMapper.selectByPrimaryKey(itemId);
        if (itemInfoDO == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST);
        }
        //查detail
        ItemDetailDOWithBLOBs itemDetailDO = itemDetailDOMapper.selectByItemId(itemId);
        if (itemDetailDO == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST, "商品内容不存在");
        }
        //合并成model
        return this.convertModelFromDO(itemInfoDO, itemDetailDO);
    }

    @Override
    @Transactional
    public ItemModel addItem(ItemValid itemValid) throws BusinessException {
        if (itemValid == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "itemValid为空");
        }
        //infoDO
        if (itemValid.getPrice()<0&&itemValid.getPrice()!=-1){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"价格输入错误");
        }
        ItemInfoDO itemInfoDO = new ItemInfoDO();
        BeanUtils.copyProperties(itemValid, itemInfoDO);
        //获取当前时间
        Timestamp now = new Timestamp(System.currentTimeMillis());
        itemInfoDO.setAddTime(now);
        itemInfoDOMapper.insertSelective(itemInfoDO);
        //detailDO
        ItemDetailDOWithBLOBs itemDetailDO = new ItemDetailDOWithBLOBs();
        BeanUtils.copyProperties(itemValid, itemDetailDO);
        itemDetailDO.setItemId(itemInfoDO.getItemId());
        itemDetailDOMapper.insertSelective(itemDetailDO);
        return this.getItemModelByItemId(itemInfoDO.getItemId());
    }

    private ItemModel convertModelFromDO(ItemInfoDO itemInfoDO, ItemDetailDO itemDetailDO) {
        if (itemInfoDO == null || itemDetailDO == null) {
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemInfoDO, itemModel);
        BeanUtils.copyProperties(itemDetailDO, itemModel);
        return itemModel;
    }

}
