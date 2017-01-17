package cn.liu5599.svr.imp;


import cn.liu5599.dao.UserMapper;
import cn.liu5599.pojo.User;
import cn.liu5599.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService
{
    @Autowired(required=false)
    private UserMapper userDao = null;

    public User getUserById(int userId)
    {
        return this.userDao.selectByPrimaryKey(userId);
    }

    //注册
    public int regUser(User user)
    {
        return this.userDao.insertSelective(user);
    }

    public User getUserByUsername(String username)
    {
        return this.userDao.selectByUsername(username);
    }

    //更新用户资料
    public int updateUser(User user)
    {
        return this.userDao.updateByPrimaryKeySelective(user);
    }

}
