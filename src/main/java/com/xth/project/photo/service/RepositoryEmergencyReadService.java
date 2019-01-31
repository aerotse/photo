package com.xth.project.photo.service;

import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;

/**
 * Created by xieth on 2019/1/25.
 */
public interface RepositoryEmergencyReadService {

    RepositoryEmergencyDO query(Long id);

}
