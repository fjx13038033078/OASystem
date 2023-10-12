package com.sjjs.oasystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjjs.oasystem.common.vo.ProjectVo;
import com.sjjs.oasystem.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper extends BaseMapper<Project> {
    List<Project> getProjectByIds(@Param("projectIds") List<Integer> projectIds);

    List<Project> getProjectList();

    int getLastId();

    ProjectVo getProjectByName(@Param("name") String name);

    void insertProjectList(@Param("list") List<Project> projectList);
}
