package com.xth.project.photo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renyueliang on 17/3/25.
 */
public abstract class BaseDO implements Serializable, Cloneable {

    private static final long serialVersionUID = 8019876456649066996L;

    /**
     * 创建人
     */
    private long createId;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    public long getCreateId() {
        return createId;
    }

    public void setCreateId(long createId) {
        this.createId = createId;
    }

    public long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(long updateId) {
        this.updateId = updateId;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
