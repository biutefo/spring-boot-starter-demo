package pers.xin.boot.starter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.xin.boot.starter.HelloService;
import pers.xin.boot.starter.properties.HelloProperties;

/**
 * @author xiaohan
 */
@Configuration
@ConditionalOnWebApplication//web应用生效生效
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Bean
    //@ConditionalOnProperty(value = "hello.customer.enabled")
    //@ConditionalOnProperty(name = {"hello.person","hello.content","hello.lalalala"})
    @ConditionalOnProperty(name = {"hello.person", "hello.content"})
    public HelloService customerHelloService(@Autowired HelloProperties helloProperties) {
        System.out.println(
            "============================================customerHelloService============================================");
        return () -> helloProperties.getContent() + "\nfrom " + helloProperties.getPerson();
    }

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService defaultHelloService() {
        System.out.println(
            "============================================defaultHelloService============================================");
        return () -> "Hello,world!";
    }

}
