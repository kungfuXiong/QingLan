package com.xbl.quartzDemo.service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


//@Service
public class HelloService {

    @Autowired(required = false)
    DataSource dataSource;

    @PostConstruct
    public void ds(){
        System.out.println("=-=-="+dataSource);
    }

    public  String test(){
        return "hello";
    }
}
