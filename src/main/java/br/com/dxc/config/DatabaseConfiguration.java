package br.com.dxc.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DatabaseConfiguration {

//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
//	@Bean
//	public SessionFactory sessionFactory() {
//		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//	    return sessionFactory;
//	}
}