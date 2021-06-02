package quartz.cluster.demo.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quartz.cluster.demo.scheduler.QuartzJobSupervisor;


@RestController
@RequestMapping("/quartz")
@ConditionalOnProperty(prefix = "quartz", value = "enabled", havingValue = "true")
public class QuartzApiController {

    @Autowired
    private QuartzJobSupervisor quartzJobSupervisor;


    @RequestMapping("/info")
    public String getQuartzJob(String name, String group) throws SchedulerException {
        return quartzJobSupervisor.getJobInfo(name, group);
    }

    @RequestMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) throws SchedulerException {
        return quartzJobSupervisor.modifyJob(name, group, time);
    }

    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) throws SchedulerException {
        quartzJobSupervisor.pauseJob(name, group);
    }

    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() throws SchedulerException {
        quartzJobSupervisor.pauseAllJob();
    }

    @RequestMapping(value = "/delete")
    public void deleteJob(String name, String group) throws SchedulerException {
        quartzJobSupervisor.deleteJob(name, group);
    }

}
