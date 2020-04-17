<%--
  Created by IntelliJ IDEA.
  User: 杨tao
  Date: 2020/2/18
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询宠物</title>
    <script type="text/javascript" src="js/vue.js"></script>
</head>
<body>
    <form action="/ManangServlet" method="post">
       <table border="1px" width="500" id="animalList">
           <tr>
               <th>序号</th>
               <th>名字</th>
               <th>年龄</th>
               <th>品种</th>
               <th>性别</th>
           </tr>
           <tr v-for='animal of animals'>
               <td>{{animal.id}}</td>
               <td>{{animal.name}}</td>
               <td>{{animal.age}}</td>
               <td>{{animal.kind}}</td>
               <td>{{animal.gender}}</td>
           </tr>
       </table>
    </form>
</body>
<script type='text/javascript'>
    var vm = new Vue({
        el:'#animalList',
        data:{
            animal:"jsonarray"
        }
    })
</script>
</html>
