package com.xiaoniu.transaction.service.impl;

import com.xiaoniu.transaction.dao.ItemDetailDOMapper;
import com.xiaoniu.transaction.dataObject.ItemDetailDO;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.service.ItemService;
import com.xiaoniu.transaction.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemInfoDOMapper itemInfoDOMapper;
    @Autowired
    private ItemDetailDOMapper itemDetailDOMapper;


    @Override
    public ItemModel selectByItemId(Integer itemId) throws BusinessException {
        if (itemId == null) {
            return null;
        }
        System.out.println ( itemId );
        ItemInfoDO itemInfoDO=itemInfoDOMapper.selectById ( itemId );

        ItemDetailDO itemDetailDO = itemDetailDOMapper.selectByItemId ( itemId );

        System.out.println ( itemDetailDO );


        ItemModel itemModel = new ItemModel ();
        BeanUtils.copyProperties ( itemInfoDO, itemModel );
        BeanUtils.copyProperties ( itemDetailDO, itemModel );


        return itemModel;
    }
}
