package com.itheima.reggie.service;

import com.itheima.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 轩宇
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2024-04-30 14:35:07
*/
public interface CategoryService extends IService<Category> {

    void remove(Long id);
}
