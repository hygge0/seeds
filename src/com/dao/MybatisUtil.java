package com.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	static SqlSessionFactory factory=null;
	static {
		String resource="configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����session����
		factory=new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	public static SqlSession openSession() {
		
		return factory.openSession();
	}
}
