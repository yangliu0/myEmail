package cn.liu5599.controller;

import cn.liu5599.pojo.MyMail;
import cn.liu5599.service.MyMailService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sendEmail")

/**
 * 控制与Mail相关的请求
 * @ClassName MyMailController
 * @author Liu Yang
 * @version 1.0
 */

public class MyMailController
{
    //必须进行授权验证，才可以发送邮件
    @Autowired
    private JavaMailSender mailSender;

    @Resource
    private MyMailService myMailService;

    @RequestMapping(value = "normal", method = RequestMethod.GET)
    @ResponseBody

    /**
     * 发送邮件请求，POST方法<br>
     * 发送邮件为纯文本邮件<br>
     * 请求url: sendEmail
     * @param recipientAddress 收信人邮箱
     * @param subject 邮件主题
     * @param message 邮件内容
     * @return String success
     */

    public String doSendEmail(@RequestParam("recipient") String recipientAddress,
    @RequestParam("subject") String subject, @RequestParam("message") String message)
    {
        //发信人
        String sentFrom = "testmail19414123@sina.com";

        //打印信息
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        //创建简单邮件
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(sentFrom);
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);

        //发送邮件
        mailSender.send(email);

        //返回值
        return "seccess";
    }

    /**
     * 发送html形式的邮件<br/>
     * @param recipientAddress
     * @param subject
     * @param message
     * @return success,代表发送成功
     * @throws MessagingException
     */
    @RequestMapping(value = "/html", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject SendEmail(@RequestParam("destination") String recipientAddress,
                                @RequestParam("subject") String subject, @RequestParam("content") String message) throws MessagingException
    {
        JSONObject json = new JSONObject();
        //发件人
        String sentFrom = "testmail19414123@sina.com";

        //打印设置的收件人、文章主题、内容
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        MimeMessage mailMessage = mailSender.createMimeMessage();
        //设置为gbk，防止中文乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "GBK");
        try
        {
            messageHelper.setFrom(sentFrom);
            messageHelper.setTo(recipientAddress);
            messageHelper.setSubject(subject);
            //设置为true代表支持html
            messageHelper.setText(message, true);
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

        //发送邮件
        mailSender.send(mailMessage);

        json.put("ret", "success");

        //保存刚才发送的邮件到本数据库
        Date date = new Date();
        MyMail myEmail = new MyMail();
        myEmail.setRecipient(recipientAddress);
        myEmail.setSender(sentFrom);
        myEmail.setSendtime(date);
        myEmail.setState(Byte.parseByte("1"));
        myEmail.setSubject(subject);
        myEmail.setContent(message);
        this.myMailService.addEmail(myEmail);
        int id = myEmail.getId();
        myEmail.setUrl("http://127.0.0.1:18080/myEmail/sendEmail/" + id);
        this.myMailService.updateById(myEmail);

        return json;

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    //获取一页邮件
    public Map getList(@RequestParam("index") String index, @RequestParam("pageSize") String pageSize)
    {
        List<Map<String, Object>> list;
        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
        list = this.myMailService.getList(Integer.parseInt(index), Integer.parseInt(pageSize));
        map.put("ret", list);

        return map;
    }

    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    @ResponseBody
    //获取邮件总数
    public int getCount()
    {
        return this.myMailService.getCount();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //查看收信箱邮件详情
    public ModelAndView toEmail(@PathVariable(value = "id") String id)
    {
        MyMail mail;
        mail = this.myMailService.getEmailById(Integer.parseInt(id));

        //格式化输出时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject json = new JSONObject();
        json.put("sender", mail.getSender());
        json.put("recipient", mail.getRecipient());
        json.put("sendtime", sdf.format(mail.getSendtime()));
        json.put("subject", mail.getSubject());
        json.put("content", mail.getContent());
        map.put("email", json);
        return new ModelAndView("sendDetails", map);
    }
}
