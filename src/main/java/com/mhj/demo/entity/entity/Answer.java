package com.mhj.demo.entity.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;

import java.io.Serializable;
import java.util.Date;

/**
 * (Answer)实体类
 *
 * @author MHJ
 * @since 2020-10-27 11:57:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("answer")
public class Answer implements Serializable {
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

    private Integer deleted;



}