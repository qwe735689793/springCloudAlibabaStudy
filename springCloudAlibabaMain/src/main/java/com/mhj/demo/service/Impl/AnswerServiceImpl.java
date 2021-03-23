package com.mhj.demo.service.Impl;

import com.mhj.demo.entity.request.UserAttitudeRequest;
import com.mhj.demo.mapper.AnswerMapper;
import com.mhj.demo.service.AnswerService;
import com.mhj.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService {

//    @Autowired
//    private AnswerMapper answerMapper;
//    /*获取某个问题的回答*/
    @Override
    public ResultVO getAnswer(UserAttitudeRequest userAttitudeRequest) {
//        List<Map<String,Object>> answerList=answerMapper.getAnswer(userAttitudeRequest.getQuesId());
        return new ResultVO(200,"","问题的回答");
    }

}
