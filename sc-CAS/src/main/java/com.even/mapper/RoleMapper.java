package com.even.mapper;

import com.even.pojo.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 北方、
 * @title: RoleMapper
 * @projectName sc
 * @description: TODO
 * @date 2020/8/9 11:22
 */
@Repository
@Mapper
public interface RoleMapper {

    List<String> getUserRole(@Param("id") Long id);

}
