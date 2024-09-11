package com.springInitializer.DemoSpring;

import com.springInitializer.DemoSpring.Entity.Demon;
import com.springInitializer.DemoSpring.Repository.DemonRepository;
import org.slf4j.Logger; //instead of sout.
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {

	@Autowired //it will inject the bean into the field variable, goes to the ioc to find this bean
	private DemonRepository demonRepository;

	Logger logger = LoggerFactory.getLogger(DemoSpringApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Demon demon1 = new Demon(450.56, "Valak", 7.89, "Monster of the great plains of Jerginstan");
		logger.info(demonRepository.save(demon1).toString());
		logger.error("This is an error example");

	}
}
