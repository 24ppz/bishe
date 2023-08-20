<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
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
            /*display: inline-block;*/
            border: 1px solid #ccc;
            border-radius: 4px;
            /*box-sizing: border-box;*/
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
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/teacher.do">教师管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/student.do">学生管理</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/competition.do">所有竞赛</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/baoming.do">报名审核</a></li>
<%--                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/tuisai.do">退赛信息</a></li>--%>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/gonggao.jsp">查看公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/jsp/admin/fabu.jsp">发布公告</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/liuyana.do">查看留言</a></li>
                </ul>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>修改学生信息</h1>
            <form method="post" name="updateStudent" action="${pageContext.request.contextPath}/updateStudent.do">

                    ${requestScope.idLength}
                    <br>
                    <label>学号：
                        <input name="id" type="text" readonly="readonly" value=<%=request.getParameter("id")%>>
                    </label>
                        <br>

                    <label>系部：
                        <input name="department" type="text" value=<%=request.getParameter("department")%>>
                    </label>

                    <%
                        Calendar date = new GregorianCalendar();
                        int year = date.get(Calendar.YEAR);
                    %>
                        <br>
                    <label>年级：
                        <select name="grade">
                            <option><%=year - 4%>
                            </option>
                            <option><%=year - 3%>
                            </option>
                            <option><%=year - 2%>
                            </option>
                            <option><%=year - 1%>
                            </option>
                            <option selected="selected"><%=year%>
                            </option>
                            <option><%=year + 1%>
                            </option>
                        </select>
                    </label>

                    <script type="text/javascript">
                        const department = document.getElementById("department");
                        department.onclick = function () {
                            const value = department.value;
                            switch (value) {
                                case "艺术与设计系":
                                    document.getElementById("class").innerHTML =
                                        "<option>艺术设计1班</option>" +
                                        "<option>视觉传播设计与制作1班</option>" +
                                        "<option>动漫设计1班</option>" +
                                        "<option>游戏设计1班</option>" +
                                        "<option>人物形象设计1班</option>" +
                                        "<option>美容美体艺术1班</option>";
                                    break;
                                case "英汉语言文学系":
                                    document.getElementById("class").innerHTML =
                                        "<option>英语1班</option>" +
                                        "<option>英语2班</option>" +
                                        "<option>英语3班</option>" +
                                        "<option>汉语言文学1班</option>" +
                                        "<option>汉语言文学2班</option>" +
                                        "<option>汉语言文学3班</option>";
                                    break;
                                case "工商管理系":
                                    document.getElementById("class").innerHTML =
                                        "<option>工商管理1班</option>" +
                                        "<option>工商管理2班</option>" +
                                        "<option>工商管理3班</option>" +
                                        "<option>工商管理4班</option>" +
                                        "<option>工商管理5班</option>" +
                                        "<option>工商管理6班</option>";
                                    break;
                                case "经济贸易系":
                                    document.getElementById("class").innerHTML =
                                        "<option>国际经济与贸易1班</option>" +
                                        "<option>国际经济与贸易2班</option>" +
                                        "<option>经济学1班</option>" +
                                        "<option>经济学2班</option>" +
                                        "<option>会计1班</option>" +
                                        "<option>会计2班</option>";
                                    break;
                                case "工程技术系":
                                    document.getElementById("class").innerHTML =
                                        "<option>工业设计1班</option>" +
                                        "<option>工业设计2班</option>" +
                                        "<option>工业设计3班</option>" +
                                        "<option>电气工程及其自动化1班</option>" +
                                        "<option>电气工程及其自动化2班</option>" +
                                        "<option>电气工程及其自动化3班</option>";
                                    break;
                                case "信息工程系":
                                    document.getElementById("class").innerHTML =
                                        "<option>计算机科学与技术1班</option>" +
                                        "<option>计算机科学与技术2班</option>" +
                                        "<option>软件技术1班</option>" +
                                        "<option>软件技术2班</option>" +
                                        "<option>电子信息工程1班</option>" +
                                        "<option>电子信息工程2班</option>";
                                    break;
                            }
                        }
                    </script>
                    ${requestScope.classNameNull}
                    <br>
                    <label>班级：
                        <input name="class" type="text" value=<%=request.getParameter("class")%>>
                    </label>

                    ${requestScope.nameCode}
                    <br>${requestScope.nameNull}

                    <label>姓名：
                        <input type="text" name="name" value=<%=request.getParameter("name")%>>
                    </label>

                ${requestScope.error}
                ${requestScope.success}
                <br><input type="submit" value="修改">
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



