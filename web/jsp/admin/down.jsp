<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理系统大布局</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/load.js">


    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/background.jpg");
            background-size: 100%, 100%;
        }
    </style>
</head>
<body>
<div style="padding: 15px;">
    <%--            <input type="button" value="导出EXCEL" onClick="getXlsFromJsp('excel_table')" class="botton">--%>
    <%
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition", "attachment; filename=" + new String("download.xls"));
    %>
    ${requestScope.student}
    <div style="float: left">
        <form method="post" name="addStudent"
              action="${pageContext.request.contextPath}/jsp/admin/addStudent.jsp">
            <input type="submit" value="添加学生">
        </form>
    </div>
    <div style="float: left">
        <form method="post" name="updateStudent"
              action="${pageContext.request.contextPath}/jsp/admin/updateStudent.jsp">
            <input type="submit" value="修改学生">
        </form>
    </div>
    <div style="float:left;">
        <form method="post" name="deleteStudent"
              action="${pageContext.request.contextPath}/jsp/admin/deleteStudent.jsp">
            <input type="submit" value="删除学生">
        </form>
    </div>
</div>
</body>
<!-- 引入 layui.js -->
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<%--导出xecel--%>
<script>
    //导出通用excel
    function getXlsFromJsp(id) {
        var form_excel = document.createElement("form");
        document.body.appendChild(form_excel);
        form_excel.action = "/excel_create.jsp?tableid=" + id;
        form_excel.method = "post";
        form_excel.setAttribute("accept-charset", "utf-8");
        var table_inn = document.createElement("input");
        table_inn.name = "tablevalue2";
        table_inn.type = "hidden";
        table_inn.value = document.getElementById(id).innerHTML;
        form_excel.appendChild(table_inn);
        form_excel.submit();
    }
</script>
</html>




