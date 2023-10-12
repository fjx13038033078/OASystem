package com.sjjs.oasystem.common.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (project)表实体类
 */
@Data
@TableName("project")
@Api(value = "项目内容实体", tags = {"项目内容实体"})
public class ProjectVo {
    @TableId
    @ApiModelProperty("项目id")
    private Integer id;
    @ApiModelProperty("项目名称")
    private String name;
    @ApiModelProperty("项目内容")
    private String content;
    @ApiModelProperty("科研类型")
    private String type;
    @ApiModelProperty("申请资金")
    private Double money;
    @ApiModelProperty("项目说明")
    private String remark;
    @TableField(exist = false)
    @ApiModelProperty("项目审核状态")
    private String status;
    @TableField(exist = false)
    @ApiModelProperty("附件列表-保存格式为文件的路径")
    private String[] filesJson;
    @ApiModelProperty("附件列表-保存格式为文件的路径")
    private String files;
    @TableField(exist = false)
    private String year;
    @TableField(exist = false)
    private String username;

}

