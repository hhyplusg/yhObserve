package com.wave.flexbletimer.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * ###AutowiringSpringBeanJobFactory.java### 使用spring的 bean文件时，需要使用此类
 * Autowire Quartz Jobs with Spring context dependencies
 */
public final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory
    implements ApplicationContextAware {

  private transient AutowireCapableBeanFactory beanFactory;

  public void setApplicationContext(final ApplicationContext context) {
    beanFactory = context.getAutowireCapableBeanFactory();
  }

  @Override
  protected Object createJobInstance(final TriggerFiredBundle bundle)
      throws Exception {
    final Object job = super.createJobInstance(bundle);
    beanFactory.autowireBean(job); 
    return job;
  }
}