package com.shibo.usersys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shibo.usersys.mapper.TbUsersMapper;
import com.shibo.usersys.pojo.TbUsers;
import com.shibo.usersys.service.TbUsersService;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class TbUsersServiceImpl implements TbUsersService {
    static final Logger logger = LoggerFactory.getLogger(TbUsersServiceImpl.class);

    @Autowired
    TbUsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Object o) {
        int i = 0;
        try {
            i = usersMapper.deleteByPrimaryKey(o);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            logger.error("TbUsersServiceImpl deleteByPrimaryKey(Object o) ",e);
        }
        return i;
    }

    @Override
    public int delete(TbUsers tbUsers) {
        return 0;
    }

    @Override
    public int insert(TbUsers tbUsers) {
        int i = 0;
        try {
            i = usersMapper.insert(tbUsers);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            logger.error("TbUsersServiceImpl insert(TbUsers tbUsers) ",e);
        }
        return i;
    }

    @Override
    public int insertSelective(TbUsers tbUsers) {
        return 0;
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return false;
    }

    @Override
    public List<TbUsers> selectAll() throws RuntimeException {
        List<TbUsers> tbUsers = usersMapper.selectAll();
        return tbUsers;
    }

    @Override
    public TbUsers selectByPrimaryKey(Object o) throws RuntimeException{
        TbUsers tbUsers = usersMapper.selectByPrimaryKey(o);
        return tbUsers;
    }

    @Override
    public int selectCount(TbUsers tbUsers) throws RuntimeException{
        int i = usersMapper.selectCount(tbUsers);
        return i;
    }

    @Override
    public PageInfo<TbUsers> select(TbUsers tbUsers, String pageNum, String pageSize)  throws RuntimeException{
        PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
        List<TbUsers> select = usersMapper.select(tbUsers);
        return new PageInfo<TbUsers>(select);
    }

    @Override
    public TbUsers selectOne(TbUsers tbUsers) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(TbUsers tbUsers) {
        int i = 0;
        try {
            i = usersMapper.updateByPrimaryKey(tbUsers);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            logger.error("TbUsersServiceImpl updateByPrimaryKey(TbUsers tbUsers) ",e);
        }
        return i;
    }

    @Override
    public int updateByPrimaryKeySelective(TbUsers tbUsers) {
        int i = 0;
        try {
            i = usersMapper.updateByPrimaryKeySelective(tbUsers);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            logger.error("TbUsersServiceImpl updateByPrimaryKeySelective(TbUsers tbUsers) ",e);
        }
        return i;
    }

    @Override
    public int deleteByExample(Object o) {
        return 0;
    }

    @Override
    public List<TbUsers> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public TbUsers selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(TbUsers tbUsers, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(TbUsers tbUsers, Object o) {
        return 0;
    }

    @Override
    public List<TbUsers> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<TbUsers> selectByRowBounds(TbUsers tbUsers, RowBounds rowBounds) {
        return null;
    }

    @Override
    public int insertList(List<? extends TbUsers> list) {
        return 0;
    }

    @Override
    public int insertUseGeneratedKeys(TbUsers tbUsers) {
        int i = 0;
        try {
            i = usersMapper.insertUseGeneratedKeys(tbUsers);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            logger.error("TbUsersServiceImpl insertUseGeneratedKeys(TbUsers tbUsers) ",e);
        }
        return i;
    }
}

