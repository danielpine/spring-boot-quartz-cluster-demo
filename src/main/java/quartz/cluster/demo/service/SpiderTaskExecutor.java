package quartz.cluster.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SpiderTaskExecutor {
    private static final Logger logger = LoggerFactory.getLogger(SpiderTaskExecutor.class);

    public void saveCommodityQuotes() {
        logger.info("-------------- Start  saveCommodityQuotes ---------------------");
        logger.info("-------------- Finish saveCommodityQuotes ---------------------");
    }

}
