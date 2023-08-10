package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;

    public CategoryController() {
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null && categoryList.size() > 0) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("selectList");
        }
    }

    public void registNewCategory(CategoryDTO category) {

        boolean result = categoryService.registNewCategory(category);

        if(result) {
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        boolean result = categoryService.modifyCategoryName(category);

        if(result) {
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        boolean result = categoryService.deleteCategory(parameter);

        if(result) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
