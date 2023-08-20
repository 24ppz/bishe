<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2023/4/27
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载页面</title>
</head>
<body>
<%
    List<File> file=(List)request.getAttribute("name");
%>
<table>
    <thead>
    <tr>name</tr>
    <tr>link</tr>
    </thead>
    <tbody>
    <% for(File fl:file){  %>
    <tr>
        <td><%=file.getName%>></td>
        <td><%=file.getLink%>></td>
    </tr>
    <% } %>
    <tr></tr>
    </tbody>
</table>
</body>
</html>
