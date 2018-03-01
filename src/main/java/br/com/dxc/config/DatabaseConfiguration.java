//package br.com.dxc.config;
//
//import java.util.Properties;
//
//import javax.annotation.PreDestroy;
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.util.Assert;
//import org.springframework.util.StringUtils;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import br.com.dxc.exception.ApplicationBusinessExceptionCode;
//
//@Configuration
//@EntityScan({"br.com.dxc.model"})
//@EnableJpaRepositories({"br.com.dxc.repository"})
//@EnableTransactionManagement
//public class DatabaseConfiguration implements EnvironmentAware {
//    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
//
//    private RelaxedPropertyResolver propertyResolver;
//    private RelaxedPropertyResolver propertyResolverDatabase;
//    private HikariDataSource pool;
//
//
//    public void setEnvironment(Environment environment) {
//        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
//        this.propertyResolverDatabase = new RelaxedPropertyResolver(environment, "spring.jpa.database");
//    }
//
//    @Bean(destroyMethod = "shutdown")
//    public DataSource dataSource() {
//        this.log.debug("Configuring Datasource");
//        if (StringUtils.isEmpty(this.propertyResolver.getProperty("dataSourceClassName"))) {
//            throw new RuntimeException("A configuração do datasource não está correta, verifique os parâmetros necessários");
//        }
//        HikariConfig config = this.getDataSourceConfig(this.propertyResolver.getProperty("username"), this.propertyResolver.getProperty("password"), this.propertyResolver.getProperty("databaseName"));
//        return (this.pool = new HikariDataSource(config));
//    }
//
//    private HikariConfig getDataSourceConfig(String username, String password, String databaseName) {
//        HikariConfig config = new HikariConfig();
//        config.setAutoCommit(false);
//        config.setDataSourceClassName(this.propertyResolver.getProperty("dataSourceClassName"));
//        config.addDataSourceProperty("databaseName", databaseName);
//        config.addDataSourceProperty("user", username);
//        config.addDataSourceProperty("password", password);
//
//        config.setConnectionTimeout(this.propertyResolver.getProperty("ConnectionTimeout", Long.class, 60000L));
//        config.setIdleTimeout(this.propertyResolver.getProperty("IdleTimeout", Long.class, 1200000L));
//        config.setMaximumPoolSize(this.propertyResolver.getProperty("MaximumPoolSize", Integer.class, 20));
//
//        return config;
//    }
//
//    @Bean
//    @ConditionalOnBean(name = "dataSource")
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource(), true);
//    }
//
//    @Bean
//    @ConditionalOnBean(name = "dataSource")
//    public Database database() {
//        String database = this.propertyResolverDatabase.getProperty("", "MYSQL").toUpperCase();
//        Assert.notNull(database, ApplicationBusinessExceptionCode.CRESOL_ERROR.getDescricao());
//        if (Database.ORACLE.name().equalsIgnoreCase(database)) {
//            return Database.ORACLE;
//        }
//        if (Database.MYSQL.name().equalsIgnoreCase(database)) {
//            return Database.MYSQL;
//        }
//
//        return null;
//    }
//
//
//    @PreDestroy
//    public void close() {
//        if (this.pool != null) {
//            this.pool.close();
//        }
//    }
//
//    public enum Database {
//        MYSQL, ORACLE
//    }
//}
