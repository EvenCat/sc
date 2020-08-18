package com.even.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author 北方、
 * @title: SpringUtils
 * @projectName sc
 * @description: TODO
 * @date 2020/8/11 12:11
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    public static BeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        this.beanFactory = configurableListableBeanFactory;
    }

    public static <T> T getBeans(Class<T> beanType){
        T bean = beanFactory.getBean(beanType);
        return bean;
    }
}
