package com.yonjar.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by LuoYJ on 2019/3/15.
 * @RedisHash 表示Person对象将会以hash类型保存  key:Person
 * @Indexed 在保存Person时，name属性将会建立索引
 * @Data 是lombok插件的注解，提供get，set等方法
 */
@RedisHash("Person")
@Data
public class Person {

    @Id
    private String id;

    @Indexed
    private String name;

    private Integer age;

}
