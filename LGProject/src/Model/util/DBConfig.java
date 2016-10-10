package Model.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConfig {
	
	static SqlSessionFactory factory;
	
	static {
	
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream("conf/sqlMapConfig.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
	public static void closeSession(SqlSession session) {
		if(session != null) {
			session.close();
			session = null;
		}
	}
	
	public static void closeSession(boolean commit, SqlSession session) {
		if(session != null) {
			
			if(commit) session.commit();
			else session.rollback();
			
			session.close();
			session = null;
		}
	}
}
