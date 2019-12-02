package com.service.impl;


import com.mapper.UserMapper;
import com.pojo.PageBean;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired//依赖注入数据
    private UserMapper userMapper;


    @Override//查找数据
    public List<User> selectUser() {
        int count =  userMapper.selectCount();
       /* int startRow = (page.getCurrPage()-1)*page.getSize();
        int size = page.getSize();
        int totalPage = count%size==0?(count/size):(count/size-1);
        page.setCount(count);
        page.setTotalPage(totalPage);*/
        return userMapper.selectUser();

    }

    @Override//添加数据
    public void insertUser(User user) {

        userMapper.insertUser(user);
    }

    @Override//通过id删除数据
    public int deleteById(int id) {

        return userMapper.deleteById(id);
    }

    @Override
    public PageBean<User> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageBean<User> pageBean = new PageBean<User>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize = 2;
        pageBean.setPageSize(pageSize);
        int totalCount = userMapper.selectCount();
        //封装总记录数
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        //向上取整
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public int edit(User user) {
        return userMapper.edit(user);
    }


}
