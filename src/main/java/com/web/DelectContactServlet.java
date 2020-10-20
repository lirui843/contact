package com.web;

import com.service.ContactService;
import com.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delect_contact")
public class DelectContactServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String contactId = request.getParameter("id");

        //处理数据
        contactService.delectById(contactId);


        //响应数据
        request.setAttribute("contactId",contactId);
        response.sendRedirect("query_contact_page");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
