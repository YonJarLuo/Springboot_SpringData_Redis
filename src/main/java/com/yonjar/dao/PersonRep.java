package com.yonjar.dao;

import com.yonjar.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LuoYJ on 2019/3/15.
 * 遵循JPA规范，根据方法名查询时，此字段必须要先建立索引
 */
public interface PersonRep extends CrudRepository<Person,String> {

    List<Person> findByName(String name);
}
