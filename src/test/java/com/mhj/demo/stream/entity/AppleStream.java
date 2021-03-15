package com.mhj.demo.stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/11/15 19:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppleStream {
    private String id ;
    private String color;
    //重量
    private int weight;
    //地区
    private String origin;
}
