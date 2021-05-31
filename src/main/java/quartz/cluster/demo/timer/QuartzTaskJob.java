package quartz.cluster.demo.timer;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quartz.cluster.demo.annotation.QuartzTrigger;
import quartz.cluster.demo.service.SpiderTaskExecutor;

import javax.annotation.Resource;

/**
 * @DisallowConcurrentExecution : 此标记用在实现Job的类上面,意思是不允许并发执行.
 * 注org.quartz.threadPool.threadCount的数量有多个的情况,@DisallowConcurrentExecution才生效
 */
@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@QuartzTrigger(cron = "0 0/1 * * * ?", group = "spider", name = "task")
public class QuartzTaskJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(QuartzTaskJob.class);

    @Resource
    private SpiderTaskExecutor spiderTaskExecutor;

    /**
     * 核心方法,Quartz Job真正的执行逻辑.
     *
     * @param context JobExecutionContext 中封装有Quartz运行所需要的所有信息
     */
    @Override
    public void execute(JobExecutionContext context) {
        spiderTaskExecutor.saveCommodityQuotes();
    }
}
