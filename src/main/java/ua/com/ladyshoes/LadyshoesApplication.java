package ua.com.ladyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LadyshoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LadyshoesApplication.class, args);
	}

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/*")
				.permitAll()
				.anyRequest()
				.authenticated();
	}
*/
}

