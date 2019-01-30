package com.jrj.cache.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jrj.cache.bean.Department;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);


    @Select("SELECT * FROM test")
    List<Map<String,Object>> maps();

    @Insert("INSERT INTO test(name,age) value(#{name},20)")
    Integer insert(@Param("name") String name);
}
