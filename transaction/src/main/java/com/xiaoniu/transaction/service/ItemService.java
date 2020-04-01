package com.xiaoniu.transaction.service;

import com.xiaoniu.transaction.controller.Valid.ItemValid;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.service.model.ItemModel;

public interface ItemService {
    //通过itemId查找商品
    ItemModel getItemModelByItemId(Integer ItemId) throws BusinessException;

    ItemModel addItem(ItemValid itemValid) throws BusinessException;
}
