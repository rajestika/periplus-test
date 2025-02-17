package navigators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import entity.Product;

public class CartPageNavigator {
private WebDriver driver;
	
	public CartPageNavigator(WebDriver driver) {
		this.driver = driver;
	}
	
	// Gather Actual Product Details
	public Product gatherCartProductDetails() {
		WebElement productElement = this.driver.findElement(By.xpath("//p[@class='product-name limit-lines']/a"));
		String productName = productElement.getText();
		
		WebElement productIdElement = this.driver.findElement(By.xpath("//div[@class='row' and contains(@style, 'font-size: 12px')]"));
		String productIsbn = productIdElement.getText().trim();
		
		WebElement priceElement = this.driver.findElement(By.xpath("//div[@class='row' and contains(text(), 'Rp')]"));
		String stringProductPrice = priceElement.getText().split("or")[0].trim();
		
		Product product = new Product(productName, productIsbn, castPriceToInteger(stringProductPrice));
		
		return product;
	}
	
	// Cast Product Price to Integer
	private Integer castPriceToInteger(String price) {
		String cleanedString = price.replace("Rp", "").replace(" ", "");       
        cleanedString = cleanedString.replace(",", "");  
        Integer productPrice = Integer.parseInt(cleanedString);
        return productPrice;
	}
}
