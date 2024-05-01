package com.itheima.reggie.service;

import com.itheima.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.dto.DishDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author 轩宇
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2024-04-30 15:51:25
*/
public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
