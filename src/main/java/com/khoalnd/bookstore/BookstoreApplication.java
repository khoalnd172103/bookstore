package com.khoalnd.bookstore;

import com.khoalnd.bookstore.entity.Author;
import com.khoalnd.bookstore.entity.Book;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
//		tags = {
//				@Tag(name = "book", description = "Read all books you want"),
//				@Tag(name = "author", description = "Know more about author")
//		}
)

public class BookstoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}