package com.xiaoniu.transaction.controller;

import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.response.CommonReturnType;
import com.xiaoniu.transaction.service.ItemService;
import com.xiaoniu.transaction.service.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //通过item_id查找商品
    @GetMapping("/selectByItemId")
    public CommonReturnType selectByItemId(@RequestParam("itemId") Integer itemId) throws BusinessException {
        ItemModel itemModel = itemService.selectByItemId (itemId);
        return CommonReturnType.create(itemModel);
    }

}
