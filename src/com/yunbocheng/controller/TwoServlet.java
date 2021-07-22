package com.yunbocheng.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.调用请求对象，向Tomcat索要当前用户在服务端私人保险柜
        HttpSession session = req.getSession();
        // 2.将session中所有的key取出来，这里的key就是商品名称，存放在一个枚举对象
        Enumeration goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()){
            String goodsName = (String) goodsNames.nextElement();
            // 根据这个商品的商品名将这个商品的数量取出来，这个时候可以用int接收，
            // 因为此时是从保险柜里边拿出来，保险柜是一个mqp集合，里边只要有key，肯定存在value
            // 所以不会产生空指针异常
            int goodsNum = (int) session.getAttribute(goodsName);
            System.out.println("商品名称 " + goodsName +" " +  "商品数量 " +goodsNum);
        }
    }
}
