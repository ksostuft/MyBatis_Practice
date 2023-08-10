package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {


        StringBuilder sb = new StringBuilder();
        sb.append("select c.CATEGORY_CODE, CATEGORY_NAME FROM product_category c ");
        if(parameter.get("option").equals("orderList")) {
            sb.append("join product_info i on c.CATEGORY_CODE = i.CATEGORY_CODE group by c.CATEGORY_CODE order by count(c.CATEGORY_CODE) desc");
        }
        return sb.toString();
    }

    public String registNewCategory(CategoryDTO category) {

        return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{ categoryName }").toString();
    }

    public String modifyCategoryName(CategoryDTO category) {

        return new SQL()
                .UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_NAME = #{ categoryName }")
                .WHERE("CATEGORY_CODE = #{ categoryCode }").toString();
    }

    public String deleteCategory(Map<String, String> parameter) {

        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }").toString();
    }
}
