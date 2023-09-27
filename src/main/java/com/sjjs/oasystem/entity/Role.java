package com.sjjs.oasystem.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Role implements Serializable {
    @Id
    private int roleID;
    private String roleName;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
