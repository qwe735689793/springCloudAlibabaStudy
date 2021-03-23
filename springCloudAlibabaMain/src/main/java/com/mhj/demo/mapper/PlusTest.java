package com.mhj.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhj.demo.entity.AnswerVO;
import com.mhj.demo.entity.entity.Answer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface PlusTest extends BaseMapper<Answer> {
    @Select("SELECT\n" +
            "account.NAME AS aname,\n" +
            "answer.* \n" +
            "FROM\n" +
            "account,\n" +
            "answer \n" +
            "WHERE\n" +
            "ques_id = #{id} \n" +
            "and answer.user_id=account.user_id")
    List<Map<String,Object>> getTestData(String id);
    @Select("select a.*,account.name\n" +
            "from answer as a\n" +
            "LEFT JOIN account on\n" +
            "a.user_id = account.user_id")
    Page<AnswerVO> selectPageTest(Page page);
}
