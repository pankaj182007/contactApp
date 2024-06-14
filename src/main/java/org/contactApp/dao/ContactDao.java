package org.contactApp.dao;

import org.contactApp.entity.Contacts;

public interface ContactDao {

    public int addContact(Contacts contacts);

    public int updateContact(Contacts contacts, String old);

    public Contacts fetchContact(String phone);
}
