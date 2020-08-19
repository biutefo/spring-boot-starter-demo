package pers.xin.boot.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private String person;

    private String content;

    public HelloProperties() {
        System.out.println("============================================HelloProperties()============================================");
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        System.out.println("============================================setPerson(" + person + ")============================================");
        this.person = person;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
