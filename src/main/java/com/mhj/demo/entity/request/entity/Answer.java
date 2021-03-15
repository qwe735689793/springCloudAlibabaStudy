package com.mhj.demo.entity.request.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Answer)实体类
 *
 * @author MHJ
 * @since 2020-10-24 16:55:53
 */
public class Answer implements Serializable {
    private static final long serialVersionUID = 392386126853067826L;
    /**
     * 回答id
     */
    private String answerId;
    /**
     * 用户id(谁来回答)
     */
    private String userId;
    /**
     * 问题id（回答哪一个问题）
     */
    private String quesId;
    /**
     * 回答内容
     */
    private String answerContent;
    /**
     * 赞同总数
     */
    private Integer endorseNumber;
    /**
     * 1为匿名0为不匿名
     */
    private Integer anonymity;
    /**
     * 回答时间
     */
    private Date createTime;


    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getEndorseNumber() {
        return endorseNumber;
    }

    public void setEndorseNumber(Integer endorseNumber) {
        this.endorseNumber = endorseNumber;
    }

    public Integer getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(Integer anonymity) {
        this.anonymity = anonymity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}