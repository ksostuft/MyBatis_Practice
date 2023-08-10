package com.common;

import com.management.category.model.dao.CategoryDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                sqlSessionFactory.getConfiguration().addMapper(CategoryDAO.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory.openSession(false);
    }

    // * 주석을 지우고 sqlSession을 생성하는 공통 template 파일을 작성하세요.

}
