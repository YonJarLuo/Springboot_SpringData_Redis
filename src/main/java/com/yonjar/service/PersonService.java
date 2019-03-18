package com.yonjar.service;

import com.yonjar.dao.PersonRep;
import com.yonjar.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LuoYJ on 2019/3/15.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRep personRep;

    public List<Person> getAllPerson(){
        Iterable<Person> persons = personRep.findAll();
        ArrayList<Person> datas = new ArrayList<>();

        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ){
            Person p = it.next();
            datas.add(p);
        }
        return datas;
    }

    public void save(Person person){
        personRep.save(person);
    }

    public List<Person> findByName(String name) {
        return personRep.findByName(name);
    }

    public void deleteById(String id){
        personRep.delete(id);
    }

}
