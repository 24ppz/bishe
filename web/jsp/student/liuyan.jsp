<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" import="java.util.*,java.sql.*,com.zkk.util.*"%>
<html>
<head>
    <title>管理系统大布局</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href=${pageContext.request.contextPath}/static/layui/layui.css>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">

    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/background.jpg");
            background-size: 100%, 100%;
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
                    ${sessionScope.studentSession.studentName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/studentLoginOut.do">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/student/information.jsp">个人信息</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/selectCompetition.do">竞赛</a></li>
                    <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/liuyanll.do">查看所有留言</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/student/card.jsp">打印参赛证</a></li>

                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a></li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body" style="border-radius: 3px;padding: 3px;">
        <!-- 内容主体区域 -->

<%--        ${requestScope.liuyan}--%>
        <div>
            <table>
                <tr>
                    <th>留言编号</th>
                    <th>学生姓名</th>
                    <th>标题</th>
                    <th>留言内容</th>
                    <th>回复</th>
                </tr>
                <c:forEach items="${liuyan}" var="l">
                    <tr>
                        <td><c:out value="${l.getId()}"/></td>
                        <td><c:out value="${l.getStudentName()}"/></td>
                        <td><c:out value="${l.getTitle()}"/></td>
                        <td><c:out value="${l.getContent()}"/></td>
                        <td><c:out value="${l.getReply()}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form action="${pageContext.request.contextPath}/liuyan.do" method="post">
            <table border="1">
                <center><h1>填写留言信息</h1></center>
                <tr>
                    <td>留言标题</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>留言内容</td>
                    <td><textarea name="content" rows="10" cols="170"></textarea></td>
                </tr>
            </table>
            <p style="color: red;margin-top: 3px;position: center">${requestScope.success}</p>
            <p style="color: red;margin-top: 3px;position: center">${requestScope.error}</p>
            <p style="color: red;margin-top: 3px;position: center">${requestScope.titleNull}</p>
            <p style="color: red;margin-top: 3px;position: center">${requestScope.contentNull}</p>
            <input type="submit" value="提交" style="float: right;margin-top: 20px;margin-right: 20px;"/>
            <input type="reset" value="重置" style="float: right;margin-top: 20px;margin-right: 20px;"/>
        </form>
    </div>
</div>
</body>
<!-- 引入 layui.js -->
<script src=${pageContext.request.contextPath}/static/layui/layui.js></script>
</html>