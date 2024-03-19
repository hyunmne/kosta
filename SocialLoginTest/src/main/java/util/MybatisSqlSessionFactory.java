package util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try {
			// 설정파일에 스트림 생성
			InputStream inputStream = Resources.getResourceAsStream("resource/mybatis-config.xml");
			
			// Sql Session factory builder 생성
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

			// Sql Session factory builder 생성
			sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
