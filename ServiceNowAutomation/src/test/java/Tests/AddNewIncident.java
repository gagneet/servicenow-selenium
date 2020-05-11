package Tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Framework.Verify;
@Listeners(Framework.TestMethodListener.class)
public class AddNewIncident extends SeleniumWebTests {

	@Test
	public void AddingNewIncident() throws InterruptedException {
		
		//Thread.sleep(10000);
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("iframes sizes are"+iframes.size());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("HomeAffairs$5");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='sysverb_login']")).click();
		Thread.sleep(5500);
		List<WebElement> iframes1 = driver.findElements(By.tagName("iframe"));
		System.out.println("iframes sizes are"+iframes1.size());
		driver.findElement(By.cssSelector("#filter")).sendKeys("Incidents");
		Thread.sleep(2500);
		List<WebElement>elelist = driver.findElements(By.xpath("//div[@class='sn-widget-list-title']"));
		elelist.get(8).click();
		Thread.sleep(1500);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//*[@id='sys_display.incident.caller_id']")).clear();
		driver.findElement(By.xpath("//*[@id='sys_display.incident.caller_id']")).sendKeys("Aileen Mottern");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='incident.short_description']")).sendKeys("This is a Test");
		WebElement elmnt = driver.findElement(By.cssSelector(".container-fluid"));
		Actions action = new Actions(driver).contextClick(elmnt);
		action.build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='context_1']/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='incident.short_description']")).clear();
		driver.findElement(By.xpath("//*[@id='incident.short_description']")).sendKeys("This is a Test Part A");
		driver.findElement(By.xpath("//*[@id='sysverb_update']")).click();
		Thread.sleep(2000);
	}
	
	
	
}
