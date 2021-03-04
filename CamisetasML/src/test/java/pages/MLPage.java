package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MLPage extends Base {
	By searchBox = By.name("as_word");
	By searchButton = By.className("nav-search-btn");
	By productTitle = By.className("ui-search-item__title");
	By productURL = By.tagName("a");
	By productPrice = By.className("price-tag-fraction");
	By nextPage = By.className("andes-pagination__arrow-title");
	public int qtyPages = 3;
	public String path = "C:\\Users\\BREDA\\Desktop\\";
	public String fileName = "FileMercadoLibreCamisetas.txt";
	
	
	public String getTitulo (WebElement product) {
		return getText(product.findElement(productTitle));
	}
	
	public String getURL (WebElement product) {
		return getURL(product.findElement(productURL));
	}
	
	public String getPrice (WebElement product) {
		return getText(product.findElement(productPrice));
	}
	
	public void nextPage () {
		Actions a = new Actions(driver);
		a.moveToElement(findElement(nextPage)).click().build().perform();
	}
	

	
	public void searchProduct (String product) {
		type("camisetas", searchBox);
		click(searchButton);
	}
	
	
	public MLPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 
}
