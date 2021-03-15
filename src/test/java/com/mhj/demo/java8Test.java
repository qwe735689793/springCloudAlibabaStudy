package com.mhj.demo;

import com.mhj.demo.entity.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/10/31 13:49
 **/
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class java8Test {
    static class AppleWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }
    interface ApplePredicate {
        public boolean test(Apple a);
    }
    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate    p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    @Test
    public void test() {
        Apple apple =new Apple();

        List<Apple> inventory =new ArrayList<>();
        apple.setColor("green");
        apple.setWeight(160);
        inventory.add(new Apple());
        apple.setColor("green");
        apple.setWeight(140);
        inventory.add(apple);
        apple.setColor("red");
        apple.setWeight(140);
        inventory.add(apple);
        apple.setColor("red");
        apple.setWeight(140);
        inventory.add(apple);
        System.out.println();
        System.out.println("11111111"+filterApples(inventory, new AppleColorPredicate()));
        System.out.println();
    }
}
