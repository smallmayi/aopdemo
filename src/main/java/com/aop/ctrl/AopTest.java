package com.aop.ctrl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
@CacheConfig
public class AopTest {
    @RequestMapping("/add")
    @Cacheable
    public void add(ServletRequest request){
        System.out.println("添加方法");
    }
    @RequestMapping("/del")
    public void del(){
        System.out.println("删除方法");
    }
    @RequestMapping("/update")
    public void update(){
        System.out.println("修改方法");
    }
    @RequestMapping("/search")
    public void search(){
        System.out.println("查询方法");
    }
}
