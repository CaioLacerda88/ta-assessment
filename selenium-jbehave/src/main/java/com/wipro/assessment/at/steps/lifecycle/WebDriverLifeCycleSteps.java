package com.wipro.assessment.at.steps.lifecycle;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.assessment.at.configuration.pageobjects.PageObjectBeanPostProcessor;

@Component
public class WebDriverLifeCycleSteps {

	@Autowired
	PageObjectBeanPostProcessor pageObjectPostProcessor;

	@Autowired
	WebDriverProvider driverProvider;

	@BeforeStory
	public void beforeStory() throws Exception {
		// Open browser:
		driverProvider.initialize();

		// Maximize browser window:
		driverProvider.get().manage().window().maximize();

		// Configuring timeouts for page load and implicit wait:
		driverProvider.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverProvider.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// Initialize all Page Object classes:
		for (Object page : pageObjectPostProcessor.getPageObjects()) {
			PageFactory.initElements(driverProvider.get(), page);
		}
	}

	@BeforeScenario(uponType = ScenarioType.ANY)
	public void beforeScenario() {
		// Delete cookies:
		driverProvider.get().manage().deleteAllCookies();
	}

	@AfterStory
	public void afterStory() throws Exception {
		// Close browser:
		driverProvider.end();
	}
}
