<%@ page import="bean.Administrator" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.AdministratorDao" %>
<%@ page import="bean.Student" %>
<%@ page import="Dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/28
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
  <meta charset="UTF-8">
  <title>后台登录-X-admin2.2</title>
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

<body class="index">

<!-- 顶部开始 -->
<div class="container">
  <div class="logo">
    <a href="./index.html">高校奖罚系统</a>
  </div>
  <div class="left_open">
    <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
  </div>

  <ul class="layui-nav right" lay-filter="">
    <li class="layui-nav-item">
      <a href="javascript:;">${sessionScope.user.getUsername()}</a>
      <dl class="layui-nav-child">
        <!-- 二级菜单 -->
        <dd>
          <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a>
        </dd>
        <dd>
          <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a>
        </dd>
        <dd>
          <a href="./login.html">退出</a>
        </dd>
      </dl>
    </li>

  </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
  <div id="side-nav">
    <ul id="nav">
      <li>
        <a href="javascript:;">
          <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
          <cite>管理员管理</cite>
          <i class="iconfont nav_right">&#xe697;</i></a>
        <ul class="sub-menu">

          <li>
            <a onclick="xadmin.add_tab('管理员列表(静态表格)','管理员基本信息管理.jsp')">
              <i class="iconfont">&#xe6a7;</i>
              <cite>管理员列表</cite></a>
          </li>

        </ul>
      </li>
      <li>
        <a href="javascript:;">
          <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
          <cite>老师管理</cite>
          <i class="iconfont nav_right">&#xe697;</i></a>
        <ul class="sub-menu">

          <li>
            <a onclick="xadmin.add_tab('老师列表(静态表格)','老师基本信息管理.jsp')">
              <i class="iconfont">&#xe6a7;</i>
              <cite>老师列表</cite></a>
          </li>

        </ul>
      </li>
      <li>
        <a href="javascript:;">
          <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
          <cite>班级管理员管理</cite>
          <i class="iconfont nav_right">&#xe697;</i></a>
        <ul class="sub-menu">

          <li>
            <a onclick="xadmin.add_tab('班级管理员列表(静态表格)','班级管理员基本信息管理.jsp')">
              <i class="iconfont">&#xe6a7;</i>
              <cite>班级管理员列表</cite></a>
          </li>

        </ul>
      </li>
      <li>
        <a href="javascript:;">
          <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
          <cite>学生管理</cite>
          <i class="iconfont nav_right">&#xe697;</i></a>
        <ul class="sub-menu">

          <li>
            <a onclick="xadmin.add_tab('学生列表(静态表格)','学生基本信息管理.jsp')">
              <i class="iconfont">&#xe6a7;</i>
              <cite>学生列表</cite></a>
          </li>

        </ul>
      </li>

    </ul>
  </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
  <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
    <ul class="layui-tab-title">
      <li class="home">
        <i class="layui-icon">&#xe68e;</i>我的桌面</li>
    </ul>
    <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
      <dl>
        <dd data-type="this">关闭当前</dd>
        <dd data-type="other">关闭其它</dd>
        <dd data-type="all">关闭全部</dd>
      </dl>
    </div>
    <div class="layui-tab-content">
      <div class="layui-tab-item layui-show">
        <iframe src='./error.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
      </div>
    </div>
    <div id="tab_show"></div>
  </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->

</body>

</html>
