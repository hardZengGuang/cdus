package com.service;


import com.pojo.PageBean;
import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查询user表数据
    List<User> selectUser();

    //向user表里面添加数据
    void insertUser(User user);

    //删除表里面的数据
    int deleteById(int id);

    //对查询出来的user表数据进行分页
    PageBean<User> findByPage(int currentPage);

    // 查询单条
    User get(int id);

    //修改数据
    int  edit(User user);

}


