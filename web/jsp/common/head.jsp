
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .headUl {
            margin: 0;
            list-style: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 40px;
            background: black;
        }

        .headLi {
            font-weight: bold;
            font-size: large;
            text-align: center;
            margin-top: 5px;
            margin-left: 10px;
            width: 20%;
            height: 30px;
            background: orange;
            float: left;
        }

        .headA {
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
<ul class="headUl">
    <a class="headA" href="${pageContext.request.contextPath}/jsp/student/information.jsp">
        <li class="headLi">个人信息</li>
    </a>
    <a class="headA" href="${pageContext.request.contextPath}/jsp/student/joinCompetition.jsp">
        <li class="headLi">比赛通道</li>
    </a>
    <a class="headA" href="${pageContext.request.contextPath}/studentLoginOut.do">
        <li class="headLi">退出登录</li>
    </a>
</ul>
</body>
</html>
