package quartz.cluster.demo.timer;

import io.github.danielpine.quartz.starter.annotation.QuartzTrigger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quartz.cluster.demo.service.SpiderTaskExecutor;

import javax.annotation.Resource;

@QuartzTrigger(cron = "0 0/1 * * * ?", group = "spider", name = "task")
public class QuartzTaskJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(QuartzTaskJob.class);

    @Resource
    private SpiderTaskExecutor spiderTaskExecutor;

    @Override
    public void execute(JobExecutionContext context) {
        spiderTaskExecutor.saveCommodityQuotes();
    }
}
