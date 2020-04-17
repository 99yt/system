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

@WebServlet("/update")
public class UpdateAnimalServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("id:"+req.getParameter("id"));
        //1. 获取请求参数
        Animal updateAnimal = new Animal(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("age")),
                req.getParameter("kind"),
                //value默认类型都是字符串
                req.getParameter("gender"));

        //2. 调用模型层Service实现删除操作
        AnimalService service = new AnimalService();
        try {
            int  updateResult = service.updateAnimal(updateAnimal);
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        //查询数据表，拼页面----QueryServlet已经处理
        //3. 返回结果（或者  直接返回删除结果：删除成功页面，删除失败页面）
        // 重新再次请求一次数据表数据，并展示数据
        resp.sendRedirect("query");//重定向方式
        //request.getRequestDispatcher("query").forward(request, response);//请求转发
    }


}
