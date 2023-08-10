package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {
    public void printAllProductList(List<ProductDTO> allProductList) {

        List<ProductDTO> productList = allProductList;
        for(ProductDTO productDTO : productList) {
            System.out.println(productDTO);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println("검색 조건: " + searchCondition);
        List<ProductDTO> productSelectedList = productList;
        for(ProductDTO productDTO : productSelectedList) {
            System.out.println(productDTO);
        }

    }

    public void printSuccessMessage(String successCode) {

        switch (successCode) {
            case "insert":
                System.out.println("신규 제품 등록에 성공했습니다.");
                break;
            case "update":
                System.out.println("제품 정보 변경에 성공했습니다.");
                break;
            case "delete":
                System.out.println("제품 정보 삭제에 성공했습니다.");
                break;

        }
    }

    public void printErrorMessage(String errorCode) {

        switch (errorCode) {
            case "selectList":
                System.out.println("전체 목록을 출력하는데 실패했습니다.");
                break;
            case "selectOne":
                System.out.println("검색에 맞는 결과를 찾는데 실패했습니다.");
            case "insert" :
                System.out.println("신규 제품 추가에 실패했습니다.");
                break;
            case "update" :
                System.out.println("제품 정보 변경에 실패했습니다. ");
                break;
            case "delete":
                System.out.println("제품 정보 삭제에 실패했습니다.");
                break;
        }
    }

}
