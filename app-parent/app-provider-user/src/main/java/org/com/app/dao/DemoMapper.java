package org.com.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.com.app.model.Demo;

@Mapper
public interface DemoMapper extends BaseMapper<Demo> {
}
