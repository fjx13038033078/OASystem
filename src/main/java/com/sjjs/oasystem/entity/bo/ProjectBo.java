package com.sjjs.oasystem.entity.bo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Project)表实体类
 */
@Data
@TableName("project")
@Api(value = "项目内容实体", tags = {"项目内容实体"})
public class ProjectBo {
    @TableId
    @ApiModelProperty("项目id")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String name;

}

