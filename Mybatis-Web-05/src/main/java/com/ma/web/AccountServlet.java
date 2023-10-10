package com.ma.web;

import com.ma.exceptions.MoneyNotEnoughException;
import com.ma.exceptions.TransferException;
import com.ma.service.AccountService;
import com.ma.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 10 9:25 PM
 * description:
 */


//@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String formActno = req.getParameter("formActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));
        // 调用service的转账方法

        try {
            accountService.transfer(formActno,toActno,money);
            // 调用View完成展示结果。
            resp.sendRedirect(req.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException | TransferException e) {
            resp.sendRedirect(req.getContextPath()+"/error.html");

        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }
}
