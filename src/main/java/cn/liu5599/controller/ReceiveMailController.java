package cn.liu5599.controller;

import cn.liu5599.pojo.ReceiveMail;
import cn.liu5599.service.ReceiveMailService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 使用POP3协议接收邮件
 */
@Controller
@RequestMapping(value = "/receive")
public class ReceiveMailController
{
    @Resource
    private ReceiveMailService receiveMailService;

    /**
     * 添加邮件到本数据库<br/>
     * @param cmd
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JSONObject add(@RequestParam(value = "cmd") String cmd) throws Exception
    {
        int changed = 0;
        JSONObject json = new JSONObject();
        if(cmd.equals("add"))
        {
            //若有新邮件，则返回值为1
            changed = this.receiveMailService.addMail();
            json.put("ret",changed);
        }
        return json;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    //获取一页邮件
    public Map getList(@RequestParam("index") String index, @RequestParam("pageSize") String pageSize)
    {
        List<Map<String, Object>> list;
        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
        list = this.receiveMailService.getList(Integer.parseInt(index), Integer.parseInt(pageSize));
        map.put("ret", list);

        return map;
    }

    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    @ResponseBody
    //获取邮件总数
    public int getCount()
    {
        return this.receiveMailService.getCount();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //查看收信箱邮件详情
    public ModelAndView toEmail(@PathVariable(value = "id") String id)
    {
        ReceiveMail mail;
        mail = this.receiveMailService.getEmail(Integer.parseInt(id));

        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject json = new JSONObject();
        json.put("sender", mail.getSender());
        json.put("recipient", mail.getRecipient());
        json.put("sendtime", mail.getSendtime());
        json.put("subject", mail.getSubject());
        json.put("content", mail.getContent());
        map.put("email", json);
        return new ModelAndView("details", map);
    }
}
