$(function ()
{
    /**
     * 个人中心
     * 如果有个人资料信息，填写到对应的输入栏
     */
    $.ajax({
        type: "post",
        url: "/myEmail/user/getInfo",
        dataType: "json",
        data: {},
        cache: true,
        success:function(data)
        {
            if(data.nickname == null)
            {
                if(data.age == null)
                {
                    return;
                }
                else
                {
                    $("#age").val(data.age);
                    return;
                }
            }

            if(data.age == null)
            {
                $("#nickname").val(data.nickname);
                return;
            }
            else
            {
                $("#nickname").val(data.nickname);
                $("#age").val(data.age);
                return;
            }

        },
        error:function()
        {
            alert("出错")
        }
    });


    /**
     * 个人中心
     * 更新个人资料信息
     */
    $("#update").bind("click",function ()
    {
        var srv = "/myEmail/user/update";

        var nickname = $("#nickname").val();
        var age = $("#age").val();

        var paras = {
            nickname:nickname
            ,age:age
        };

        $.ajax({
            type: "post",
            url: srv,
            dataType: "json",
            data: paras,
            cache: true,
            success:function(data)
            {
                if(data == 1)
                {
                    alert("修改成功");
                }
            },
            error:function()
            {
                alert("出错")
            }
        })
    });

});
