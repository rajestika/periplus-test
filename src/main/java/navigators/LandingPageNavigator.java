package navigators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageNavigator {
	
	private WebDriver driver;
	
	public LandingPageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Click Sign In Button in Landing Page
	public void clickSignInButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloader")));
		WebElement signInButton = this.driver.findElement(By.xpath("//span[@id='nav-signin-text']/a"));
	    signInButton.click();
	}
}
