package ro.fasttrackit.curs20.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fasttrackit.curs")
public class FasttrackitCursConfig {
    private  int number;
    private String topic;


    public int getNumber() {
        return number;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
