/*
 *  管理注册以及登录
 */

$(function ()
{
    //点击注册按钮
    $("#register").bind("click", function ()
    {
        var username = $("#username").val();
        var password = $("#password").val();
        var password1 = $("#password2").val();

        //清空提示
        $("#tip").html("&nbsp;");

        if(password != password1)
        {
            $("#tip").html("两次输入的密码不同");
        }
        else
        {
            var svr = "user/reg";

            var paras ={
                username:username
                ,password:password
            };

            //当信息插入成功，返回1的时候注册成功
            $.ajax({
                type: "post",
                url: svr,
                dataType: "json",
                data: paras,
                cache: true,
                success:function(data)
                {
                    var retNum = data.ret;
                    if(retNum == 1)
                    {
                        alert("注册成功");
                        $("#username").val("");
                        $("#password").val("");
                        $("#password2").val("");
                        window.location.href = "login.html";
                    }
                },
                error:function()
                {
                    $("#tip").html("用户名已存在");
                }
            })
        }
    });

    // 点击登录按钮
    $("#login").bind("click", function ()
    {
        var username_l = $("#username_l").val();
        var password_l = $("#password_l").val();

        var srv = "/myEmail/user/login";

        var paras = {
            username_l:username_l
            ,password_l:password_l
        };

        $.ajax({
            type: "post",
            url: "/myEmail/user/login",
            dataType: "json",
            data: paras,
            cache: true,
            success:function(data)
            {
                if(data.ret == 0)
                {
                    window.location = "view/receivemail.html";
                }
                else if(data.ret == 1)
                {
                    alert("用户不存在");
                }
                else if(data == 2)
                {
                    alert("密码错误");
                }
            },
            error:function()
            {
                alert("err");
            }
        });
    });

    // 注销操作
    $("#logoutTitle").on("click", "a", function ()
    {
        $.ajax({
            type: "post",
            url: "/myEmail/user/logout",
            dataType: "text",
            data: "",
            cache: true,
            success:function(data)
            {
                if(data == "success")
                {
                    $("#titlename").html("欢迎你!" + "<br/>");
                    $("#logoutTitle").html("");
                    window.location = "/myEmail/login.html";
                }
                else
                {
                    alert("注销失败");
                }
            },
            error:function()
            {
                alert("err");
            }
        })
    });

    // 在session中检查用户是否登录
    $.ajax({
        type: "post",
        url: "/myEmail/user/checkout",
        dataType: "json",
        data: {},
        cache: true,
        success:function(data)
        {
            if(data.nickname == null)
            {
                $("#titlename").html("欢迎你!" + "<br/>" + data.username);
                $("#logoutTitle").html("<br/><a id=\"logout\" style=\"cursor:pointer\">退出</a>");
            }
            else
            {
                $("#titlename").html("欢迎你!" + "<br/>" + data.nickname);
                $("#logoutTitle").html("<br/><a id=\"logout\" style=\"cursor:pointer\">退出</a>");
            }

        },
        error:function()
        {
        }
    })
});
