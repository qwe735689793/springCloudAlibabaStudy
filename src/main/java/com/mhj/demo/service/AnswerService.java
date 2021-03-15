package com.mhj.demo.service;
import com.mhj.demo.entity.request.UserAttitudeRequest;
import com.mhj.demo.util.ResultVO;

public interface AnswerService {
    /*获取某个问题回答*/
    ResultVO getAnswer(UserAttitudeRequest userAttitudeRequest);
}
