package com.bryan;

import com.bryan.domain.User;
import com.bryan.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoottestApplication.class)
public class BoottestApplicationTests {

	private Logger logger= LoggerFactory.getLogger(BoottestApplication.class);


	@Autowired
	private RedisService redisService;

	@Test
	public void testLog(){
		logger.error("error");
	}


	@Test
	public void testRedis(){
		System.out.println("==============string====================");
		System.out.println(redisService.set("uname","china"));
		System.out.println(redisService.set("sex","girl"));
		System.out.println(redisService.set("token","abcd",3l));
		System.out.println("token:"+redisService.get("token"));
		redisService.set("myhel","中国");

		User u=new User();
		u.setAddress("xx中");
		u.setId(2);
		u.setSex("男");
		u.setBirthday(new Date());
		redisService.set("user",u);




//		try {
//			Thread.sleep(3000l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.out.println(redisService.get("uname"));
		System.out.println(redisService.get("sex"));
		System.out.println("token:"+redisService.get("token"));
		System.out.println("myehl:"+redisService.get("myhel"));
		System.out.println(redisService.get("user"));

		if(1==1) return;
		redisService.remove("sex");


		System.out.println("==============list====================");
		redisService.lPush("l1","v1");
		redisService.lPush("l1","v2");
		redisService.lPush("l1","v3");
		System.out.println(redisService.lRange("l1",0,1));
		System.out.println(redisService.lRange("l1",0,-1));

		System.out.println("============== set ====================");
		redisService.add("s","s1");
		redisService.add("s","s2");
		redisService.add("s","s3");
		System.out.println(redisService.setMembers("s"));

		System.out.println("============== orderedset ====================");
		redisService.zAdd("z","z1",5);
		redisService.zAdd("z","z2",7);
		redisService.zAdd("z","z3",1);
		System.out.println(redisService.rangeByScore("z",1,6));

		System.out.println("============== hash ====================");
		redisService.hmSet("hash","hkey1","hval1");
		redisService.hmSet("hash","hkey2","hval2");
		System.out.println(redisService.hmGet("hash","hkey1"));
		System.out.println(redisService.hmGet("hash","hkey2"));

		System.out.println(redisService.getKeys("*"));

	}

	//@Test
	public void contextLoads() {
	}

}
