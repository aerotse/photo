package com.xth.project.photo.resetful.web;

import com.alibaba.fastjson.JSON;
import com.xth.project.photo.common.PropertyListenerConfig;
import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import com.xth.project.photo.service.RepositoryEmergencyReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xieth on 2019/1/24.
 */
@RestController
@RequestMapping("/web/test")
public class Test {

    @Value("${jdbc-0.user}")
    private String name;

    @Autowired
    private RepositoryEmergencyReadService repositoryEmergencyReadService;

    @RequestMapping("/demo")
    public String testDemo(){
        String result = JSON.toJSONString(PropertyListenerConfig.getPropertyMap());
        RepositoryEmergencyDO repositoryEmergencyDO = repositoryEmergencyReadService.query();
        return JSON.toJSONString(repositoryEmergencyDO);
    }
}
