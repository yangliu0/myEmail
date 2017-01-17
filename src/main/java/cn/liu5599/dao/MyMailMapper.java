package cn.liu5599.dao;

import cn.liu5599.pojo.MyMail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyMailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyMail record);

    int insertSelective(MyMail record);

    MyMail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyMail record);

    int updateByPrimaryKeyWithBLOBs(MyMail record);

    int updateByPrimaryKey(MyMail record);

    //分页查询，查询一页
    List<Map<String, Object>> selectList(@Param("index")int index, @Param("pageSize") int pageSize);

    //获取发信箱邮件总数
    int selectCount();
}