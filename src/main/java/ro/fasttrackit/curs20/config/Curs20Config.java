package ro.fasttrackit.curs20.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Curs20Config {
    private static final Logger log = LoggerFactory.getLogger(Curs20Config.class);
    private final String applicationMane;

    public Curs20Config(
            @Value("${spring.application.name}") String applicationName,
            @Value("${fasttrackit.curs.topic}") String topic) {
        log.info("My app is called {}", applicationName);
        this.applicationMane = applicationName;
        log.info("The topic is{}", topic); //ca un System.out sistematizat
    }

    public String getApplicationMane() {
        return applicationMane;
    }
}
