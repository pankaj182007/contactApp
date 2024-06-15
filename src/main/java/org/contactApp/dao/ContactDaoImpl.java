package org.contactApp.dao;

import org.contactApp.entity.Contacts;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    JdbcTemplate jdbcTemplate;
    @Override
    public int addContact(Contacts contacts) {
        String insertQuary="insert into contacts(phone,name,location,email) values(?,?,?,?)";
        int result=jdbcTemplate.update(insertQuary,contacts.getPhoneNumber(),contacts.getName(),contacts.getLocation(),contacts.getEmail());
        return result;
    }

    @Override
    public int updateContact(Contacts contacts, String old) {

        String updateQuary=("update contacts set phone=?, name=?,location=?,email=?  where phone=?");
        int result=jdbcTemplate.update(updateQuary,contacts.getPhoneNumber(),contacts.getName(),contacts.getLocation(),contacts.getEmail(),old);
        return result;
    }

    @Override
    public Contacts fetchContact(String phone) {
        String selectQuary="select * from contacts where phone=?";
        RowMapper<Contacts> rowMapper=new RowMapperImpl();
        Contacts contacts=jdbcTemplate.queryForObject(selectQuary,rowMapper,phone);
        return contacts;
    }

    @Override
    public List<Contacts> allContacts() {
        String selectAllQuary="select * from contacts";
        RowMapper<Contacts> rowMapper=new RowMapperImpl();
        return jdbcTemplate.query(selectAllQuary,rowMapper);
    }

    @Override
    public int deleteContact(String phoneNumber) {
        String deleteQuary="delete from contacts where phone=?";
        return jdbcTemplate.update(deleteQuary,phoneNumber);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
