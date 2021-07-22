package com.yunbocheng.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsName;
        // 1.调用请求对象，读取请求头参数，得到用户选择商品名
        goodsName = req.getParameter("goodsName");
        System.out.println(goodsName);
        // 2.调用请求对象，向Tomcat索要当前用户在服务器端的私人储存柜
        HttpSession session = req.getSession();
        // 3.讲用户选购的商品添加到当前用户私人保险柜
        // 注意：这里万一可能会加入两太或者多台，此时要判断是一台还是两台
        // 这里要判断一下是一台计算机还是两台计算机
        // 这行代码是判断用户购买了几台笔记本，如果没有会为Null，
        // Integer可以接收空指针异常，不会发生错误。
        Integer goodsNum = (Integer)session.getAttribute(goodsName);
        if(goodsNum == null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,goodsNum+1);
        }
    }
}

