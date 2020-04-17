package com.blb.controller;

import com.blb.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/del")
public class DelAnimalServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数
        String delIdStr=req.getParameter("delId");
        System.out.println(delIdStr);
        //2、调用模型层Service实现删除操作
        AnimalService service=new AnimalService();
        try {
            int delResult= service.delAnimal(Integer.parseInt(delIdStr));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3. 返回结果（或者  直接返回删除结果：删除成功页面，删除失败页面）
        // 重新再次请求一次数据表数据，并展示数据
        resp.sendRedirect("QueryAnimalServlet");//重定向方式
       }
}
