package com.sjjs.oasystem.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjjs.oasystem.entity.bo.ItemBo;
import com.sjjs.oasystem.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@TableName("item")
@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    List<Item> selectAllItem();

    int getLastId();

    void updateItemBo(@Param("item") ItemBo itemBo);

    void insertItemList(@Param("list") List<Item> itemList);
}
