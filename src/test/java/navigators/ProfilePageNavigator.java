package navigators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageNavigator {
private WebDriver driver;
	
	public ProfilePageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Input Search Product
	public void inputSearchField(String searchInput) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
		WebElement filterSearch = this.driver.findElement(By.id("filter_name"));
        filterSearch.sendKeys(searchInput);    
	}
	
	// Click Search Button Search the Product
	public void clickSearchButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
        WebElement searchButton = this.driver.findElement(By.xpath("//button[@class='btnn']"));
        searchButton.click();
	}
}
