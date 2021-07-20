package com.pjb.job;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 同步用户信息Job
 * @author pan_junbiao
 **/
public class SyncUserJob extends QuartzJobBean
{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
    {
        //获取JobDetail中传递的参数
        String userName = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("userName");
        String blogUrl = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("blogUrl");
        String blogRemark = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("blogRemark");

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //打印信息
        System.out.println("用户名称：" + userName);
        System.out.println("博客地址：" + blogUrl);
        System.out.println("博客信息：" + blogRemark);
        System.out.println("当前时间：" + dateFormat.format(date));
        System.out.println("----------------------------------------");
    }
}
