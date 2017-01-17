package cn.liu5599.service;

import cn.liu5599.pojo.User;

public interface UserService
{
    public User getUserById(int userid);
    public int regUser(User user);
    public User getUserByUsername(String username);
    public int updateUser(User user);
}
