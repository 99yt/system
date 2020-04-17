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

@WebServlet("/queryOne")
public class QueryOneAnimal extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数
        String queryId = req.getParameter("queryId");
        System.out.println(queryId);
        //2. 调用模型层Service实现查询操作
        AnimalService service = new AnimalService();
        try {
            Animal queryOneAnimal = service.queryOneAnimal(Integer.parseInt(queryId));

            //3. 返回结果（或者  直接返回删除结果：删除成功页面，删除失败页面）
            //拼写返回页面
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>更新宠物信息</title>");
            sb.append("</head>");

            sb.append("<body>");
            sb.append("<form action='update' method='post'>");
            //input  disabled  后台获取不到提交的数据
            //readOnly确保当前表单元素无法修改
            sb.append("id<input type='text' name='id' readOnly style='background:#f2f2f2'  value='"+queryOneAnimal.getId()+"'><br>");
            sb.append("name<input type='text'  name='name'   value='"+queryOneAnimal.getName()+"'><br>");
            sb.append("kind<input type='text'  name='kind' value='"+queryOneAnimal.getKind()+"'><br>");
            sb.append("age<input type='text'  name='age' value='"+queryOneAnimal.getAge()+"'><br>");
            sb.append("gender<input type='text'  name='gender' value='"+queryOneAnimal.getGender()+"'><br>");
            sb.append("<input type='submit'  value='update'><br>");

            sb.append("</form>");
            //跳转添加宠物信息页面
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

        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
