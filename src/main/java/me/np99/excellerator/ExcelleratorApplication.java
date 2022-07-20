package me.np99.excellerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "me.np99.*")
public class ExcelleratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelleratorApplication.class, args);
	}

}
