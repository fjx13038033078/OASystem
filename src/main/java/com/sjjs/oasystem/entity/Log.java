package com.sjjs.oasystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("sys_log")
@Api(value = "日志实体", tags = {"日志实体"})
public class Log {
    @TableId
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("操作账户")
    private String uaccount;
    @ApiModelProperty("操作用户名")
    private String uname;
    @ApiModelProperty("请求方式")
    private String method;
    @ApiModelProperty("请求地址")
    private String url;
    @ApiModelProperty("请求接口")
    private String uri;
    @ApiModelProperty("请求类")
    private String className;
    @ApiModelProperty("请求函数")
    private String classMethodName;
    @ApiModelProperty("ip地址")
    private String ip;
    @ApiModelProperty("请求时间")
    private String requestTime;

}
