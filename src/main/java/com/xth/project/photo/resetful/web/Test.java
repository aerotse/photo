package com.xth.project.photo.resetful.web;

import com.alibaba.fastjson.JSON;
import com.xth.project.photo.common.PropertyListenerConfig;
import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import com.xth.project.photo.service.RepositoryEmergencyReadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xieth on 2019/1/24.
 */
@RestController
@RequestMapping("/web/test")
public class Test {

    private static Logger logger = Logger.getLogger(Test.class);

    private String name;

    @Autowired
    private RepositoryEmergencyReadService repositoryEmergencyReadService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String testDemo(@RequestParam(value = "id", required = false) Long id){
        logger.info("id:" + id);
        if(id == null || id == 0L){
            id = 11L;
        }
        String result = JSON.toJSONString(PropertyListenerConfig.getPropertyMap());
        RepositoryEmergencyDO repositoryEmergencyDO = repositoryEmergencyReadService.query(id);
        logger.info("repositoryEmergencyDO:" + JSON.toJSONString(repositoryEmergencyDO));
        return JSON.toJSONString(repositoryEmergencyDO);
    }
}
