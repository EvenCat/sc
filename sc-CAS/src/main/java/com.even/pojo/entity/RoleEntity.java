package com.even.pojo.entity;

import com.even.pojo.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 北方、
 * @title: RoleEntity
 * @projectName sc
 * @description: TODO
 * @date 2020/8/9 11:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {

    private String name;
}
