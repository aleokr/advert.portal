package com.app.advert.portal;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping
public class Application {
	@Operation(tags = {"Example"},
			description = "Description")
	@GetMapping("/example")
	public String example() {
		return "example";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
