package com.web;

import com.domain.Contact;
import com.service.ContactService;
import com.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/update_broker")
public class UpdateBrokerServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String contactId = request.getParameter("id");

        //处理数据
        Contact contact = contactService.queryById(contactId);
        //响应数据
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
