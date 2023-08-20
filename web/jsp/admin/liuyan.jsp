<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" import="java.util.*,java.sql.*,com.zkk.util.*"%>
<%@ page import="com.zkk.pojo.LyTable" %>
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
                    ${sessionScope.adminSession.id}
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
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/teacher.do">教师管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/student.do">学生管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
<%--                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/tuisai.do">退赛信息</a></li>--%>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a></li>
                    <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
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
                    <th>操作</th>
                </tr>
                <c:forEach items="${liuyan}" var="l">
                    <tr>
                        <td><c:out value="${l.getId()}"/></td>
                        <td><c:out value="${l.getStudentName()}"/></td>
                        <td><c:out value="${l.getTitle()}"/></td>
                        <td><c:out value="${l.getContent()}"/></td>
                        <td><c:out value="${l.getReply()}"/></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/liuyanreply.do">
                                对<input name="id" value="${l.getId()}" readonly="readonly" style="width: 20px;">的回复：
                                <textarea name="content" rows="4" cols="30" required="required"></textarea>
                                <button type="submit" style="line-height: 30px;">回复</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
<%--        <form action="${pageContext.request.contextPath}/liuyanreply.do" method="post">--%>
<%--            <table border="1">--%>
<%--                <caption>填写回复信息</caption>--%>
<%--                <tr>--%>
<%--                    <td>留言ID</td>--%>
<%--                    <td><input type="text" name="id"/></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>回复内容</td>--%>
<%--                    <td><textarea name="content" rows="5" cols="100"></textarea></td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--            ${requestScope.success}--%>
<%--            ${requestScope.error}--%>
<%--            <input type="submit" value="提交"/>--%>
<%--            <input type="reset" value="重置"/>--%>
<%--        </form>--%>

    </div>
</div>
</body>
<!-- 引入 layui.js -->
<script src=${pageContext.request.contextPath}/static/layui/layui.js></script>
</html>