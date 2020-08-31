package com.wipro.assessment.at.configuration;

import org.jbehave.web.selenium.TypeWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
@ComponentScan({ "com.wipro.assessment" })
@PropertySource("classpath:configs/env.properties")
public class ProjectConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public WebDriverProvider webDriverProvider() {
		WebDriverManager.chromedriver().setup();
		return new TypeWebDriverProvider(ChromeDriver.class);
	}

	@Bean
	public WebDriverScreenshotOnFailure screenshotOnFailureDriver() {
		return new WebDriverScreenshotOnFailure(webDriverProvider());
	}
}
