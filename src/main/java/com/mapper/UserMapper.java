package com.mapper;


import com.pojo.PageBean;
import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface UserMapper {

/*    查询所有*PREPARE s1 from 'select * from bom LIMIT ?,?';
set @a:=1;
set @b:=3;

execute s1 using @a,@b;*/


    //查询表的总数据
    @Select("select * from user1 ")
    List<User> selectUser();

     //添加数据
    @Insert("insert into user1 values(null,#{user_num},#{user_name},#{user_addr},#{create_date})")
    void insertUser(User user);
    /*通过id删除数据*/
    @Delete("delete from user1 where user_id in (${user_id})")
    int deleteById(@Param("user_id") int id);

    //查询总条数
    @Select("select count(*) from user1")
    int selectCount();

   /* @Select("select * from user1 limit #{start},#{size}")
    List<User> selectUser(@Param("start") int start,@Param("size") int size);       */

    /*分页操作*/
    List<User> findByPage(HashMap<String,Object> map);


   // @Select("select * from user1 where user_id = #{user_id}")
     User get(@Param("user_id")Integer id); // 查询单条

    //修改数据
   // @Update("update user1 set user_num=#{1},user_name=#{2},user_addr=#{3},create_date=#{4}  where user_id= #{0}")
    int  edit(User user);

}
