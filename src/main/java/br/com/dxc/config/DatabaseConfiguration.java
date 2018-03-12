//package br.com.dxc.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//public class DatabaseConfiguration {
//	
////	@Autowired
////	private EntityManagerFactory entityManagerFactory;
//	
//	@Bean
//	@ConfigurationProperties("spring.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	
////	@Bean
////	public SessionFactory getSessionFactory() {
////		Session session = entityManagerFactory.unwrap(Session.class);
////		SessionFactory sessionFactory = session.getSessionFactory(); 
//////		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//////	    if (sessionFactory == null) {
//////	        throw new NullPointerException("factory is not a hibernate factory");
//////	    }
////	    return sessionFactory;
////	}
//}