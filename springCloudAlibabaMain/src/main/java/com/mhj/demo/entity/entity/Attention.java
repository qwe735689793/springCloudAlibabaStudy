package com.mhj.demo.entity.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Attention)实体类
 *
 * @author MHJ
 * @since 2020-10-24 17:31:39
 */
public class Attention implements Serializable {
    private static final long serialVersionUID = -22491554003737828L;
    /**
     * 用户id  （我是谁）
     */
    private String userId;
    /**
     * 关注对象的id
     */
    private String focusId;
    /**
     * 关注对象的类型(1人 2话题 3问题)
     */
    private Integer focusType;
    /**
     * 关注时间
     */
    private Date createTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFocusId() {
        return focusId;
    }

    public void setFocusId(String focusId) {
        this.focusId = focusId;
    }

    public Integer getFocusType() {
        return focusType;
    }

    public void setFocusType(Integer focusType) {
        this.focusType = focusType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}