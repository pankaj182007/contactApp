package org.contactApp;

import org.contactApp.dao.ContactDao;
import org.contactApp.dao.ContactDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ContactConfig {
    @Bean("ds")
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean("contactDaoImpl")
    public ContactDao contactDao()
    {
        ContactDaoImpl contactDao=new ContactDaoImpl();
        contactDao.setJdbcTemplate(jdbcTemplate());
        return contactDao;
    }
}
