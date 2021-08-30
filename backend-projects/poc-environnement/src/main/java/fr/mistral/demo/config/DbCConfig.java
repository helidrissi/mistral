package fr.mistral.demo.config;




import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "DBCEntityManagerFactory", transactionManagerRef = "DBCTransactionManager", basePackages = {
        "fr.mistral.demo.repositories.central" })
public class DbCConfig {

    @Bean(name = "DBCDataSource")
    @ConfigurationProperties(prefix = "spring.dbc.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "DBCEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db3EntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("DBCDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("fr.mistral.demo.domain.central").persistenceUnit("central").build();
    }

    @Bean(name = "DBCTransactionManager")
    public PlatformTransactionManager dbcTransactionManager(
            @Qualifier("DBCEntityManagerFactory") EntityManagerFactory dbcEntityManagerFactory) {
        return new JpaTransactionManager(dbcEntityManagerFactory);
    }
}