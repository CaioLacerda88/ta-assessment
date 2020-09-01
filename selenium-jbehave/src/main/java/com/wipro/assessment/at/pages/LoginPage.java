package com.wipro.assessment.at.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginPage extends AbstractPage {
	@Value("${URL_LOGIN}")
	private String URL_LOGIN;

	@FindBy(id = "username")
	private WebElement userNameTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(className = "error")
	private WebElement errorMessageField;

	@FindBy(xpath = "//a[contains(text(),'Olá,')]")
	private WebElement welcomeField;

	public void navigateTo() {
		log.info("Navigating to login page...");
		webDriverProvider.get().get(URL_LOGIN);
	}

	public void typeInUserName(String userName) {
		log.info("Typing in username field...");
		userNameTextField.sendKeys(userName);
	}

	public void typeInPassword(String password) {
		log.info("Typing in password field...");
		passwordTextField.sendKeys(password);
	}

	public void pressLoginButton() {
		log.info("Pressing login button...");
		loginButton.click();
	}

	public boolean helloFieldExists() {
		log.info("Waiting for welcome field...");
		return waitAndCheckIfElementIsVisible(welcomeField, 10);
	}

	public boolean errorMessageExists() {
		log.info("Waiting for error message...");
		return waitAndCheckIfElementIsVisible(errorMessageField, 10);
	}

}
