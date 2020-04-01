package com.xiaoniu.transaction.controller;

import com.xiaoniu.transaction.controller.VO.ItemPageVO;
import com.xiaoniu.transaction.controller.Valid.ItemValid;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.error.EmBusinessError;
import com.xiaoniu.transaction.response.CommonReturnType;
import com.xiaoniu.transaction.service.ItemService;
import com.xiaoniu.transaction.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //通过item_id查找商品
    @GetMapping("/getItemModelByItemId")
    public CommonReturnType getItemModelByItemId(@RequestParam("itemId") Integer itemId) throws BusinessException {
        ItemModel itemModel = itemService.getItemModelByItemId(itemId);
        return CommonReturnType.create(itemModel);
    }

    //获取商品详情页(不含密码
    @GetMapping("/getItemPageByItemId")
    public CommonReturnType getItemPageByItemId(@RequestParam("itemId") Integer itemId) throws BusinessException {
        ItemModel itemModel = itemService.getItemModelByItemId(itemId);
        ItemPageVO itemPageVO = this.convertVOFromModel(itemModel);
        return CommonReturnType.create(itemPageVO);
    }

    //创建商品
    @PostMapping("/addItem")
    public CommonReturnType addItem(@Valid ItemValid itemValid, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        ItemModel itemModel = itemService.addItem(itemValid);
        return CommonReturnType.create(itemModel);
    }


    private ItemPageVO convertVOFromModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemPageVO itemPageVO = new ItemPageVO();
        BeanUtils.copyProperties(itemModel, itemPageVO);
        return itemPageVO;
    }
}
