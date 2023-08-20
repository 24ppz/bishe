<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理系统大布局</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">

    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/background.jpg");
            background-size: 100%, 100%;
        }
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        form {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">后台</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src=""
                         class="layui-nav-img">
                    admin
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/adminLoginOut.do">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/teacher.do">教师管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/student.do">学生管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
<%--                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/tuisai.do">退赛信息</a></li>--%>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>发布竞赛</h1>
            <form method="post" name="addCompetition" action="${pageContext.request.contextPath}/addCompetition.do">

                    ${requestScope.idLength}
                    <br>
                    <label>编号：
                        <input type="text" name="id">
                    </label>

                    ${requestScope.competitionNameNull}
                    <br>
                    <label>名称：
                        <input type="text" name="competitionName">
                    </label>

                    ${requestScope.dateNull}
                    <br>
                    <label>截止日期：
                        <input type="date" name="date">
                    </label>
                <br>

                    <label>描述：
                        <textarea name="describe"></textarea>
                    </label>

                    ${requestScope.teacherIdLength}
                    <br>
                    <label>教师工号：
                        <input type="text" name="teacherId">
                    </label>

                    ${requestScope.teacherNameCode}
                    <br>${requestScope.teacherNameNull}
                    <br>
                    <label>教师：
                        <input type="text" name="teacherName">
                    </label>

                ${requestScope.error}
                <br><input type="submit" value="添加">
            </form>

        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <%@ include file="../common/foot.jsp" %>
    </div>
</div>
</body>
<!-- 引入 layui.js -->
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
</html>




