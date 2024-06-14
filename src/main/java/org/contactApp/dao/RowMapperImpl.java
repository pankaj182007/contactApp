package org.contactApp.dao;

import org.contactApp.entity.Contacts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements org.springframework.jdbc.core.RowMapper {
    @Override
    public Contacts mapRow(ResultSet resultSet, int i) throws SQLException {
        Contacts contacts=new Contacts();
        contacts.setPhoneNumber(resultSet.getString(1));
        contacts.setName(resultSet.getString(2));
        contacts.setLocation(resultSet.getString(3));
        contacts.setEmail(resultSet.getString(4));
        return contacts;
    }
}
