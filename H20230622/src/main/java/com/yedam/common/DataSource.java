package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	//SqlSessionFactory object return
	private static SqlSessionFactory instance;
	private DataSource() {
		
	}
	public static SqlSessionFactory getInstance() {	
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			instance = new SqlSessionFactoryBuilder().build(inputStream);			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return instance;
	}
	
}
