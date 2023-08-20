<%@ page import="com.zkk.pojo.Agree" %>
<%@ page import="java.util.ArrayList" %>
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
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a></li>
                    <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
<%--                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/admin/baoming.jsp">导出报名表</a>--%>
                    </li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->

        <div style="padding: 15px;">
<%--            <%--%>
<%--                response.setContentType("application/x-msdownload");--%>
<%--                response.setHeader("Content-disposition","attachment; filename="+new String("download.xls"));--%>
<%--            %>--%>
            <table>
                <tr>
                    <th>学生ID</th>
                    <th>学生年级</th>
                    <th>学生姓名</th>
                    <th>竞赛ID</th>
                    <th>竞赛名称</th>
                    <th>截止日期</th>
                    <th>参赛</th>
                    <th>退赛</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${T}" var="t">
                    <tr>
                        <td><c:out value="${t.getUid()}"/></td>
                        <td><c:out value="${t.getGrade()}"/></td>
                        <td><c:out value="${t.getUname()}"/></td>
                        <td><c:out value="${t.getCid()}"/></td>
                        <td><c:out value="${t.getCname()}"/></td>
                        <td><c:out value="${t.getJzdate()}"/></td>
                        <c:if test="${!empty t.getCom() }">
                            <td><c:out value="待审核"/></td>
                        </c:if>
                        <c:if test="${empty t.getCom()}">
                            <td></td>
                        </c:if>
                        <c:if test="${!empty t.getExi() }">
                            <td><c:out value="待审核"/></td>
                        </c:if>
                        <c:if test="${empty t.getExi()}">
                            <td></td>
                        </c:if>
                        <td>
                            <c:if test="${!empty t.getCom() }">
                                <button><a href="${pageContext.request.contextPath}/agreeCom.do?uid=${t.getUid()}">同意参赛</a></button>
                            </c:if>

                            <c:if test="${!empty t.getExi() }">
                                <button><a href="${pageContext.request.contextPath}/agreeExit.do?uid=${t.getUid()}">同意退赛</a></button>
                            </c:if>

                        </td>
                    </tr>
                </c:forEach>
            </table>

<%--            <form method="post" action="${pageContext.request.contextPath}/agreeCom.do">--%>
<%--                <label>输入学生编号：<input type="text" name="uid"></label>--%>
<%--                <input type="submit" value="同意参赛申请学生id">--%>
<%--            </form>--%>

<%--            <form method="post" action="${pageContext.request.contextPath}/agreeExit.do">--%>
<%--                <label>输入学生编号：<input type="text" name="uid"></label>--%>
<%--                <input type="submit" value="同意退赛申请学生id">--%>
<%--            </form>--%>

        </div>
    </div>

</div>
</body>
<!-- 引入 layui.js -->
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<%--导出xecel--%>
<%--<script>--%>
<%--    //导出通用excel--%>
<%--    function getXlsFromJsp(id) {--%>
<%--        var form_excel = document.createElement("form");--%>
<%--        document.body.appendChild(form_excel);--%>
<%--        form_excel.action = "/excel_create.jsp?tableid=" + id;--%>
<%--        form_excel.method = "post";--%>
<%--        form_excel.setAttribute("accept-charset", "utf-8");--%>
<%--        var table_inn = document.createElement("input");--%>
<%--        table_inn.name = "tablevalue2";--%>
<%--        table_inn.type = "hidden";--%>
<%--        table_inn.value = document.getElementById(id).innerHTML;--%>
<%--        form_excel.appendChild(table_inn);--%>
<%--        form_excel.submit();--%>
<%--    }--%>
<%--</script>--%>
</html>