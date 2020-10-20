package com.dao.impl;

import com.dao.ContactDAO;
import com.domain.Contact;
import com.utils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    private JdbcTemplate jdbc = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public List<Contact> queryAll(int pageOffice, int pageSize) {
        String sql = "select * from contact_info where del=0 limit ?,?";
        List<Contact> query = jdbc.query(sql, new BeanPropertyRowMapper<>(Contact.class),pageOffice,pageSize);
        return query;
    }

    @Override
    public int queryCount(int pageSize) {
        String sql = "select count(*) from contact_info where del=0";
        Integer query = jdbc.queryForObject(sql,Integer.class);
        return query;
    }

    @Override
    public int delectById(String contactId) {
        String sql = "update contact_info set del=1 where id=?";
        int update = jdbc.update(sql, contactId);
        return update;
    }

    @Override
    public Contact queryById(String contactId) {
        String sql = "select * from contact_info where id=? and del=0";
        List<Contact> query = jdbc.query(sql, new BeanPropertyRowMapper<>(Contact.class), contactId);
        if(query.size()==1){
            return query.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int update(Contact contact) {
        String sql = "update contact_info set name=?,gender=?,birthday=?,birthplace=?,mobile=?,email=? where del=0 and id=?";

        return jdbc.update(sql, contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
    }

    @Override
    public int add(Contact contact) {
        String sql ="insert into contact_info(`name`,`gender`,`birthday`,`birthplace`,`mobile`,`email`) value(?,?,?,?,?,?)";
        return jdbc.update(sql, contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail());
    }
}
