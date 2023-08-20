<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>教师登录</title>
    <style type="text/css">
        form {
            width: 100%;
            height: 100%;
            margin-top: 0;
            background-image: url("${pageContext.request.contextPath}/static/images/background.jpeg");
            background-size: 100%, 100%;
        }

        div {
            display: inline-block;
            padding-top: 80px;
            padding-right: 20px;

        }

        h2 {
            font-family: "微软雅黑", serif;
            font-size: 40px;
            color: black;
        }
    </style>
</head>
<body>
<form name="teacherLogin" action="${pageContext.request.contextPath}/teacherLogin.do" method="post">
    <center>
        <div>
            <h2>
                大学生线上科技竞赛报名系统
            </h2>
            <p>
                ${requestScope.error}
            </p>
            <p>
                账号:<label>
                <input type="text" name="id" placeholder="工号"/>
            </label>
            </p>
            <p>
                密码:<label>
                <input type="password" name="password"/>
            </label>
            </p>
            <p>
                <input id="teacherLogin" type="submit" value="教师登录"/>
            </p>
            <p>
                <a href="${pageContext.request.contextPath}/jsp/student/login.jsp">
                    <input type="button" onclick="window.location.href" value="我是学生">
                </a>
            </p>
            <p>
                <a href="${pageContext.request.contextPath}/jsp/admin/login.jsp">
                    <input type="button" onclick="window.location.href" value="我是管理员">
                </a>
            </p>
        </div>
    </center>
</form>
</body>
</html>
