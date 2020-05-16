package com.example.demo.controller;

import com.example.demo.model.Mobile;
import com.example.demo.service.MobileDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("mobiles")
public class MobileController {
    @Autowired
    private MobileDaoService mobileDaoService;

    @GetMapping
    public List<Mobile> getAllMobiles(){
        return mobileDaoService.getAllMobiles();
    }

    @GetMapping("/{mobile-id}")
    public Mobile getMobile(@PathVariable("mobile-id") int mobileId ){
        return mobileDaoService.getMobileById(mobileId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMobile(@RequestBody Mobile mobile){
        mobileDaoService.saveMobile(mobile);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMobile(@RequestBody Mobile mobile){
        mobileDaoService.saveMobile(mobile);
    }

    @DeleteMapping("/{mobileId}")
    public boolean deleteMobileById(@PathVariable int mobileId){
        return true;
    }

}
