package com.mhj.demo.config;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/4 14:17
 **/
public class JmsConfig {
    /**
     * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
     */
    public static final String NAME_SERVER = "47.98.250.133:9876";
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC = "topic_family";
}
