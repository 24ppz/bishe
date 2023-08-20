<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>大学生科技竞赛线上报名系统jsp</title>
    <script src="./static/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="./static/layui/layui.js" type="text/javascript"></script>
    <script src="./static/layui/lay/modules/layer.js" type="text/javascript"></script>
    <link rel="stylesheet" href="./static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="./static/layui/css/modules/layer/default/layer.css"/>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
</head>
<body>
<!--科技竞赛导航-->
<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="#">首页</a>
    </li>
    <li class="layui-nav-item">
        <a href="./jsp/gonggao.jsp">公告</a>
    </li>
    <li class="layui-nav-item">
        <a href="./jsp/login.jsp">登录</a>
    </li>
    <li class="layui-nav-item">
        <a href="./jsp/registry.jsp">注册</a>
    </li>
    <li class="layui-nav-item">
        <a href="./jsp/about.jsp">关于我们</a>
    </li>
</ul>

<!--轮播图-->
<div class="layui-carousel" id="test1">
    <div carousel-item>
        <div><img src="./static/images/lunbo_03.png"></div>
        <div><img src="./static/images/lunbo_03.png"></div>
        <div><img src="./static/images/lunbo_03.png"></div>
        <div><img src="./static/images/lunbo_03.png"></div>
        <div><img src="./static/images/lunbo_03.png"></div>
        <div><img src="./static/images/lunbo_03.png"></div>
    </div>
</div>

<%--竞赛信息--%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>进行中</legend>
</fieldset>
<div class="layui-bg-gray" style="padding: 30px;">
    <div class="layui-row layui-col-space12">
        <div class="layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <sql:setDataSource var="connection" driver="com.mysql.cj.jdbc.Driver"
                                       url="jdbc:mysql://localhost/kjcomplet?useSSL=false&characterEncoding=utf8"
                                       user="root" password="root"/>

                    <sql:query dataSource="${connection}" var="result">
                        SELECT * from competition;
                    </sql:query>

                    <c:forEach var="row" items="${result.rows}">

                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" id="q" src="<c:out value="${row.img_url}" />">
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading"><c:out value="${row.competition_name}"/></h4>
                                <p>
                                        <c:out value="${row.competition_describe}"/>
                            </div>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>预期</legend>
</fieldset>
<div class="layui-bg-gray" style="padding: 30px;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">

                    <c:forEach var="row" items="${result.rows}">

                        <div class="media">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="<c:out value="${row.img_url}" />" alt="...">
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading"><c:out value="${row.competition_name}"/></h4>
                                <p>
                                        <c:out value="${row.competition_describe}"/>
                            </div>
                        </div>

                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
<footer style="background-color:#44748d;line-height: 90px;">

    <center>版权所有 &copy; 2023 大学生科技竞赛线上报名系统</center>

</footer>
<script src="./static/layui/layui.js"></script>
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

</script>

</html>
