package com.dao;

import com.domain.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> queryAll(int pageOffice, int pageSize);

    int queryCount(int pageSize);

    int delectById(String contactId);

    Contact queryById(String contactId);

    int update(Contact contact);

    int add(Contact contact);
}
