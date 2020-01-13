package com.shibo.usersys.utils.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
//点进去看可以知道MySqlMapper是insert增强
public interface CommMappper<T> extends Mapper<T>, MySqlMapper<T> {
}
