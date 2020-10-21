package com.itlf.kaoshi.service;

import com.itlf.kaoshi.dao.UserDao;
import com.itlf.kaoshi.pojo.User;
import com.itlf.kaoshi.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author LiuFeng
 * @Date 2020/10/10 20:25
 */
public class loginServic {
    public boolean login(User user)throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User login = mapper.login(user);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        if(login!=null){
            return true;
        }
        return false;
    }
}
