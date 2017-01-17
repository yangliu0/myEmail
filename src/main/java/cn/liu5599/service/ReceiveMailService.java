package cn.liu5599.service;


import cn.liu5599.pojo.ReceiveMail;

import java.util.List;
import java.util.Map;

public interface ReceiveMailService
{
    public int addMail() throws Exception;
    public List<Map<String, Object>> getList(int index, int pageSize);
    public int getCount();
    public ReceiveMail getEmail(int id);
}
