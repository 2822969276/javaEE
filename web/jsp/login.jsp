<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/28
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>YUN</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css" />-->
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/less/modals.less" />
</head>
<style>
    .row {
        background-color: #95c4f94d;
        margin: auto 10%;
        border-width: 0 0 0 0;
        box-shadow: #080a0ecc 0px 0px 20px 3px;
        border-radius: 35px 35px 35px 35px;
    }
    /*a链接 在被选中和点击时  的字体颜色，粗度，大小*/

    a {
        color: #FFFFFFB3;
        font-weight: bolder;
        text-align: center;
        font-size: 18px;
    }

    a:hover {
        color: #FFFFFF;
        text-decoration-line: none;
        font-size: 16px;
    }

    a:hover,
    a:focus {
        color: #50ab9bcc;
    }
    /* body相关属性 */

    body {
        background-image: url(../img/mainPageImg.jpg);
        list-style: none;
        /*去掉ui和li的 点*/
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        background-attachment: fixed;
        background-position: center bottom;
        color: #fff;
        background-color: #333;
        font-family: 'microsoft yahei', Arial, sans-serif;
    }

    #title {
        width: auto;
        text-align: center;
        font-size: 140px;
        margin-top: 200px;
        transition: font-size 2s;
    }

    #title:hover {
        font-size: 148px;
    }

    .aTopAndBottom {
        height: auto;
        text-align: center;
        padding: 10px 0px;
        min-width: 20px;
    }

    .netease_Player {
        position: absolute;
        display: none;
    }

    .dropdown-menu>li>a:hover,
    .dropdown-menu>li>a:focus {
        color: #fff !important;
        background-color: #fff0 !important;
        font-size: 19px;
    }

    .dropup .dropdown-menu {
        background-color: #fff0 !important;
        text-decoration: none;
        margin-bottom: 10px;
        border: 0px;
        border-radius: 16px 16px 0px 0px;
        box-shadow: none;
        margin-bottom: 14px;
    }

    .dropdown-menu>li>a {
        color: #fff;
        padding: 12px;
        font-weight: bolder;
    }

    .navbar {
        min-height: 46px;
    }
    /*登录框  最大宽度 与上边距 重构*/

    .modal-dialog {
        width: 350px;
        margin: 60px auto;
    }
    /*登录框 背景颜色与透明度，边框线粗度，边框弧度，边框阴影 重写*/

    .modal-content {
        background-color: #afd2ff66;
        border: 0px solid rgba(0, 0, 0, .2);
        border-radius: 31px;
        box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
        -webkit-box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
        box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
    }
    /* 登录框位置重写 */

    .modal-body {
        position: relative;
        padding: 10px 34px;
    }
    /*输入框 背景颜色与透明度重构*/

    .form-control {
        background-color: #fffc;
    }
</style>

<body>
<!-- 顶部半透明容器 -->
<div class="navbar navbar-fixed-top row">
    <div class="col-xs-1 aTopAndBottom ">
        <a href=""><span class="glyphicon glyphicon-home "></span></a>
    </div>
    <!--登录按钮-->
    <div class="col-xs-1 col-xs-offset-9 aTopAndBottom">
        <a href="" data-toggle="modal" data-target="#login">
            <span class="glyphicon glyphicon-log-in"></span>
            <span id="loginText">登录</span>
        </a>
    </div>
    <!--注册按钮-->
    <div class="col-xs-1 aTopAndBottom">
        <a href="" data-toggle="modal" data-target="#register">
            <span class="glyphicon glyphicon-user"></span>
            <span id="registText">注册</span>
        </a>
    </div>
</div>
<!-- 中部容器 -->
<div class="container">
    <div class="main">
        <h1 id="title">hello world!</h1>
        <h1 id=""></h1>
    </div>
</div>

<!-- 外部网易云音乐 插件-->
<iframe class="netease_Player" frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=300 src="//music.163.com/outchain/player?type=0&id=606650925&auto=0&height=430">
</iframe>
<!-- 底部半透明容器：四选项 -->
<div class="navbar navbar-fixed-bottom row">
    <!-- 学习分类 -->
    <div class="col-xs-3 aTopAndBottom bottomSelect">
        <a href="">
            <span class="glyphicon glyphicon-education"></span>
        </a>
    </div>
    <!-- 音乐分类 -->
    <div class="col-xs-3 aTopAndBottom bottomSelect">
        <li class="dropup">

            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                <span class="glyphicon glyphicon-music"></span>
            </a>
            <ul class="dropdown-menu dropdownSelect">
                <li>
                    <a href="javascript:void(0);" onclick="openMyMusic()"><b>本地播放</b></a>
                </li>
                <li>
                    <a href="http://music.163.com/playlist?id=606650925&userid=424310419" target="_blank"><b>我喜欢的</b></a>
                </li>
                <li>
                    <a href="javascript:void(0);" target="_blank"><b>精选歌曲</b></a>
                </li>
            </ul>
        </li>

    </div>
    <!-- 视频分类  -->
    <div class="col-xs-3 aTopAndBottom">

        <a href="">
            <span class="glyphicon glyphicon-film"></span>
        </a>

    </div>
    <!-- 视频分类 end -->
    <!-- 更多分类  -->
    <div class="col-xs-3 aTopAndBottom bottomSelect">
        <div class="dropup">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                更多
            </a>
            <ul class="dropdown-menu dropdownSelect dropdown-menu-right">
                <li>
                    <a href="javascript:void(0);">联系我</a>
                </li>
                <li>
                    <a href="javascript:void(0);">收藏</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 更多分类 end -->
</div>

<!-- 注册 -->
<div id="register" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">注册</h1>
            </div>
            <div class="modal-body">
                <form class="form-group" action="">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" type="text" placeholder="6-15位字母或数字">
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" type="password" placeholder="至少6位字母或数字">
                    </div>
                    <div class="form-group">
                        <label for="">再次输入密码</label>
                        <input class="form-control" type="password" placeholder="至少6位字母或数字">
                    </div>
                    <div class="form-group">
                        <label for="">邮箱</label>
                        <input class="form-control" type="email" placeholder="例如:***@***.com">
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit" style="background-color: #3a8cd2b3;border: 0px solid transparent;">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal" style="background-color: #fb5e5999;border: 0px solid transparent;">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">
                        <font style="font-size: 13px;">已有账号？点我登录</font>
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 注册 end-->
<!-- 登录 -->
<div id="login" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">
                <form class="form-group" action="">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" type="password" placeholder="">
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit" style="background-color: #3a8cd2b3; border: 0px solid transparent;">登录</button>
                        <button class="btn btn-danger" data-dismiss="modal" style="background-color: #fb5e5999;border: 0px solid transparent;">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">
                        <font style="font-size: 13px;">还没有账号？点我注册</font>
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 登录 end -->
</body>
<script type="text/javascript" src="../lib/jquery/jquery-1.11.0.min.js"></script>
<!--<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.js"></script>-->
<!--升级使用外部资源，节约个人网站带宽-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
    /*各组件根据打开窗口大小  初始化响应一次*/
    baseOnWindowSizeToChange();

    /*窗口宽度高度发生变化时，触发各组件响应函数*/
    $(window).resize(
        function() {
            baseOnWindowSizeToChange();
        }
    );

    /*窗口宽度高度发生变化时，各组件应当的响应*/
    function baseOnWindowSizeToChange() {
        //获取浏览器高度
        var h = $(window).height();
        //获取浏览器宽度
        var w = $(window).width();
        /*console.log("当前浏览器高度为：" + h + "px");
          console.log("当前浏览器宽度为：" + w + "px");*/

        //获取底部单个选项宽度大小并赋给上拉表单宽度
        var dropdownWidth = $(".bottomSelect").width();
        $(".dropdownSelect").css("width", dropdownWidth);

        /*主标题在窗口大于500时显示，小于500时隐藏*/
        if(h < 500) {
            $("#title").fadeOut(700); //id为title的元素0.7秒内消失
        } else {
            $("#title").fadeIn(1200); //id为title的元素1秒内显示
        }

        /*输入框组在浏览器高度小于600时，高度变紧凑，大于600还原*/
        if(h < 600) {
            $(".form-group").css("margin-bottom","0");
        } else {
            $(".form-group").css("margin-bottom","15");
        }

        /* 当浏览器宽度小于1100时：
         * 标题大小 根据浏览器宽度大小变换而变换
         * 登录 注册只显示图标
         *
         * 大于1100时还原
         * */
        if(w < 1100) {
            $("#title").css("font-size", w / 10);
            $("#loginText").text(" ");
            $("#registText").text(" ");
        } else {
            $("#title").css("font-size", "140px");
            $("#loginText").text("登录");
            $("#registText").text("注册");
        }
        if(w < 400) {
            $(".modal-dialog").css("width","90%");
        }else{
            $(".modal-dialog").css("width","350px");
        }
    }

    /* 打开网易云播放器 */
    var isopen = 0;
    function openMyMusic() {
        console.log(isopen);
        if(isopen == 0) {
            $(".netease_Player").css("display", "block");
            isopen = 1;
        } else {
            $(".netease_Player").css("display", "none");
            isopen = 0;
        }
    }
</script>
</html>
