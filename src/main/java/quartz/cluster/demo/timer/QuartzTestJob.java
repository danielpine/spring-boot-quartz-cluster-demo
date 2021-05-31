package quartz.cluster.demo.timer;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@QuartzTrigger(cron = "0/5 * * * * ?", group = "spider", name = "test")
public class QuartzTestJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(QuartzTestJob.class);

    @Resource
    private SpiderTaskExecutor spiderTaskExecutor;

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("@Scheduled run()");
    }
}
