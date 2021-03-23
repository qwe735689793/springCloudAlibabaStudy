package com.mhj.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/11/5 22:14
 **/
@Data
public class AnswerVO {
    private static final long serialVersionUID = 240355208370845376L;
    /**
     * 回答id
     */
    @TableId
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

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    private String name;
}
