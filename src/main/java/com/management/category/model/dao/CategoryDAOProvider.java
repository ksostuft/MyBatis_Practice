package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    // * 주석을 지우고 Provider 활용하여 내용을 작성하세요.

    public String selectCategoryList(Map<String, String> parameter) {

        // 1. Provider를 활용하여 제품분류 목록을 조회하는 코드를 작성하세요.
        //    (조건) 전체 조회 or 제품분류 순위로 정렬해 조회하는 조건에 따른 Dynamic SQL로 작성하세요.
        //          제품분류 순위는 PRODUCT_INFO 테이블과 JOIN하여, 해당 제품분류에 속한 제품 갯수가 많은 순입니다.
        //          예를 들어, PRODUCT_INFO 테이블에 제품분류가 A인 제품이 10개, B인 제품이 4개, C인 제품이 13개 있다면
        //          제품분류 순위는 C > A > B 입니다. (단, 제품 갯수가 0개인 제품분류는 목록에 출력되지 않아도 됩니다.)
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.

        /*if(parameter.get("option").equals("allList"))*/

        StringBuilder sb = new StringBuilder();
        sb.append("select c.CATEGORY_CODE, CATEGORY_NAME FROM product_category c ");
        if(parameter.get("option").equals("orderList")) {
            sb.append("join product_info i on c.CATEGORY_CODE = i.CATEGORY_CODE group by c.CATEGORY_CODE order by count(c.CATEGORY_CODE) desc");
        }
        return sb.toString();
        /* 동적 쿼리는 조건만 바뀌어야 한다.*/
        /*select CATEGORY_NAME, count(c.CATEGORY_CODE) fre from product_category c join product_info i on c.CATEGORY_CODE = i.CATEGORY_CODE group by c.CATEGORY_CODE order by fre desc;*/
    }

    public String registNewCategory(CategoryDTO category) {

        // 2. Provider를 활용하여 제품분류를 등록하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{ categoryName }").toString();
    }

    public String modifyCategoryName(CategoryDTO category) {

        // 3. Provider를 활용하여 제품분류명을 수정하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return new SQL()
                .UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_NAME = #{ categoryName }")
                .WHERE("CATEGORY_CODE = #{ categoryCode }").toString();
    }

    public String deleteCategory(Map<String, String> parameter) {

        // 4. Provider를 활용하여 제품분류를 삭제하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }").toString();
    }
}
