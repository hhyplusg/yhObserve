package com.wave.flexbletimer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.wave.websocket.MyWebSocketHandler;
 
/**
 * 真实运行的业务类
 * 要持久化等特性操作,需要继承 QuartzJobBean
 * 由于要被持久化,所以不能存放xxxxManager类似对象,只能从每次从QuartzJobBean注入的ApplicationContext 中去取出继承QuartzJobBean，实现方法executeInternal
 * Needed to set Quartz useProperties=true when using Spring classes, because
 * Spring sets an object reference on JobDataMap that is not a String
 * 
 * @see http://site.trimplement.com/using-spring-and-quartz-with-jobstore-properties
 *      /
 * @see http
 *      ://forum.springsource.org/showthread.php?130984-Quartz-error-IOException
 */
@Component
public class CreateShipUpdateSchedule extends QuartzJobBean {
	@Bean
    public MyWebSocketHandler WebSocketHandler() {
        return new com.wave.websocket.MyWebSocketHandler();
    }  
    protected transient final Logger log = LogManager.getLogger(getClass());  
    protected void executeInternal(JobExecutionContext arg0)
      throws JobExecutionException {
    log.debug("execute schedule start ");
    // TODO
    log.debug("exxcute schedule end");
  }
	 
}