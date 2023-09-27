package com.sjjs.oasystem.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Department implements Serializable {
    @Id
    private int departmentID;

    private String departmentName;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
