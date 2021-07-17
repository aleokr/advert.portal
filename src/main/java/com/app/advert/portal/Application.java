package com.app.advert.portal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
