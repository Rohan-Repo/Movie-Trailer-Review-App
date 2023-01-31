package in.easysystems.movies;

/*
	Spring application needs run() method to start the Spring app and pass the .class to it
	Annotations Tell the Compiler what this class does
	Whitelabel Error Page means we have not setup any End-points
	.env file used to hide credentials and also added into .gitignore
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	// To take out CORS errors in the front-end we use the below mentioned code:
	// And Directly use localhost:8080 instead of ngrok

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // "Access-Control-Allow-Origin": "*",
						.allowedHeaders("*") //"Access-Control-Allow-Headers": "*",
						.allowCredentials(false).maxAge(3600); // Access-Control-Allow-Credentials: false
			}
		};
	}

}
