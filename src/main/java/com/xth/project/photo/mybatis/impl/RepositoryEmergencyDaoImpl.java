package com.xth.project.photo.mybatis.impl;

import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import com.xth.project.photo.mybatis.RepositoryEmergencyDao;
import com.xth.project.photo.mybatis.base.BaseDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xieth on 2018/10/31.
 */
@Component
public class RepositoryEmergencyDaoImpl extends BaseDao implements RepositoryEmergencyDao {
    @Override
    public int insertRepositoryEmergency(RepositoryEmergencyDO record) {
        return super.insert("RepositoryEmergencyDaoImpl_insertRepositoryEmergency", record);
    }

    @Override
    public RepositoryEmergencyDO selectRepositoryEmergencyById(RepositoryEmergencyDO record) {
        Map<String, Object> param = new HashMap();
        param.put("id", record.getId());
        return (RepositoryEmergencyDO)super.findForObject("RepositoryEmergencyDaoImpl_selectRepositoryEmergencyById", param);
    }

    @Override
    public int updateRepositoryEmergency(RepositoryEmergencyDO record) {
        return super.update("RepositoryEmergencyDaoImpl_updateRepositoryEmergency", record);
    }

    @Override
    public int deleteyRepositoryEmergency(RepositoryEmergencyDO record) {
        Map<String, Object> param = new HashMap();
        param.put("id",record.getId());
        param.put("validFlag", "1");
        param.put("updateId", String.valueOf(record.getUpdateId()));
        param.put("updateName", record.getUpdateName());
        return super.update("RepositoryEmergencyDaoImpl_deleteRepositoryEmergency", param);
    }
}
