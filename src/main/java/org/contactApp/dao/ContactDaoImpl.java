package org.contactApp.dao;

import org.contactApp.entity.Contacts;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContactDaoImpl implements ContactDao {

    JdbcTemplate jdbcTemplate;
    @Override
    public int addContact(Contacts contacts) {
        String insertQuary="insert into contacts(phone,name,location,email) values(?,?,?,?)";
        int result=jdbcTemplate.update(insertQuary,contacts.getPhoneNumber(),contacts.getName(),contacts.getLocation(),contacts.getEmail());
        return result;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
