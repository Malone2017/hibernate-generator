package com.malone;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);
	static {
		try {
			// 初始化log4j
			String log4jPath = Application.class.getClassLoader()
					.getResource("").getPath()
					+ "log4j.properties";
			PropertyConfigurator.configure(log4jPath);
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
