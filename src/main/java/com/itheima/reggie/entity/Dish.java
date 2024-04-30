package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName dish
 */
@TableName(value ="dish")
@Data
public class Dish implements Serializable {
    @TableId
    private Long id;

    private String name;

    private Long categoryId;

    private BigDecimal price;

    private String code;

    private String image;

    private String description;

    private Integer status;

    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    @TableLogic
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}