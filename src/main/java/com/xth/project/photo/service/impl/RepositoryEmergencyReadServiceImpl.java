package com.xth.project.photo.service.impl;

import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import com.xth.project.photo.mapper.RepositoryEmergencyMapper;
import com.xth.project.photo.service.RepositoryEmergencyReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xieth on 2019/1/25.
 */
@Service
public class RepositoryEmergencyReadServiceImpl implements RepositoryEmergencyReadService {

    @Autowired
    private RepositoryEmergencyMapper repositoryEmergencyMapper;

    @Override
    public RepositoryEmergencyDO query(){
        RepositoryEmergencyDO repositoryEmergencyDO = repositoryEmergencyMapper.selectRepositoryEmergencyById(111L);
        return repositoryEmergencyDO;
    }

}
