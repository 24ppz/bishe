<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/teacher.do">教师管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/student.do">学生管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a>
                    </li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
                    <%--                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/tuisai.do">退赛信息</a></li>--%>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a>
                    </li>
                    <li class="layui-nav-item"><a
                            href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
                    </li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <div>
                <div style="float: right;">
                    <form method="post" name="addTeacher"
                          action="${pageContext.request.contextPath}/jsp/admin/addTeacher.jsp">
                        <input type="submit" value="添加教师">
                    </form>
                </div>
                <table>
                    <tr>
                        <th>教师工号</th>
                        <th>密码</th>
                        <th>系部</th>
                        <th>教师姓名</th>
                        <th>管理竞赛</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${teacher}" var="t">
                        <tr>
                            <td><c:out value="${t.getId()}"/></td>
                            <td><c:out value="${t.getPassword()}"/></td>
                            <td><c:out value="${t.getDepartment()}"/></td>
                            <td><c:out value="${t.getTeacherName()}"/></td>
                            <td><c:out value="${t.getCompetitionName()}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/jsp/admin/updateTeacher.jsp?id=${t.getId()}&tname=${t.getTeacherName()}&cname=${t.getCompetitionName()}"><button>修改</button></a>
                                <a href="${pageContext.request.contextPath}/deleteTeacher.do?id=${t.getId()}"><button>删除</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

<%--                <div style="float: left">--%>
<%--                    <form method="post" name="updateTeacher"--%>
<%--                          action="${pageContext.request.contextPath}/jsp/admin/updateTeacher.jsp">--%>
<%--                        <input type="submit" value="修改老师">--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--                <div style="float: left">--%>
<%--                    <form method="post" name="deleteTeacher"--%>
<%--                          action="${pageContext.request.contextPath}/jsp/admin/deleteTeacher.jsp">--%>
<%--                        <input type="submit" value="删除老师">--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--                ${requestScope.teacher}--%>

            </div>
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
