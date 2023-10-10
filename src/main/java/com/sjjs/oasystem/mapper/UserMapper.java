package com.sjjs.oasystem.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjjs.oasystem.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fanjiaxing
 * @since 2023-09-20
 */
@TableName("user")
public interface UserMapper extends BaseMapper<User> {
    User getUserByAccount(@Param("account") String account);
}
