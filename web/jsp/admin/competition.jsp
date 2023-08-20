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
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/teacher.do">教师管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/student.do">学生管理</a></li>
                    <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a>
                    </li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
<%--                                        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/tuisai.do">退赛信息</a></li>--%>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a>
                    </li>
                    <li class="layui-nav-item"><a
                            href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

<%--            ${requestScope.competition}--%>
            <div style="float: right">
                <form method="post" name="addCompetition"
                      action="${pageContext.request.contextPath}/jsp/admin/addCompetition.jsp">
                    <input type="submit" value="发布竞赛">
                </form>
            </div>
            <table>
                <tr>
                    <th>竞赛id</th>
                    <th>竞赛名称</th>
                    <th>截至报名时间</th>
                    <th>竞赛描述</th>
                    <th>指导教师</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${competition}" var="c">
                    <tr>
                        <td><c:out value="${c.getId()}"/></td>
                        <td><c:out value="${c.getCompetitionName()}"/></td>
                        <td><c:out value="${c.getDate()}"/></td>
                        <td><c:out value="${c.getDescribe()}"/></td>
                        <td><c:out value="${c.getTeacherName()}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/jsp/admin/updateCompetition.jsp?id=${c.getId()}&competition=${c.getCompetitionName()}&date=${c.getDate()}&teacherid=${c.getTeacherId()}&teacher=${c.getTeacherName()}"><button>修改</button></a>
                            <a href="${pageContext.request.contextPath}/deleteCompetition.do?id=${c.getId()}"><button>删除</button>
                            </a>

                        </td>
                    </tr>
                </c:forEach>
            </table>
            ${requestScope.info}

<%--            <div style="float: left">--%>
<%--                <form method="post" name="updateCompetition"--%>
<%--                      action="${pageContext.request.contextPath}/jsp/admin/updateCompetition.jsp">--%>
<%--                    <input type="submit" value="修改比赛">--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div style="float: left">--%>
<%--                <form method="post" name="deleteCompetition"--%>
<%--                      action="${pageContext.request.contextPath}/">--%>
<%--                    <input type="submit" value="删除比赛">--%>
<%--                </form>--%>
<%--            </div>--%>

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



