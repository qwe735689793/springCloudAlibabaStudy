package com.mhj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mhj.demo.entity.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author HJM
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}