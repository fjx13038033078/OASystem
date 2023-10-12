package com.sjjs.oasystem.controller;

import com.sjjs.oasystem.entity.bo.ItemBo;
import com.sjjs.oasystem.entity.bo.PageBo;
import com.sjjs.oasystem.entity.vo.PageVo;
import com.sjjs.oasystem.common.Result;
import com.sjjs.oasystem.entity.Item;
import com.sjjs.oasystem.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "项目管理", tags = {"项目管理"})
@RequestMapping("/item")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @ResponseBody
    @ApiOperation("获取项目列表")
    @GetMapping(value = "/getList")
    public Result<PageVo<Item>> getList(@RequestBody PageBo pageBo) {
        return Result.success(itemService.getList(pageBo));
    }

    @ResponseBody
    @ApiOperation("搜索项目列表")
    @GetMapping(value = "/getList/search")
    public Result<PageVo<Item>> itemListsSearch(@RequestBody String name, PageBo pageBo) {
        return itemService.itemListsSearch(name, pageBo);
    }

    @ResponseBody
    @ApiOperation("添加项目")
    @PostMapping(value = "/insert")
    public Result<String> insert(@RequestBody ItemBo itemBo) {
        itemService.insert(itemBo);
        return Result.success("添加成功");
    }

    @ResponseBody
    @ApiOperation("删除项目")
    @PostMapping(value = "/delete")
    public Result<PageVo<Item>> delete(@RequestBody String projectId, String itemId, PageBo pageBo) {
        return itemService.delete(projectId, itemId, pageBo);
    }

    @ResponseBody
    @ApiOperation("修改项目")
    @PostMapping(value = "/update")
    public Result<PageVo<Item>> update(@RequestBody ItemBo itemBo, PageBo pageBo) {
        return itemService.update(itemBo, pageBo);
    }

    @ResponseBody
    @ApiOperation("获取我的项目列表")
    @GetMapping(value = "/getList/MyItem")
    public Result<PageVo<Item>> myItem(@RequestBody PageBo pageBo) {
        return Result.success(itemService.myItem(pageBo));
    }

    @ResponseBody
    @ApiOperation("搜索我的项目列表")
    @GetMapping(value = "/getList/MyItem/search")
    public Result<PageVo<Item>> myItemSearch(@RequestBody String name, PageBo pageBo) {
        PageVo<Item> items = itemService.myItemSearch(name, pageBo);
        if (items.getTotal() == 0)
            return Result.fail("没有符合条件的数据", new PageVo<>());
        return Result.success(items);
    }

}
