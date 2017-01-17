package cn.liu5599.dao;

import cn.liu5599.pojo.ReceiveMail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReceiveMailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveMail record);

    int insertSelective(ReceiveMail record);

    //插入收信箱，进行去重处理
    int insertReceiveMail(ReceiveMail record);

    ReceiveMail selectByPrimaryKey(Integer id);

    //分页查询，查询一页
    List<Map<String, Object>> selectList(@Param("index")int index, @Param("pageSize") int pageSize);

    int selectCount();

    int updateByPrimaryKeySelective(ReceiveMail record);

    int updateByPrimaryKeyWithBLOBs(ReceiveMail record);

    int updateByPrimaryKey(ReceiveMail record);
}