package navigators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageNavigator {
	private WebDriver driver;
	
	public LoginPageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Input Email Into Email Field
	public void inputEmail(String email) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
		WebElement emailField = this.driver.findElement(By.name("email"));
        emailField.sendKeys(email);
	}
	
	// Input Password Into Password Field
	public void inputPassword(String password) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
		WebElement passwordField = this.driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
	}
	
	// Click Log In Button in Login Page
	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
        WebElement loginButton = this.driver.findElement(By.id("button-login"));
        loginButton.click();
	}
}
