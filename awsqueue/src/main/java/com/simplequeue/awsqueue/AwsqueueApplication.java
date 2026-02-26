package com.simplequeue.awsqueue;

import com.simplequeue.awsqueue.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsqueueApplication implements CommandLineRunner {

	@Autowired
	private MessageSender messageSender;

    public AwsqueueApplication(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public static void main(String[] args) {
		SpringApplication.run(AwsqueueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      int i=1;
			while (true){
				messageSender.sendMessage("hello world"+i);
				Thread.sleep(5000);
				++i;

			}

	}
}
