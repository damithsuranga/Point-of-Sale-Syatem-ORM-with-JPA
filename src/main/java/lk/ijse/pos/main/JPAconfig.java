package lk.ijse.pos.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.DriverManager;
@Configuration
@PropertySource("file:${user.dir}/resources/application.properties")
@EnableTransactionManagement
public class JPAconfig {

    @Autowired
    private Environment env;


        @Bean
        public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean(DataSource ds,JpaVendorAdapter venderAdapter){
            LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
            lcemfb.setDataSource(ds);
            lcemfb.setJpaVendorAdapter(venderAdapter);
            lcemfb.setPackagesToScan("lk.ijse.pos");
            return lcemfb;

        }

        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName(env.getRequiredProperty("javax.persistence.jdbc.driver"));
            ds.setUrl(env.getRequiredProperty("javax.persistence.jdbc.url"));
            ds.setUsername(env.getRequiredProperty("javax.persistence.jdbc.user"));
            ds.setPassword(env.getRequiredProperty("javax.persistence.jdbc.password"));
            return ds;
        }

        @Bean
        public JpaVendorAdapter vendorAdapter(){
            HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
            adapter.setDatabase(Database.MYSQL);
            adapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
            adapter.setShowSql(Boolean.getBoolean(env.getRequiredProperty("hibernate.show_sql")));
            adapter.setGenerateDdl(env.getRequiredProperty("hibernate.hbm2ddl.auto").equalsIgnoreCase("update")?true:false);
            return adapter;
        }

        @Bean
        public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf){
            return new JpaTransactionManager(emf);
        }

}
