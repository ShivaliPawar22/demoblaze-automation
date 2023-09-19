//import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	 
	 //public static WebDriver driver = new ChromeDriver();
	 
	 public static String cartAmount = null;
	 
	 static class Product {
		void Laptop(WebDriver driver) throws InterruptedException{

			driver.findElement(By.className("nav-link")).click(); //Home
			
			driver.findElement(By.linkText("Laptops")).click();   //Laptop
			
			driver.findElement(By.linkText("MacBook air")).click(); //Macbook
			
			driver.findElement(By.linkText("Add to cart")).click(); // Add to cart	
			
		    Thread.sleep(2000);
		
			Alert alert = driver.switchTo().alert(); // switch to alert

			String alertMessage= driver.switchTo().alert().getText(); // capture alert message
			
			 //if message not matches execution will stop
			
			if(alertMessage.contains("Product added")) {
				
				System.out.println("Product added successfully!");
			}
			else
			{
				System.out.println("Failed to add product.");
				
			}	
			alert.accept();
		}
	}
	
	
	
	 static class Cart {
		void Placeorder(WebDriver driver){
			driver.findElement(By.id("cartur")).click(); //Click cart
			
			cartAmount = driver.findElement(By.id("totalp")).getText(); //get amount
			
			driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click(); //place order
			
			
			WebElement purchase= driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")); //element purchase order
			
			JavascriptExecutor js = (JavascriptExecutor) driver; //scroll down
			
			js.executeScript("arguments[0].scrollIntoView()", purchase); // scroll to web element
			
			driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click(); //Click purchase
			
			Alert alert = driver.switchTo().alert(); // switch to alert
	
			String ErrorMessage= driver.switchTo().alert().getText(); // capture alert message
			
		    //if message not matches execution will stop
			
	        if(ErrorMessage.contains("Please fill out Name and Creditcard.")) {
				
				System.out.println("Please fill out Name and Creditcard message validated");
			}
			else
			{
				System.out.println("Please fill out Name and Creditcard message mismatched");
			}
	
			alert.accept();
		}
	}
	
	 static class Order {
		void Validation(WebDriver driver){
			driver.findElement(By.id("name")).sendKeys("Neha");
			driver.findElement(By.id("country")).sendKeys("India");
			driver.findElement(By.id("city")).sendKeys("Pune");
			driver.findElement(By.id("card")).sendKeys("4100 0000 0000 00001");
			driver.findElement(By.id("month")).sendKeys("01");
			driver.findElement(By.id("year")).sendKeys("2023");
			driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click(); //Click purchase
			
			
			  String Text = driver.findElement(By.xpath("/html/body/div[10]")).getText();//captures text on popup
			
			  if(Text.contains("Thank you for your purchase!")){
				  
					  if(Text.contains(cartAmount)) {
						  System.out.println("Amount matched with cart amount");
					  }
					  else
					  {
						  System.out.println("Amount and cart amount didnt match");
					  }
						  
					  System.out.println("Success message validated");
			         }
			  else
			  {
					  System.out.println("Success message does not match"); 
			  } 
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium jars\\Chromedriver\\Chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.demoblaze.com/");
		
		driver.manage().window().maximize();
		
		Product obj1 = new Product();
		Cart obj2 = new Cart();
		Order obj3 = new Order();
	
		
		obj1.Laptop(driver);
		Thread.sleep(2000);
		obj2.Placeorder(driver);
		Thread.sleep(2000);
		obj3.Validation(driver);
		
		
		
	}

}
