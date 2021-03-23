package com.mhj.demo.entity;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/10/31 16:24
 **/
public interface ApplePredicate {

    // true 符合条件 false 不符合条件
    boolean test(Apple apple);
}
class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}
