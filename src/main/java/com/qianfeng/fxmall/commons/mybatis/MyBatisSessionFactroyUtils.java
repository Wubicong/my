package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactroyUtils {
    /*饿汉单例模式生成session工厂*/
    public static SqlSessionFactory sqlSessionFactory;
    public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
       initSessionFactroy();
    }
    public static void initSessionFactroy(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactroy(){
        if (sqlSessionFactory == null){
           initSessionFactroy();
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if (session == null){
           session = sqlSessionFactory.openSession();
        }
        return session;
    }
}
