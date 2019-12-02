package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    /*
    * 针对数据库的user表写出对应的实体类，属性要和数据库的字段保持一致
    * */
    private int user_id;
    private String user_num;
    private String user_name;
    private String user_addr;
    private Date create_date;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_num() {
        return user_num;
    }

    public void setUser_num(String user_num) {
        this.user_num = user_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

    public Date getCreate_date() {
        return create_date;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")//限制时间格式
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_num='" + user_num + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_addr='" + user_addr + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
