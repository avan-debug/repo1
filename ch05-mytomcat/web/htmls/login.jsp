<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/2/11
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>
        window.onload = function (){
            document.getElementById("imgVeri").onclick = function (){
                let date = new Date().getTime();
                this.src = "/mytomcat/responseDemo1?" + date;
            }
        }
    </script>
</head>
<body>

    <form action="/mytomcat/loginVerify" method="post">
        name:<input name="username" type="text">
        <br/>
        password:<input name="password" type="password">
        <br/>
        verifyCode:<input name="verifyCode" type="text">
        <img id="imgVeri" src="/mytomcat/responseDemo1">
        <br/>
        <input type="submit" value="登录">
    </form>

    <%=request.getAttribute("cc_error")%>

</body>
</html>
