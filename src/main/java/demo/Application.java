package demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("integration-context.xml")
public class Application implements CommandLineRunner {
	
	@Autowired
	ApplicationContext context;

	@Override
	public void run(String... arg0) throws Exception {
		MessageChannel inputChannel = context.getBean("inputChannel",MessageChannel.class);
		inputChannel.send(new GenericMessage<String>("Wolle"));

	
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
