package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import navigators.*;
import entity.Product;
public class PeriplusTest {

		private WebDriver driver;
		private LandingPageNavigator landingPageNavigator;
		private LoginPageNavigator loginPageNavigator;
		private ProfilePageNavigator profilePageNavigator;
		private SearchPageNavigator searchPageNavigator;
		private ProductPageNavigator productPageNavigator;
		private CartPageNavigator cartPageNavigator;
		
		@BeforeTest
		public void initTest() {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			this.driver = new ChromeDriver();
			this.driver.get("https://www.periplus.com/");
			this.landingPageNavigator = new LandingPageNavigator(this.driver);
			this.loginPageNavigator = new LoginPageNavigator(this.driver);
			this.profilePageNavigator = new ProfilePageNavigator(this.driver);
			this.searchPageNavigator = new SearchPageNavigator(this.driver);
			this.productPageNavigator = new ProductPageNavigator(this.driver);
			this.cartPageNavigator = new CartPageNavigator(this.driver);
		}
		
		@AfterTest
		public void tearDown() {
			this.driver.quit();
		}

		@Test
		public void myTest() {
			String email = "rajestikatest@gmail.com";
			String password = "PeriplusTest123";
			String searchInput = "harry potter";
			 
			this.landingPageNavigator.clickSignInButton();
			
			this.loginPageNavigator.inputEmail(email);
			
			this.loginPageNavigator.inputPassword(password);
			
			this.loginPageNavigator.clickLoginButton();
	        
			this.profilePageNavigator.inputSearchField(searchInput);
			
			this.profilePageNavigator.clickSearchButton();
			
			this.searchPageNavigator.findOneAvailableProduct();
		
			this.productPageNavigator.clickAddToCartButton();
			
			Product expectedProduct = this.productPageNavigator.gatherProductDetails();
			
			this.productPageNavigator.clickShoppingCartButton();
			
			Product actualProduct = this.cartPageNavigator.gatherCartProductDetails();

			Assert.assertEquals(expectedProduct, actualProduct, "Product in cart is different with checked out product");
		}
}