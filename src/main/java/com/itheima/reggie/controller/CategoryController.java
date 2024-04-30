package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(("/category"))
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @PostMapping("/")
    public R<String> insert(@RequestBody Category category){
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        Page<Category> pageInfo = new Page<Category>(page, pageSize);
        LambdaQueryWrapper<Category> query = new LambdaQueryWrapper<Category>();
        query.orderByAsc(Category::getSort);
        categoryService.page(pageInfo,query);
        return R.success(pageInfo);
    }

    @DeleteMapping
    public R<String> delete(Long id){

        categoryService.remove(id);

        return R.success("成功删除分类");
    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("Update category {}", category);
        categoryService.updateById(category);
        return R.success("分类信息修改成功");
    }
}
