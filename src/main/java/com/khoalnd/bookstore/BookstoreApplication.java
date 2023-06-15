package com.khoalnd.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (
		info = @Info(
				title = "Book Store Project",
				version = "1.0",
				description = "This project is my first REST API project",
				contact = @Contact (
						name = "Khoa Ly",
						email = "khoaly090141@gmail.com"
				)
		)
)

public class BookstoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}