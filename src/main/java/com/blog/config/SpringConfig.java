package com.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc	//for swagger
public class SpringConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
