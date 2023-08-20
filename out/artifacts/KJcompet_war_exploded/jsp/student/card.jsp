<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/static/jquery/jquery-2.1.4.min.js>
<%--    <script type=javascript>--%>
<%--        function printsetup() {--%>
<%--            wb.execwb(8,1);--%>
<%--        }--%>
<%--        function printpreview() {--%>
<%--            // 打印页面预览--%>
<%--            wb.execwb(7, 1);--%>
<%--        }--%>
<%--        function printit() {--%>
<%--            if (confirm('确定打印吗？')) {--%>
<%--                wb.ExecWB(6, 1);--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<div class="noprint" style="width:640px;height:20px;margin:100px auto 0 auto;font-size:12px;text-align:right;">

<%--    <OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>--%>

    <input value="打印" type="button" onclick=window.print()>

<%--    <input type=button name=button_setup value="打印页面设置" onclick="printsetup();">--%>

<%--    <input type=button name=button_show value="打印预览" onclick="printpreview();">--%>

<%--    <input type=button name=button_fh value="关闭" onclick="window.close();">--%>

</div>

<div>
    <h4 class="h4">参赛证：</h4>
    <table class="table">
        <tr>
            <td>
                学号：
            </td>
            <td>
                ${sessionScope.studentSession.id}
            </td>
        </tr>
        <tr>
            <td>
                姓名：
            </td>
            <td>
                ${sessionScope.studentSession.studentName}
            </td>
        </tr>
        <tr>
            <td>
                所属系：
            </td>
            <td>
                ${sessionScope.studentSession.department}
            </td>
        </tr>
        <tr>
            <td>
                年级：
            </td>
            <td>
                ${sessionScope.studentSession.grade}
            </td>
        </tr>
        <tr>
            <td>
                班级:
            </td>
            <td>
                ${sessionScope.studentSession.className}
            </td>
        </tr>
        <tr>
            <td>
                参加比赛:
            </td>
            <td>
                ${sessionScope.competitionName}
            </td>
        </tr>
    </table>
</div>
</body>
</html>
