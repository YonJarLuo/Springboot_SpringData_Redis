package com.yonjar.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by LuoYJ on 2019/3/15.
 * 测试，使用Jedis连接redis
 */
public class myTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
//        jedis.auth("123456");   //密码 如果设置有

        //01将数据保存为hash类型
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name","luoyj");
        data.put("age","25");
        data.put("like","singsong");
        jedis.hmset("who",data);    //保存到redis中
        //查询hash类型的数据
        List<String> dbDatas = jedis.hmget("who","name","age","like");
        dbDatas.forEach((person) -> System.out.println(person));

        //02将数据保存为set类型
        jedis.sadd("set_test","1","2","234");
        //查询数据
        Set<String> set_test = jedis.smembers("set_test");
        set_test.forEach(System.out::println);

        //03将数据保存为list类型
        jedis.lpush("test_list","Q","B","D","Z");   //添加
        jedis.lset("test_list",1,"who"); //修改
        jedis.lset("test_list",2,"am");
        jedis.lset("test_list",3,"i");
        //查询 jedis.lrange("test_list",0,-1) 返回整个集合
        System.out.println("list 长度："+jedis.llen("test_list"));
        List<String> lists = jedis.lrange("test_list", 0, -1);
        lists.forEach(list -> System.out.println(list));

        //04 String
        //05 ZSet
    }

}
