package com.sjjs.oasystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fanjiaxing
 * @since 2023-09-20
 */
@Api(value = "用户实体", tags = {"用户实体"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户编号")
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    @ApiModelProperty("用户名")
    private String uname;
    @ApiModelProperty("用户账号")
    private String uaccount;
    @ApiModelProperty("用户密码")
    private String upassword;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "User{" +
            "uid = " + uid +
            ", uname = " + uname +
            ", uaccount = " + uaccount +
            ", upassword = " + upassword +
        "}";
    }
}
