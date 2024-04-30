package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.DishMapper;
import com.itheima.reggie.mapper.SetmealMapper;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 轩宇
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2024-04-30 14:35:07
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper=new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        Long countDish = dishMapper.selectCount(dishLambdaQueryWrapper);
        if (countDish>0){
            throw new CustomException("当前分类关联菜品，不可删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        Long countSetmeal = setmealMapper.selectCount(setmealLambdaQueryWrapper);
        if (countSetmeal>0){
            throw new CustomException("当前分类关联套餐，不可删除");
        }

        super.removeById(id);
    }
}




