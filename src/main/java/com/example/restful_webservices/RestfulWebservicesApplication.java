package com.example.restful_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebservicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestfulWebservicesApplication.class, args);
	}
	@Bean
	public LocaleResolver localeResolver(){
	//	SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	// this can be configured in application properties
//	@Bean
//	public ResourceBundleMessageSource messageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("messages");
//		return messageSource;
//	}
}
