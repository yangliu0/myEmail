
$(function ()
{
    //当前页面index
    var current = 0;
    //页面最大条目数
    var pageSize = 6;
    //收信箱中总共邮件数
    var total = 0;
    //当前页面号
    var currentPage;
    //总页面号
    var totalPage;
    

    //进行刷新后，默认将收信箱界面返回到第一页
    $.ajax({
        type: "get",
        url: "/myEmail/sendEmail/getAll",
        dataType: "json",
        data: {index:0,pageSize:6},
        cache: true,
        success:function(data)
        {
            //获取收信箱邮件总数，进行分页
            $.ajax({
                type: "get",
                url: "/myEmail/sendEmail/getCount",
                dataType: "json",
                data: {},
                cache: true,
                success:function(data)
                {
                    total = data;
                    console.log("total : " + total);
                    totalPage = Math.ceil(total / pageSize);
                    currentPage = current + 1;
                    $("#currentPage").html(currentPage);
                    $("#totalPage").html(totalPage);
                },
                error:function()
                {

                }
            });

            var tablestr = null;
            console.log(data.ret);
            var results = data.ret;
            // 生成当前页table
            for(var i = 0; i < results.length; i++)
            {
                var d = new Date(results[i].sendtime);
                tablestr += "<tr><td>" + results[i].recipient + "</td><td>" + results[i].subject + "</td><td>" + d.toLocaleDateString() +
                    "</td><td>" + results[i].content + "</td><td><a type=\"button\" class=\"btn btn-success\" target=\"_blank\" href=" +
                    results[i].url + ">查看</a></td></tr>"
            }
            $("#receivetable").html(tablestr);
        },
        error:function()
        {

        }
    });

    //前一页
    $("#previous").bind("click", function ()
    {
        if(currentPage == 1)
        {
            alert("当前为第一页");
            return;
        }

        current--;
        currentPage--;

        var paras = {
            index:current
            ,pageSize:pageSize
        };

        $.ajax({
            type: "get",
            url: "/myEmail/sendEmail/getAll",
            dataType: "json",
            data: paras,
            cache: true,
            success:function(data)
            {
                var tablestr = null;
                console.log(data.ret);
                var results = data.ret;
                // 生成当前页table
                for(var i = 0; i < results.length; i++)
                {
                    tablestr += "<tr><td>" + results[i].recipient + "</td><td>" + results[i].subject + "</td><td>" + results[i].sendtime +
                        "</td><td>" + results[i].content + "</td><td><a type=\"button\" class=\"btn btn-success\" target=\"_blank\" href=" +
                        results[i].url + ">查看</a></td></tr>"
                }
                $("#receivetable").html(tablestr);

                $("#currentPage").html(currentPage);
            },
            error:function()
            {
            }
        });
    });

    //前一页
    $("#next").bind("click", function ()
    {
        if(currentPage == totalPage)
        {
            alert("当前为最后一页");
            return;
        }

        current++;
        currentPage++;

        var paras = {
            index:current
            ,pageSize:pageSize
        };

        $.ajax({
            type: "get",
            url: "/myEmail/sendEmail/getAll",
            dataType: "json",
            data: paras,
            cache: true,
            success:function(data)
            {
                var tablestr = null;
                console.log(data.ret);
                var results = data.ret;
                // 生成当前页table
                for(var i = 0; i < results.length; i++)
                {
                    tablestr += "<tr><td>" + results[i].recipient + "</td><td>" + results[i].subject + "</td><td>" + results[i].sendtime +
                        "</td><td>" + results[i].content + "</td><td><a type=\"button\" class=\"btn btn-success\" target=\"_blank\" href=" +
                        results[i].url + ">查看</a></td></tr>"
                }
                $("#receivetable").html(tablestr);

                $("#currentPage").html(currentPage);
            },
            error:function()
            {
            }
        });
    })
});
