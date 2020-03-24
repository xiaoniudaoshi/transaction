package com.xiaoniu.transaction.service;

import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.service.model.ItemModel;

public interface ItemService {
    //通过itemId查找商品
    ItemModel selectByItemId(Integer ItemId) throws BusinessException;

}
