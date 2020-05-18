package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.demo.exception.MobileNotFoundException;
import com.example.demo.model.Mobile;
import org.springframework.stereotype.Service;

@Service
public class MobileDaoService {
private final List<Mobile> mobiles = new ArrayList<>();
	
	
	public List<Mobile> getAllMobiles(){
		return this.mobiles;
	}

	public Mobile getMobileById(int mobileId)  {
		return mobileById(mobileId);
	}
	public void saveMobile(Mobile mobile) {
		mobiles.add(mobile);
	}
	public void updateMobile(Mobile mobile) {
		int mobileId = mobile.getId();

		mobiles.set(mobileId, mobile);
	}

	public boolean deleteMobile(int mobileId) {
		mobileById(mobileId);
		mobiles.remove(mobileId);
		return true;
	}

	private Mobile mobileById(int mobileId) {
		Optional<Mobile> mobile = this.mobiles.stream().filter(m->m.getId()==mobileId).findFirst();
		if(!mobile.isPresent()){
			throw new MobileNotFoundException(13001, "Medium error : Mobile not found for mobileId :" + mobileId);
		}
		return mobile.get();
	}


	@PostConstruct
	public void initMobiles() {
		mobiles.add(new Mobile(1, "Samsung", 10000));
		mobiles.add(new Mobile(2, "MI", 12000));
		mobiles.add(new Mobile(3, "Honor 20", 15000));
		mobiles.add(new Mobile(4, "Redmi Note 8 Pro", 11500));
		mobiles.add(new Mobile(5, "Vivo S1 Pro", 12000));
		mobiles.add(new Mobile(6, "OPPO A52020", 14000));
		mobiles.add(new Mobile(7, "Nokia 6.2", 16000));
	}


}
