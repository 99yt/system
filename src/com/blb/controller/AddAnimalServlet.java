package com.blb.controller;

import com.blb.entily.Animal;
import com.blb.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddAnimalServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("name2:"+req.getParameter("name"));
        //1.获取请求参数
        Animal animal=new Animal(
                req.getParameter("name"),
               Integer.parseInt(req.getParameter("age")) ,
                req.getParameter("kind"),
                req.getParameter("gender")
        );

        //2、调用模型层service实现增加操作
        AnimalService service=new AnimalService();
        try {
            service.addAnimal(animal);
        } catch (SQLException e) {
            e.printStackTrace();
        }
          resp.sendRedirect("QueryAnimalServlet");
    }
}
