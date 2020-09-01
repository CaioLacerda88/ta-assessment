package com.wipro.assessment.at.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.assessment.at.pages.LoginPage;

@Component
public class LoginSteps extends AbstractSteps {
	@Autowired
	LoginPage loginPage;

	@Given("I am on the homepage specified")
	public void givenIAmOnTheHomepageSpecified() {
		loginPage.navigateTo();
	}

	@When("I input the '$userName'")
	public void whenIInputTheuserName(@Named("userName") String userName) {
		loginPage.typeInUserName(userName);
	}

	@When("the '$password'")
	public void whenThepassword(@Named("password") String password) {
		loginPage.typeInPassword(password);
	}

	@When("click on login")
	public void whenClickOnLogin() {
		loginPage.pressLoginButton();
	}

	@Then("user should authenticate and see the home page")
	public void thenUserShouldAuthenticateAndSeeTheHomePage() {
		assertTrue(loginPage.helloFieldExists());
	}

	@Then("I should see an invalid login message")
	public void thenIShouldSeeAnInvalidLoginMessage() {
		assertTrue(loginPage.errorMessageExists());
	}

}
