package org.contactApp.dao;

import org.contactApp.entity.Contacts;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContactDaoImpl implements ContactDao {

    public JdbcTemplate jdbcTemplate;
    @Override
    public int addContact(Contacts contacts) {
        return 0;
    }
}
