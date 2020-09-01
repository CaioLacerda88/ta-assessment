package com.wipro.assessment.at.pages;

import java.time.Duration;
import java.util.List;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage {

	@Autowired
	protected WebDriverProvider webDriverProvider;

	public void waitPageLoad() {
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(elementsToWait()));
	}

	public void waitElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webDriverProvider.get().findElement(locator).click();
	}

	public boolean waitAndCheckIfElementIsVisible(WebElement element, long timeoutInSeconds) {
		return new FluentWait<WebDriver>(webDriverProvider.get()).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element)) != null;

	}

	protected List<WebElement> elementsToWait() {
		return null;
	}
}
