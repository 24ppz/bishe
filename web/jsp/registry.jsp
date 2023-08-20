<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login / Register</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            background-image: url("${pageContext.request.contextPath}/images/background.jpeg");
            background-size: 100%, 100%;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .form-container {
            width: 400px;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333333;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        select,
        textarea {
            width: 100%;
            padding: 10px 12px;
            margin: 5px 0 20px 0;
            border: none;
            border-radius: 5px;
            background-color: #f2f2f2;
            color: #333333;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #1E9FFF;
            color: #ffffff;
            font-size: 16px;
            cursor: pointer;
        }

        .alt-paragraph {
            margin-top: 20px;
            font-size: 14px;
            text-align: center;
        }

        .alt-paragraph a {
            text-decoration: underline;
            color: #333333;
        }

        .alt-paragraph a:hover {
            color: #4CAF50;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h1>注册</h1>
        <%--        <form action="${pageContext.request.contextPath}/register.do">--%>
        <%--            <!-- Registry Form -->--%>
        <%--            <label for="login-user">用户名:</label>--%>
        <%--            <input type="email" id="login-user" name="login-user" required>--%>
        <%--            <label for="login-password">密码:</label>--%>
        <%--            <input type="password" id="login-password" name="login-password" minlength="6" required>--%>
        <%--            <input type="submit" value="注册">--%>
        <%--        </form>--%>
        <form method="post" name="addStudent" action="${pageContext.request.contextPath}/register.do">
            <p>
                ${requestScope.idLength}
                <br>学号：
                <label>
                    <input type="number" name="id">
                </label>
            </p>
            <p>
                系部：
                <label>
                    <select id="department" name="department">
                        <option value="艺术与设计系" selected="selected">艺术与设计系</option>
                        <option value="英汉语言文学系">英汉语言文学系</option>
                        <option value="工商管理系">工商管理系</option>
                        <option value="经济贸易系">经济贸易系</option>
                        <option value="工程技术系">工程技术系</option>
                        <option value="信息工程系">信息工程系</option>
                    </select>
                </label>
            </p>
            <p>
                <%
                    Calendar date = new GregorianCalendar();
                    int year = date.get(Calendar.YEAR);
                %>
                年级：
                <label>
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
            </p>
            <p>
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
                <br>班级：
                <label>
                    <select id="class" name="class">
                        <option selected="selected" value="">--请先选择系部--</option>
                    </select>
                </label>
            </p>
            <p>
                ${requestScope.nameCode}
                <br>${requestScope.nameNull}
                <br>姓名：
                <label>
                    <input type="text" name="name">
                </label>
            </p>
            ${requestScope.error}
            ${requestScope.success}
            <br><input type="submit" value="注册">
        </form>

    </div>
</div>
</body>
</html>
