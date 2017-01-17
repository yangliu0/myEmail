
$(function ()
{
    /**
     * 发送邮件
     * 邮件内容以html的形式
     */
    $("#sendMail").bind("click", function ()
    {
        var destination = $("#destination").val();
        var subject = $("#subject").val();
        var content = UE.getEditor('editor').getContent();

        // 服务名
        var srv = "/myEmail/sendEmail/html";

        // 参数
        var paras = {
            destination:destination
            ,subject:subject
            ,content:content
        };

        console.log(destination + " " + subject + " " + content);

        $.ajax({
            type: "post",
            url: srv,
            dataType: "json",
            data: paras,
            cache: true,
            success:function(data)
            {
                console.log(data.ret);
                if(data.ret == "success")
                {
                    alert("发送成功");
                }
            },
            error:function()
            {
                alert("发送失败")
            }
        })
    })
});
