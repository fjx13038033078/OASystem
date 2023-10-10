package com.sjjs.oasystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjjs.oasystem.common.bo.ItemBo;
import com.sjjs.oasystem.common.bo.PageBo;
import com.sjjs.oasystem.common.vo.PageVo;
import com.sjjs.oasystem.common.vo.Result;
import com.sjjs.oasystem.entity.Item;
import com.sjjs.oasystem.mapper.UserMapper;
import com.sjjs.oasystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public boolean saveBatch(Collection<Item> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Item> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Item> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Item entity) {
        return false;
    }

    @Override
    public Item getOne(Wrapper<Item> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Item> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Item> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Item> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Item> getEntityClass() {
        return null;
    }

    @Override
    public PageVo<Item> getList(PageBo pageBo) {
        return null;
    }

    @Override
    public List<Item> getList() {
        return null;
    }

    @Override
    public void createItemRedis() {

    }

    @Override
    public Result<PageVo<Item>> itemListsSearch(String name, PageBo pageBo) {
        return null;
    }

    @Override
    public Result<PageVo<Item>> insert(ItemBo itemBo, PageBo pageBo) {
        return null;
    }

    @Override
    public Result<PageVo<Item>> delete(String projectId, String itemId, PageBo pageBo) {
        return null;
    }

    @Override
    public PageVo<Item> myItem(PageBo pageBo) {
        return null;
    }

    @Override
    public List<Item> myItem() {
        return null;
    }

    @Override
    public List<Item> myItemSearch(String name) {
        return null;
    }

    @Override
    public PageVo<Item> myItemSearch(String name, PageBo pageBo) {
        return null;
    }

    @Override
    public List<Item> getProcessList() {
        return null;
    }

    @Override
    public PageVo<Item> getProcessList(PageBo pageBo) {
        return null;
    }

    @Override
    public List<Item> getProcessListSearch(String name) {
        return null;
    }

    @Override
    public PageVo<Item> getProcessListSearch(PageBo pageBo, String name) {
        return null;
    }

    @Override
    public void updateItemsRedis() {

    }

    @Override
    public Result<PageVo<Item>> update(ItemBo itemBo, PageBo pageBo) {
        return null;
    }

    @Override
    public void insert(ItemBo itemBo) {

    }
}
