package com.sjjs.oasystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjjs.oasystem.common.Result;
import com.sjjs.oasystem.entity.Item;
import com.sjjs.oasystem.entity.Project;
import com.sjjs.oasystem.entity.User;
import com.sjjs.oasystem.entity.bo.ItemBo;
import com.sjjs.oasystem.entity.bo.PageBo;
import com.sjjs.oasystem.entity.vo.PageVo;
import com.sjjs.oasystem.mapper.ItemMapper;
import com.sjjs.oasystem.mapper.ProjectMapper;
import com.sjjs.oasystem.mapper.UserMapper;
import com.sjjs.oasystem.service.ItemService;
import com.sjjs.oasystem.service.UserService;
import com.sjjs.oasystem.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private UserService userService;

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
        List<Item> list = this.getList();
        return new PageVo<>(pageBo, list);
    }

    @Override
    public List<Item> getList() {
        return itemMapper.selectList(null);
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
        try {
            itemMapper.deleteById(itemId); // 先删除项目事项
            projectMapper.deleteById(projectId); // 再删除项目
            PageVo<Item> list = this.getList(pageBo);
            return Result.success("删除成功", list);
        } catch (Exception e) {
            return Result.fail("删除失败：" + e.getMessage());
        }
    }

    @Override
    public PageVo<Item> myItem(PageBo pageBo) {
        return null;
    }

    @Override
    public PageVo<Item> myItemSearch(String name, PageBo pageBo) {
        return null;
    }

    @Override
    public Result<PageVo<Item>> update(ItemBo itemBo, PageBo pageBo) {
        return null;
    }

    @Override
    public void insert(ItemBo itemBo) {
        insertItemBo(itemBo);
    }

    /**
     * 添加新项目
     */
    private void insertItemBo(ItemBo itemBo) {
        Project project = itemBo.getProject();
        projectMapper.insert(project); // 数据库会自动生成项目的主键
        // 获取当前登录用户的信息
        User currentUser = userService.getCurrentUser();
        // 创建项目事项
        Item item = new Item();
        item.setCreateBy(currentUser.getUid());
//        item.setCreateBy(12);
        item.setProjectId(project.getId()); // 使用数据库生成的项目ID
//        item.setProjectId(1);
        LocalDateTime time = LocalDateTime.now();
        item.setCreateTime(time);
        item.setUpdateTime(time);
        itemMapper.insert(item); // 数据库会自动生成项目事项的主键
    }

}
