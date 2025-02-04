package navigators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageNavigator {
private WebDriver driver;
	
	public SearchPageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Find One Product That Available in Stock
	public void findOneAvailableProduct() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.xpath("//div[@class='row row-category-grid']//div[@class='single-product']")
        ));

        boolean productFound = false;
        
        for (WebElement product : products) {
            List<WebElement> unavailableElements = product.findElements(By.xpath(".//*[@class='currently-unavailable']"));

            if (unavailableElements.isEmpty()) {
            	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
                WebElement productLink = product.findElement(By.xpath(".//h3/a"));
                productLink.click();
                productFound = true;
                break;
            }
        }    
	}
}
