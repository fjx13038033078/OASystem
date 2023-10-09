package com.sjjs.oasystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目日志(SysItem)表实体类
 */

@Data
@TableName("item")
@Api(value = "项目实体", tags = {"项目实体"})
public class Item {
    @TableId
    @ApiModelProperty("类名称")
    private Integer id;

    @ApiModelProperty("项目创建者id,对应用户表的id")
    private Integer createBy;

    @ApiModelProperty("项目创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createTime;

    @ApiModelProperty("项目最近修改的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateTime;

    @ApiModelProperty("项目的内容，对应sys_project的id")
    private Integer projectId;

    @TableField(exist = false)
    @ApiModelProperty("项目的状态")
    private String status;

    @TableField(exist = false)
    @ApiModelProperty("项目实体")
    private Project project;

    @TableField(exist = false)
    @ApiModelProperty("用户/创建人实体")
    private User user;

    @TableField(exist = false)
    @ApiModelProperty("项目审核")
    private Process process;
}
