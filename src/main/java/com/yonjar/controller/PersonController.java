package com.yonjar.controller;

import com.yonjar.entity.Person;
import com.yonjar.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LuoYJ on 2019/3/18.
 * Person以hash类型来存储
 *
 * @Api swagger注解
 * @ApiOperation 接口方法说明
 * @ApiImplicitParam 具体参数说明
 *    paramType的值有：
 *      header：请求参数放置于Request Header，使用@RequestHeader获取
 *      query：请求参数放置于请求地址，使用@RequestParam获取         http://localhost:8765/findBookByName/bookName="远方"
 *      path：（用于restful接口）-->请求参数的获取：@PathVariable   http://localhost:8765/findBookByName/远方
 *      body：（不常用）
 *      form（不常用）
 * 启动项目访问：http://localhost:8085/swagger-ui.html
 */
@RestController
@Api(value = "Redis RESTFUL接口",description = "hash_type",tags = "PersonController")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "新增Person",notes = "新增Person对象数据")
    @ApiImplicitParam(name = "person",value = "person数据",required = true,dataType = "Person")
    @PostMapping("/insertPerson")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPerson(@RequestBody Person person){
        personService.save(person);
    }

    @ApiOperation(value = "查询所有Person数据",notes = "查询所有Person详情数据")
    @GetMapping("/findAllPerson")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAllPerson(){
        return personService.getAllPerson();
    }

    @ApiOperation(value = "查询Person数据",notes = "根据Name查询Person详情数据")
    @ApiImplicitParam(paramType = "query",name = "name",value = "名字",required = true,dataType = "String")
    @GetMapping("/findByName")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findByName(@RequestParam String name){
        return personService.findByName(name);
    }

    @ApiOperation(value = "删除Person数据",notes = "根据Id删除Person数据")
    @ApiImplicitParam(paramType = "query",name = "id",value = "id",required = true,dataType = "String")
    @DeleteMapping("/deleteById")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam String id){
        personService.deleteById(id);
    }

}
