package com.even.pojo.entity;

import com.even.pojo.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 北方、
 * @title: UserEntity
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 19:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity  extends BaseEntity {

    private String username;

    private String password;

}
