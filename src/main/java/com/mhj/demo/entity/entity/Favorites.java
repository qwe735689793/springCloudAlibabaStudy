package com.mhj.demo.entity.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Favorites)实体类
 *
 * @author MHJ
 * @since 2020-10-24 17:33:05
 */
public class Favorites implements Serializable {
    private static final long serialVersionUID = 249500578303160741L;
    /**
     * 收藏夹id
     */
    private String favoritesId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 收藏夹的名字
     */
    private String favoritesName;
    /**
     * 收藏夹描述
     */
    private String favoritesDescribe;
    /**
     * 1为公开 0为不公开
     */
    private Integer open;
    /**
     * 创建时间
     */
    private Date createTime;


    public String getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(String favoritesId) {
        this.favoritesId = favoritesId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFavoritesName() {
        return favoritesName;
    }

    public void setFavoritesName(String favoritesName) {
        this.favoritesName = favoritesName;
    }

    public String getFavoritesDescribe() {
        return favoritesDescribe;
    }

    public void setFavoritesDescribe(String favoritesDescribe) {
        this.favoritesDescribe = favoritesDescribe;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}