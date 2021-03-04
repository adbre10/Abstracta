package Tests;
import org.testng.annotations.Test;

import pages.MLPage;

import org.testng.annotations.BeforeMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestML {
	private WebDriver driver;
	MLPage mlPage;

	  @BeforeMethod
	  public void beforeMethod() {
		  mlPage = new MLPage(driver);
		  driver = mlPage.chromedriverconn();
		  mlPage.visit("https://www.mercadolibre.cl/");
	  }

	
	
  @Test
  public void GuardarProductos() throws IOException {
	  
	  //buscar por CAMISETAS e incluir los elementos en lista
  mlPage.searchProduct("camisetas");
  List<WebElement> products = mlPage.findElements(By.className("ui-search-layout__item"));
	 
  
  File file = new File(mlPage.path + mlPage.fileName);
  FileWriter guardar = new FileWriter(file);
  BufferedWriter escritura = new BufferedWriter(guardar);
  
  //incluir en archivo los productos de Pagina 1
  
  for (int i=1;i<=mlPage.qtyPages;i++) {
	  for (WebElement product : products) {
		  String lineaFile = mlPage.getTitulo(product) + ";" + mlPage.getURL(product) + ";" + mlPage.getPrice(product);  
		  	  
		  escritura.write(lineaFile);
		  escritura.newLine();
  
  		}
	  
	  //Pasar a la siguiente pagina
	  mlPage.nextPage();
	  
  }
	
    escritura.close();
  
      
      
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
