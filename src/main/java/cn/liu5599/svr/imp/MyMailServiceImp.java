package cn.liu5599.svr.imp;

import cn.liu5599.dao.MyMailMapper;
import cn.liu5599.pojo.MyMail;
import cn.liu5599.service.MyMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MyMailServiceImp implements MyMailService
{
    @Autowired(required = false)
    private MyMailMapper myMailDao = null;

    //添加邮箱到发信箱
    public int addEmail(MyMail email)
    {
        return this.myMailDao.insertSelective(email);
    }

    public int updateById(MyMail email)
    {
        return this.myMailDao.updateByPrimaryKeySelective(email);
    }

    //获取一页
    public List<Map<String, Object>> getList(int index, int pageSize)
    {
        int index_select = index * pageSize;
        return this.myMailDao.selectList(index_select, pageSize);
    }

    //获取邮件总数
    public int getCount()
    {
        return this.myMailDao.selectCount();
    }

    //根据id获取邮件
    public MyMail getEmailById(int id)
    {
        return this.myMailDao.selectByPrimaryKey(id);
    }
}
