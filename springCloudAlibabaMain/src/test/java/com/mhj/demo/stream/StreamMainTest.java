package com.mhj.demo.stream;

import com.mhj.demo.entity.Apple;
import com.mhj.demo.stream.entity.AppleStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/11/15 20:00
 **/
@SpringBootTest
public class StreamMainTest {
    private static List<AppleStream> appleList =new ArrayList<>();
    static {
        appleList.add(new AppleStream("1","red",300,"福建"));
        appleList.add(new AppleStream("2","red",500,"福建"));
        appleList.add(new AppleStream("3","white",100,"福建"));
        appleList.add(new AppleStream("4","white",200,"福建"));
        appleList.add(new AppleStream("5","white",300,"福建"));

    }
    //获取所有洪苹果
    @Test
    public void getAllColorApple(){
        List<AppleStream> list =appleList.stream()
                .filter(a->"red".equals(a.getColor())).collect(Collectors.toList());
        System.out.println(list);
        getAllRedApple1(a->"red".equals(a.getColor()));
    }
    //把行为参数化  super 后面更这是行为的对象, pr是做出的动作要是什么
    public void getAllRedApple1(Predicate<? super AppleStream> pr){
        List<AppleStream> list =appleList.stream()
                .filter(pr).collect(Collectors.toList());
        System.out.println(list);
    }

    //求个每个颜色的苹果的平均重量--正常方法
    @Test
    public void getAllColorOfWeight() {
        Map<String, List<AppleStream>> map = new HashMap<>();
        //根据颜色分组
        for (AppleStream apple : appleList) {

            /*
             * computeIfAbsent方法
             * 第一个参数作为key,若没有key对应的值，则使用第二个参数的值，
             * */
            List<AppleStream> list = map.computeIfAbsent(apple.getColor(), key -> new ArrayList<>());
            list.add(apple);
        }
        //根据颜色分组的结果，再分别计算苹果的重量
        for (Map.Entry<String, List<AppleStream>> entry : map.entrySet()) {
            int weights = 0;
            for (AppleStream apple : entry.getValue()) {
                weights += apple.getWeight();
            }
            System.out.println(String.format("颜色%s 平均重量%s ",entry.getKey(), weights / entry.getValue().size()));

        }
    }

    //求个每个颜色的苹果的平均重量--正常方法
    @Test
    public void getAllColorOfWeightStream() {
        /*
        * 根据颜色分类
        * */
//        Map<String, List<AppleStream>> collect = appleList.stream()
//                .collect(Collectors.groupingBy(a -> a.getColor()));
//
//        根据颜色分类，并计算平均数
        Map<String, Double> collect = appleList.stream()
                .collect(Collectors.groupingBy(a -> a.getColor(),
                        Collectors.averagingInt(a -> a.getWeight())));

        System.out.println(collect);
    }
}
