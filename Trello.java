package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Trello {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		 
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://trello.com/en/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user")).sendKeys("shanmugapriya.mickey@gmail.com");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Priyashan123#");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.xpath("//p[@class='szBTSFrvPTLGHM']")).click();
		driver.findElement(By.xpath("//span[text()='Create board']")).click();
		driver.findElement(By.xpath("//input[@class='nch-textfield__input lsOhPsHuxEMYEb lsOhPsHuxEMYEb VkPAAkbpkKnPst']")).sendKeys("Assignment");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("List A", Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("List B", Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='js-add-a-card'])[1]")).click();
		driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys("Card A", Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='js-add-a-card'])[2]")).click();
		
		WebElement source = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']"));
		WebElement target = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
		Actions builder = new Actions(driver);
		try {
			builder.dragAndDrop(source, target).perform();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		int x = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']")).getLocation().getX();
		System.out.println(x);
		int y = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']")).getLocation().getY();
		System.out.println(y);
		
		driver.findElement(By.xpath("//span[@class='DweEFaF5owOe02 rQ86P0iNikD4I9 Cg0RMJhBknTRbM']")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
		Thread.sleep(3000);
		driver.close();
	
	
	
	
	
	}
	

}
