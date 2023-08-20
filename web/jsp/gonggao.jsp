<%@ page import="com.zkk.pojo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>公告</title>
    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/background.jpeg");
            background-size: 100%, 100%;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #8bb4c0;
            color: white;
        }
        td {
            background-color: #c8d6dc;
        }
    </style>
</head>
<body>
<sql:setDataSource var="connection" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost/kjcomplet?useSSL=false&characterEncoding=utf8"
                   user="root" password="root"/>

<sql:query dataSource="${connection}" var="result">
    SELECT * from notice;
</sql:query>
<div style="padding: 20px;margin-top: 50px;margin-left: 200px;margin-right: 200px;">
    <div id="main">
        <h1>公告下载</h1>
        <table style="padding: 20px;" class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>URL下载</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${result.rows}" var="row">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><a href="../${row.url}" download=""><c:out value="点我下载"/></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
