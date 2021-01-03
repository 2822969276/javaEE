<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/2
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css"/>
    <script src="lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>

    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="layui-tab layui-tab-card" lay-allowclose="true">
    <ul class="layui-tab-title">
        <li class="layui-this">班级管理员基本信息</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" action="SearchClassAdministratorServlet">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="email" placeholder="email" autocomplete="off"
                                   class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn" onclick="xadmin.open('添加用户','班级管理员信息添加.html',800,600)">
                        <i class="layui-icon"></i>添加
                    </button>
                    <a href="" >  <button class="layui-btn" >
                        <i class="icon iconfont">&#xe6aa;</i> 刷新
                    </button></a>
                </div>

                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>email</th>
                            <th>用户名</th>
                            <th>密码</th>

                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${sessionScope.classAdministrators}" var="item" varStatus="i">
                            <tr>
                                <td>${item.getEmail()}</td>
                                <td>${item.getUsername()}</td>
                                <td>${item.getPassword()}</td>

                                <td class="td-manage">
                                    <a title="修改" onclick="xadmin.open('编辑','班级管理员信息修改.html')" href="javascript:;">
                                        <i class="layui-icon">&#xe63c;</i></a>
                                    <div class="layui-form-item">
                                        <label for="L_repass" class="layui-form-label">
                                        </label>
                                        <button   class="layui-btn" lay-filter="add" lay-submit="">
                                            <a title="删除" onclick="member_del(this,'要删除的id')" href="DeleteClassAdministratorServlet?email=${item.getEmail()}">
                                                <i class="layui-icon">&#xe640;</i></a>
                                        </button>
                                    </div>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


    </div>
</div>
<script>layui.use(['form', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //监听提交
        form.on('submit(add)',
            function() {
                //关闭当前frame
                xadmin.close();

                // 可以对父窗口进行刷新
                xadmin.father_reload();
            });
        return false;


    });</script>
<script type="text/javascript">
    layui.use('element', function () {
        var element = layui.element;
    })
</script>
</body>
</html>
