package ro.fasttrackit.curs20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs20.config.FasttrackitCursConfig;

@SpringBootApplication
public class Curs20CodeApplication {
	private static final Logger log = LoggerFactory.getLogger(Curs20CodeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Curs20CodeApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(FasttrackitCursConfig config) { //CommandLineRunner are foar metoda run care primeste args
		return args -> {
			log.info("The config is {}", config.getNumber());
			log.info("the topic is {}", config.getTopic());
		};
	} //in args primesc argumentele cu care se porneste aplicatia

}
