<%--
  Created by IntelliJ IDEA.
  User: DUSTY
  Date: 2018/9/7
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--本demo默认限制用户名唯一--%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    session.setAttribute("loginUser",username);

    response.sendRedirect(request.getContextPath() + "/main.jsp");
%>
