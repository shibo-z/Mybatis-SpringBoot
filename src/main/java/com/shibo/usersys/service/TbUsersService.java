package com.shibo.usersys.service;

import com.github.pagehelper.PageInfo;
import com.shibo.usersys.pojo.TbUsers;
import com.shibo.usersys.utils.mapper.CommMappper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TbUsersService {

    public int deleteByPrimaryKey(Object o);
    public int delete(TbUsers tbUsers);
    public int insert(TbUsers tbUsers);
    public int insertSelective(TbUsers tbUsers);
    public boolean existsWithPrimaryKey(Object o);
    public List<TbUsers> selectAll();
    public TbUsers selectByPrimaryKey(Object o);
    public int selectCount(TbUsers tbUsers);
    public PageInfo<TbUsers> select(TbUsers tbUsers, String pageNum, String pageSize);
    public TbUsers selectOne(TbUsers tbUsers);
    public int updateByPrimaryKey(TbUsers tbUsers);
    public int updateByPrimaryKeySelective(TbUsers tbUsers);
    public int deleteByExample(Object o);
    public List<TbUsers> selectByExample(Object o);
    public int selectCountByExample(Object o);
    public TbUsers selectOneByExample(Object o);
    public int updateByExample(TbUsers tbUsers, Object o);
    public int updateByExampleSelective(TbUsers tbUsers, Object o);
    public List<TbUsers> selectByExampleAndRowBounds(Object o, RowBounds rowBounds);
    public List<TbUsers> selectByRowBounds(TbUsers tbUsers, RowBounds rowBounds);
    public int insertList(List<? extends TbUsers> list);
    public int insertUseGeneratedKeys(TbUsers tbUsers);
}
