package com.service;

import com.domain.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> queryAll(int currentPage, int pageSize);

    int queryPageCount(int pageSize);

    boolean delectById(String contactId);

    Contact queryById(String contactId);

    boolean update(Contact contact);

    boolean add(Contact contact);
}
