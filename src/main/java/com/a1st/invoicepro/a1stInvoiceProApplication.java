package com.a1st.invoicepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class a1stInvoiceProApplication {
	private static final int STRENGHT = 12;

	public static void main(String[] args) {
		SpringApplication.run(a1stInvoiceProApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(STRENGHT);
	}

}