<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode("参赛表.xls", "UTF-8"));
%>
<html>
<head>
    <title>参加竞赛表</title>
</head>
<body>
<table>
    <c:forEach items="${student}" var="s">
        <tr>
            <th>学生学号</th>
            <th>密码</th>
            <th>系部</th>
            <th>年级</th>
            <th>班级</th>
            <th>姓名</th>
            <th>参加竞赛</th>
        </tr>
        <tr>
            <td><c:out value="${s.getId()}"/></td>
            <td><c:out value="${s.getPassword()}"/></td>
            <td><c:out value="${s.getDepartment()}"/></td>
            <td><c:out value="${s.getGrade()}"/></td>
            <td><c:out value="${s.getClassName()}"/></td>
            <td><c:out value="${s.getStudentName()}"/></td>
            <td><c:out value="${s.getCompetitionName()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
