package com.xth.project.photo.mybatis;


import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;

/**
 * Created by xieth on 2018/10/31.
 */
public interface RepositoryEmergencyDao {
    int insertRepositoryEmergency(RepositoryEmergencyDO record);

    RepositoryEmergencyDO selectRepositoryEmergencyById(RepositoryEmergencyDO record);

    int updateRepositoryEmergency(RepositoryEmergencyDO record);

    int deleteyRepositoryEmergency(RepositoryEmergencyDO record);
}
