package navigators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import entity.Product;

public class ProductPageNavigator {
private WebDriver driver;
	
	public ProductPageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Click Add To Cart Button in Product Page
	public void clickAddToCartButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-add-to-cart']")));
		addToCartButton.click();
		closeModal();
	}
	
	// Cast Product Price to Integer
	private Integer castPriceToInteger(String price) {
		String cleanedString = price.replace("Rp", "").replace(" ", "");       
        cleanedString = cleanedString.replace(",", "");  
        Integer productPrice = Integer.parseInt(cleanedString);
        return productPrice;
	}
	
	// Gather Expected Product Details
	public Product gatherProductDetails() {
		WebElement productNameElement = this.driver.findElement(By.xpath("//div[contains(@class, 'quickview-content')]/h2"));
		String productName = productNameElement.getText();
		
		String url = this.driver.getCurrentUrl();
		String productIsbn = url.split("/")[4].trim();
				
		WebElement priceElement = this.driver.findElement(By.xpath("//div[@class='quickview-price']/span"));
		String stringProductPrice = priceElement.getText().trim();
		
		Product product = new Product(productName, productIsbn, castPriceToInteger(stringProductPrice));
		
		return product;
	}
	
	// Close Modal After Add a Product to Cart
	private void closeModal() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
		WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-modal-close close']")));
	    closeModalButton.click(); 
	}
	
	// Click Shopping Cart Button in Product Page
	public void clickShoppingCartButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
	    WebElement cartButton = this.driver.findElement(By.xpath("//div[@id='show-your-cart']//a[@class='single-icon']"));
	    cartButton.click();
	}
}
