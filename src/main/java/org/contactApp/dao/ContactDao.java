package org.contactApp.dao;

import org.contactApp.entity.Contacts;

import java.util.List;

public interface ContactDao {

    public int addContact(Contacts contacts);

    public int updateContact(Contacts contacts, String old);

    public Contacts fetchContact(String phone);
    public List<Contacts> allContacts();
    public int deleteContact(String phoneNumber);
}
