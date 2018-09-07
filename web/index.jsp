<%--
  Created by IntelliJ IDEA.
  User: DUSTY
  Date: 2018/9/7
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link href="form.css" type="text/css" rel="stylesheet">
  </head>
  <body>
  <form action="login.jsp" method="post" class="smart-green">
      <h1>系统登录</h1>

      <label>
          <span>用户名：</span>
          <input id="usename" type="text" name="username"/>
      </label>

      <label>
          <span>密码：</span>
          <input id="password" type="password" name="password"/>
      </label>

      <span>&nbsp;</span>

      <label>
          <input type="submit" class="button" value="登录">
      </label>
  </form>
  </body>
</html>
