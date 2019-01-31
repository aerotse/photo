package com.xth.project.photo;

import com.alibaba.fastjson.JSON;
import com.xth.project.photo.common.PropertyListenerConfig;
import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import com.xth.project.photo.service.RepositoryEmergencyReadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoApplicationTests {

	@Autowired
	private RepositoryEmergencyReadService repositoryEmergencyReadService;

	@Test
	public void contextLoads() {
		String result = JSON.toJSONString(PropertyListenerConfig.getPropertyMap());
		RepositoryEmergencyDO repositoryEmergencyDO = repositoryEmergencyReadService.query(51L);
		System.out.println("repositoryEmergencyDO:" + JSON.toJSONString(repositoryEmergencyDO));
	}

}

