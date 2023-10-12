package com.sjjs.oasystem.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
@Data
public class Role implements Serializable {
    @Id
    private int roleID;
    private String roleName;

}
