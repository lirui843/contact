package com.web;

import com.domain.Contact;
import com.service.ContactService;
import com.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact = new Contact();
        //处理数据
        try{
            BeanUtils.populate(contact,parameterMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        contactService.update(contact);
        //响应数据
        request.setAttribute("contact",contact);
        response.sendRedirect("query_contact_page");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
