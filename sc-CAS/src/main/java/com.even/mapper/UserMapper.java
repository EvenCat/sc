package com.even.mapper;

import com.even.pojo.dto.UserDTO;
import com.even.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 北方、
 * @title: UserMapper
 * @projectName project
 * @description: TODO
 * @date 2020/7/30 10:52
 */
@Mapper
@Repository
public interface UserMapper {

    UserDTO getUserByUsername(@Param("username") String username);

    UserEntity getUserById(@Param("id") Long id, @Param("state") int state);

}
