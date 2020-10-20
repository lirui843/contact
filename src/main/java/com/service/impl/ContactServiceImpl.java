package com.service.impl;

import com.dao.ContactDAO;
import com.dao.impl.ContactDAOImpl;
import com.domain.Contact;
import com.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactDAO cdao = new ContactDAOImpl();
    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffice = (currentPage-1)*pageSize;

        return cdao.queryAll(pageOffice,pageSize);
    }

    @Override
    public int queryPageCount(int pageSize) {
        int count = cdao.queryCount(pageSize);

        return (int) Math.ceil(count/(double)pageSize);
    }

    @Override
    public boolean delectById(String contactId) {
        int sum = cdao.delectById(contactId);
        return sum==1;
    }

    @Override
    public Contact queryById(String contactId) {
        Contact contact = cdao.queryById(contactId);
        return contact;
    }

    @Override
    public boolean update(Contact contact) {
        int sum = cdao.update(contact);
        return sum==1;
    }

    @Override
    public boolean add(Contact contact) {
        int result = cdao.add(contact);
        return result==1;
    }
}
