package com.mhj.demo.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mhj.demo.entity.entity.Answer;
import com.mhj.demo.mapper.PlusTest;
import com.mhj.demo.service.PlusTestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HJM
 */
@Service
public class PlusTestServiceImpl extends ServiceImpl<PlusTest, Answer> implements PlusTestService {
    public void test(Answer answer){
        baseMapper.updateById(answer);
    }
    public void test1(Answer answer){
        this.save(answer);

    }
}
