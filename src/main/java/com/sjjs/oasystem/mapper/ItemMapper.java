package com.sjjs.oasystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjjs.oasystem.common.bo.ItemBo;
import com.sjjs.oasystem.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper extends BaseMapper {
    List<Item> selectAllItem();

    int getLastId();

    void updateItemBo(@Param("item") ItemBo itemBo);

    void insertItemList(@Param("list") List<Item> itemList);
}