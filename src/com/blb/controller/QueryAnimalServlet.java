package com.blb.controller;

import com.blb.entily.Animal;
import com.blb.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/QueryAnimalServlet")
public class QueryAnimalServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、接受请求
        //2、调用模型层代码，处理请求
        AnimalService service=new AnimalService();
        List<Animal> animals=null;
        System.out.println("222");
        try {
            animals=service.queryAllAnimal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3、调用视图层，返回结果（servlet，拼页面）
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>宠物列表</title>");
        sb.append("</head>");

        sb.append("<body>");
        sb.append("<table border='1px' width='550px'>");

        sb.append("<tr><th>ID</th><th>NAME</th><th>AGE</th><th>KIND</th><th>GENDER</th><th>OPERATION</th></tr>");
        if(animals!=null)
            for (Animal animal : animals) {
                sb.append("<tr>");
                sb.append("<td>"+animal.getId()+"</td>");
                sb.append("<td>"+animal.getName()+"</td>");
                sb.append("<td>"+animal.getAge()+"</td>");
                sb.append("<td>"+animal.getKind()+"</td>");
                sb.append("<td>"+animal.getGender()+"</td>");
                sb.append("<td>&nbsp;<a href='del?delId="+animal.getId()
                        +"'>del</a> &nbsp;|&nbsp;<a href='queryOne?queryId="+animal.getId()+"'>update</a>&nbsp;</td>");
                sb.append("</tr>");
            }
        sb.append("</table>");
        //跳转添加宠物信息页面
        sb.append("<a href='addAnimal.html'>add</a>");
        sb.append("</body>");
        sb.append("</html>");

        //设置编码
        //解决html页面结果乱码（解决纯文本乱码）
        resp.setContentType("text/html;charset=utf-8");

        //解决纯文本乱码
        //response.setCharacterEncoding("gbk");
        //4. 返回宠物信息
        PrintWriter pw = resp.getWriter();
        pw.print(sb.toString());
    }
}
