<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/student/information.jsp">个人信息</a>
                    </li>
                    <li class="layui-nav-item layui-this"><a
                            href="${pageContext.request.contextPath}/selectCompetition.do">竞赛</a></li>
                    <li class="layui-nav-item"><a
                            href="${pageContext.request.contextPath}/liuyanll.do">留言咨询</a></li>
                    <li class="layui-nav-item"><a
                            href="${pageContext.request.contextPath}/jsp/student/card.jsp">打印参赛证</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a>
                    </li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="margin-top: 30px;margin-left: 200px; margin-right: 200px;">
            <%--            <form method="post" action="${pageContext.request.contextPath}/selectCompetition.do">--%>
            <%--                <input type="submit" value="查看比赛">--%>
            <%--            </form>--%>

<%--            ${requestScope.competition}--%>

            <table>
                <tr>
                    <th>竞赛ID</th>
                    <th>竞赛名称</th>
                    <th>截止日期</th>
                    <th>竞赛描述</th>
                    <th>指导老师姓名</th>
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
                            <c:if test="${empty ucompetitionName}">
                                <a href="${pageContext.request.contextPath}/join.do?competitionId=${c.getId()}"><button>报名</button></a>
                            </c:if>
                            <c:if test="${ucompetitionName eq c.getCompetitionName()}">
                                <a href="${pageContext.request.contextPath}/exit.do?competitionId=${c.getId()}"><button>退赛</button></a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
<%--            <form method="post" action="${pageContext.request.contextPath}/join.do">--%>
<%--                <label>输入比赛编号：<input type="text" name="competitionId"></label>--%>
<%--                <input type="submit" value="报名">--%>
<%--            </form>--%>

                <p style="color: red;margin-top: 3px;position: center">${requestScope.success}</p>

                <p style="color: red;margin-top: 3px;position: center">${requestScope.error}</p>

                <p style="color: red;margin-top: 3px;position: center">${requestScope.afterda}</p>

<%--            <form method="post" action="${pageContext.request.contextPath}/exit.do">--%>
<%--                <label>输入比赛编号：<input type="text" name="competitionId"></label>--%>
<%--                <input type="submit" value="退出比赛">--%>
<%--            </form>--%>
                <p style="color: red;margin-top: 3px;position: center">${requestScope.exit}</p>
        </div>
    </div>
</div>
</body>
<script>
    Date.prototype.format = function (fmt) {
        var o = {
            "y+": this.getFullYear, //年
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds() //秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    setInterval("document.getElementById('dateTime').innerHTML = (new Date()).format('yyyy-MM-dd hh:mm:ss');", 1000);
</script>
<!-- 引入 layui.js -->
<script src=${pageContext.request.contextPath}/static/layui/layui.js></script>
</html>