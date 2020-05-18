package com.springboot.hellotwo.controller;

import com.springboot.hellotwo.model.Mobile;
import com.springboot.hellotwo.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    private MobileService service;
    @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    public String helloWorld(){
        return "hello World";
    }
    @RequestMapping(method = RequestMethod.GET, path="/get-mobiles")
    public List<Mobile> getMobiles(){
        return service.getMobiles();
    }
    @RequestMapping(method = RequestMethod.GET, path="/get-mobile/{name}")
    public Mobile getMobile(@PathVariable String name){
        return service.getMobile(name);
    }


}
