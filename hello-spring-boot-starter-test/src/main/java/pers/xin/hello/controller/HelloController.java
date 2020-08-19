package pers.xin.hello.controller;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xin.boot.starter.HelloService;

/**
 * @Author BG387379
 * @Date 2020/8/19 17:09
 */

@RestController
public class HelloController implements ApplicationContextAware {

    private ApplicationContext context;

    @Resource
    private HelloService helloService;

    @GetMapping("sayHello")
    public String sayHello() {
        return helloService.sayHello();
    }

    @GetMapping("getHelloServiceBean")
    public String getHelloServiceBean() {
        return context.getBean(HelloService.class).toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
