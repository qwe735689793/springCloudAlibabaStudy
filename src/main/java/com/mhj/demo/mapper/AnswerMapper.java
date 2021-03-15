package com.mhj.demo.mapper;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository
public interface AnswerMapper {
    /*根据问题id查看回答*/
    List<Map<String,Object>> getAnswer(String id);

}