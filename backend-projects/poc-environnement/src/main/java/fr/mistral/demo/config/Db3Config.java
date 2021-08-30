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
@EnableJpaRepositories(entityManagerFactoryRef = "DB3EntityManagerFactory", transactionManagerRef = "DB3TransactionManager", basePackages = {
        "fr.mistral.demo.repositories.db3" })
public class Db3Config {

    @Bean(name = "DB3DataSource")
    @ConfigurationProperties(prefix = "spring.db3.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "DB3EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db3EntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("DB3DataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("fr.mistral.demo.domain.db3").persistenceUnit("db3").build();
    }

    @Bean(name = "DB3TransactionManager")
    public PlatformTransactionManager db3TransactionManager(
            @Qualifier("DB3EntityManagerFactory") EntityManagerFactory db3EntityManagerFactory) {
        return new JpaTransactionManager(db3EntityManagerFactory);
    }
}