package com.xth.project.photo.mapper;

import com.xth.project.photo.domain.dbdo.RepositoryEmergencyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xieth on 2019/1/29.
 */
@Mapper
public interface RepositoryEmergencyMapper {

    /**
     * 输入数据
     * @param record
     * @return
     */
    int insertRepositoryEmergency(RepositoryEmergencyDO record);

    /**
     * 查询数据
     * @param
     * @return
     */
    RepositoryEmergencyDO selectRepositoryEmergencyById(@Param("id") Long id);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateRepositoryEmergency(RepositoryEmergencyDO record);

    /**
     * 删除数据
     * @param record
     * @return
     */
    int deleteyRepositoryEmergency(RepositoryEmergencyDO record);
}
