package com.mhj.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhj.demo.entity.AnswerVO;
import com.mhj.demo.entity.entity.Answer;
import com.mhj.demo.entity.entity.User;
import com.mhj.demo.mapper.PlusTest;
import com.mhj.demo.mapper.UserMapper;
import com.mhj.demo.service.Impl.PlusTestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
    @Autowired
    private PlusTestServiceImpl plusTestService;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test9(){
        Answer answer =new Answer();
        answer.setUserId("zzzza啊腌臜11zzz");
        answer.setAnswerId("bb");
        plusTestService.test(answer);
//        System.out.println();
    }
    @Test
    public void contextLoads() {
    // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
    // 查询全部用户
        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
    }
    // 测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("啊Java");
        user.setAge(3);
        user.setEmail("24736743@qq.com");
        int result = userMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现，id会自动回填
    }
    // 测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(8L);
        user.setName("关注公众号：111狂神说");
        user.setAge(18);
        // 注意：updateById 但是参数是一个 对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker(){
         // 1、查询用户信息
        User user = userMapper.selectById(4L);
        // 2、修改用户信息
//        user.setName("kuangshen");
//        user.setEmail("24736743@qq.com");
//        // 3、执行更新操作
//        userMapper.updateById(user);
    }
    @Autowired
    private PlusTest plusTest;
    //分页查询设置
    @Test
    public void testPage(){
        Page<AnswerVO> answerVOPage = plusTest.selectPageTest(new Page<>(1,5));
        System.out.println(answerVOPage);
    }
    @Test
    public void test1Page(){
        userMapper.deleteById(3L);
    }
}
