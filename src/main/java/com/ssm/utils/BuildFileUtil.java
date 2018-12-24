package com.ssm.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Mybatis自动生成文件
 */
public class BuildFileUtil {
	
	public String getPath(){
		return this.getClass().getClassLoader().getResource("generator.xml").getPath();
	}
	
	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		BuildFileUtil buildFile = new BuildFileUtil();
		String filePath = buildFile.getPath().substring(1);
		
		File configFile = new File(filePath);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		config = cp.parseConfiguration(configFile);
		
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
	}
	
	

}
