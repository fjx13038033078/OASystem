package com.sjjs.oasystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjjs.oasystem.common.bo.ItemBo;
import com.sjjs.oasystem.common.bo.PageBo;
import com.sjjs.oasystem.common.vo.PageVo;
import com.sjjs.oasystem.common.vo.Result;
import com.sjjs.oasystem.entity.Item;

import java.util.List;

public interface ItemService extends IService<Item> {
    PageVo<Item> getList(PageBo pageBo);

    List<Item> getList();

    void createItemRedis();

    Result<PageVo<Item>> itemListsSearch(String name, PageBo pageBo);

    Result<PageVo<Item>> insert(ItemBo itemBo, PageBo pageBo);

    Result<PageVo<Item>> delete(String projectId, String itemId, PageBo pageBo);

    PageVo<Item> myItem(PageBo pageBo);

    List<Item> myItem();

    List<Item> myItemSearch(String name);

    PageVo<Item> myItemSearch(String name, PageBo pageBo);

    List<Item> getProcessList();

    PageVo<Item> getProcessList(PageBo pageBo);

    List<Item> getProcessListSearch(String name);

    PageVo<Item> getProcessListSearch(PageBo pageBo, String name);

    void updateItemsRedis();

    Result<PageVo<Item>> update(ItemBo itemBo, PageBo pageBo);

    void insert(ItemBo itemBo);
}
