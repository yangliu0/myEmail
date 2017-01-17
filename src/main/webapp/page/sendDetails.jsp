<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2016/12/28
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>发信箱</title>

    <!-- load stylesheets -->
    <!--<link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:300,400">  &lt;!&ndash; Google web font "Open Sans" &ndash;&gt;-->
    <link rel="stylesheet" href="../css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="../css/templatemo-style.css">                                   <!-- Templatemo style -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="tm-header">
    <div class="container-fluid">
        <div class="tm-header-inner">
            <a href="#" class="navbar-brand tm-site-name">邮件系统</a>

            <!-- navbar -->
            <nav class="navbar tm-main-nav">

                <button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                    &#9776;
                </button>

                <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                    <ul class="nav navbar-nav">
                        <li class="nav-item">
                            <a href="../view/mail.html" class="nav-link">写邮件</a>
                        </li>
                        <li class="nav-item active">
                            <a href="../view/mailtable.html" class="nav-link">发信箱</a>
                        </li>
                        <li class="nav-item">
                            <a href="../view/receivemail.html" class="nav-link">收信箱</a>
                        </li>
                        <li class="nav-item">
                            <a href="view/center.html" class="nav-link">个人中心</a>
                        </li>
                        <li id="titlename" class="nav-item">
                            欢迎你！<br/>

                        </li>
                        <li id="logoutTitle" class="nav-item">

                        </li>
                    </ul>
                </div>

            </nav>

        </div>
    </div>
</div>

<section class="tm-section">
    <div class="container-fluid">

        <div class="row tm-margin-t-big">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
                <div class="tm-2-col-left">

                    <h3 id = "subject"class="tm-gold-text tm-title"></h3>
                    <div id="content"></div>

                </div>
            </div>


            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">

                <div class="tm-2-col-right">

                    <div class="tm-2-rows-md-swap">
                        <div class="tm-overflow-auto row tm-2-rows-md-down-2">
                        </div>

                        <div class="row tm-2-rows-md-down-1 tm-margin-t-mid">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <h3 class="tm-gold-text tm-title tm-margin-b-30">发信人</h3>
                                <div class="media tm-related-post">
                                    <div class="media-left media-middle">
                                        <p id="sender"></p>
                                    </div>
                                </div>

                                <h3 class="tm-gold-text tm-title tm-margin-b-30">收信人</h3>
                                <div class="media tm-related-post">
                                    <div class="media-left media-middle">
                                        <p id="recipient"></p>
                                    </div>
                                </div>

                                <h3 class="tm-gold-text tm-title tm-margin-b-30">时间</h3>
                                <div class="media tm-related-post">
                                    <div class="media-left media-middle">
                                        <p id="sendtime"></p>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div> <!-- row -->

    </div>
</section>

<!-- load JS files -->
<script src="../jslib/jquery-1.9.1.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
<script src="../jslib/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
<script src="../jslib/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
<script src="../js/register_login.js"></script>
<script>
    //填写邮件基本信息
    $(function ()
    {
        var email = ${email};
        console.log(email);

        console.log(email.recipient)
        $("#sender").html(email.sender);
        $("#recipient").html(email.recipient);
        $("#sendtime").html(email.sendtime);
        $("#subject").html(email.subject);
        $("#content").html(email.content);
    })
</script>
</body>
</html>
