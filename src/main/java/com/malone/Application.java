package com.malone;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

@SpringBootApplication
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);
	public static Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
	static {
		try {
			cfg.setDirectoryForTemplateLoading(new File(Application.class.getClassLoader().getResource("").getPath() + "/templates"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			
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
		logger.info("测试一下");
		SpringApplication.run(Application.class, args);
	}
}
