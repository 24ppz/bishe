<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>大学生线上科技竞赛报名系统-选择您的身份</title>
    <style type="text/css">
        center {
            background-image: url("../static/images/background.jpeg");
            background-size: 100%, 100%;
        }

        div {
            display: inline-block;
            padding-top: 80px;
            padding-right: 20px;
            width: 100%;
            height: 100%;
            margin-top: 0;
        }

        h2 {
            font-family: "微软雅黑", serif;
            font-size: 40px;
            color: black;
        }

        #log {
            color: blue;
        }
    </style>
</head>
<body>
<center>
    <div>
        <h2>
            大学生线上科技竞赛报名系统
        </h2>
        <p>
            <a href="student/login.jsp">
                <input type="button" onclick="window.location.href" value="我是学生">
            </a>
        </p>
<%--        <p>--%>
<%--            <a href="teacher/login.jsp">--%>
<%--                <input type="button" onclick="window.location.href" value="我是教师">--%>
<%--            </a>--%>
<%--        </p>--%>
        <p>
            <a href="admin/login.jsp">
                <input type="button" onclick="window.location.href" value="我是管理员">
            </a>
        </p>
        <p>
            <a href=./registry.jsp>
                <input type="button" onclick="window.location.href" value="我要注册">
            </a>
        </p>
    </div>
</center>
</body>
</html>
