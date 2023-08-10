package com.management.category.view;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        for(CategoryDTO categoryDTO : categoryList) {
            System.out.println(categoryDTO);
        }
        if(parameter.get("option").equals("allList")) {
            System.out.println("전체 목록 조회입니다.");
        } else {
            System.out.println("순위별 제품 분류 조회입니다. (가장 위에 있는 게 1위)");
        }
    }

    public void printSuccessMessage(String successCode) {

        switch (successCode) {
            case "insert":
                System.out.println("제품분류 정보를 등록하는데 성공했습니다.");
                break;
            case "update":
                System.out.println("제품분류 정보를 수정하는데 성공했습니다.");
                break;
            case "delete":
                System.out.println("제품분류 정보를 삭제하는데 성공했습니다.");
                break;
        }
    }

    public void printErrorMessage(String errorCode) {

        switch (errorCode) {
            case "select":
                System.out.println("제품분류 목록을 조회하는데 실패했습니다.");
                break;
            case "insert":
                System.out.println("제품분류 정보를 등록하는데 실패했습니다.");
                break;
            case "update":
                System.out.println("제품분류 정보를 수정하는데 실패했습니다.");
                break;
            case "delete":
                System.out.println("제품분류 정보를 삭제하는데 실패했습니다.");
                break;
        }
    }

}
