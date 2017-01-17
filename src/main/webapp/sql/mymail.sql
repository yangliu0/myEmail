USE mail;

DROP TABLE IF EXISTS mymail;

CREATE TABLE mymail(
id INT NOT NULL AUTO_INCREMENT      /* 邮件id */
,recipient VARCHAR(32) NOT NULL     /* 收信人 */
,sender VARCHAR(32) NOT NULL        /* 发信人 */
,subject VARCHAR(64)                /* 主题 */
,content TEXT                        /* 内容 */
,sendtime DATETIME                   /* 发信时间 */
,state TINYINT                       /* 邮件状态 0为草稿 1为已发送 */
,url VARCHAR(64)                    /* url，保存查看邮件详情的地址 */
,PRIMARY KEY(id)
);