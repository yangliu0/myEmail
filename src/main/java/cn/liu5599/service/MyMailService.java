package cn.liu5599.service;


import cn.liu5599.pojo.MyMail;

import java.util.List;
import java.util.Map;

public interface MyMailService
{
    public int addEmail(MyMail email);
    public int updateById(MyMail email);
    public List<Map<String, Object>> getList(int index, int pageSize);
    public int getCount();
    public MyMail getEmailById(int id);
}
