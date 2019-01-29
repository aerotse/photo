package com.xth.project.photo.listener;

import com.xth.project.photo.common.PropertyListenerConfig;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by xieth on 2019/1/25.
 */
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent>{

    private String propertyFileName;

    public PropertiesListener(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        PropertyListenerConfig.loadAllProperties(propertyFileName);
    }
}
