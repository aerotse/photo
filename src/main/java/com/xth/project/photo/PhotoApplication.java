package com.xth.project.photo;

import com.xth.project.photo.listener.PropertiesListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhotoApplication {

	/**
	 * 项目开始运行
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PhotoApplication.class);
		application.addListeners(new PropertiesListener("application.properties"));
		application.run(args);

		//手动启动 读取配置文件
//		PropertiesListener propertiesListener = new PropertiesListener("application.properties");
//		propertiesListener.onApplicationEvent(null);

//		SpringApplication.run(PhotoApplication.class, args);
	}

}


