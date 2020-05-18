package com.springboot.hellotwo.service;

import com.springboot.hellotwo.model.Mobile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MobileService {
    private List<Mobile> mobiles = new ArrayList<>();

    public List<Mobile> getMobiles(){
        return this.mobiles;
    }
    public Mobile getMobile(String name){
        return mobiles.stream().filter(mobile -> mobile.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    @PostConstruct
    public void loadMobiles(){
        this.mobiles.add(new Mobile("Moto X", "Motorola"));
        this.mobiles.add(new Mobile("Note 5", "Red Me"));
        this.mobiles.add(new Mobile("galaxy", "Samsung"));
        this.mobiles.add(new Mobile("P30", "Huwai"));

    }
}
