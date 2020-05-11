package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.Verify;
@Listeners(framework.TestMethodListener.class)
public class AddNewIncident extends SeleniumWebTests {

	@Test(description="a) Login to ServiceNow (manual if Captcha, but at least the username/password should be entered and the login button clicked)\r\n" + 
			"b) Search for \"Incident\" in the \"Filter navigator\" on the left side panel\r\n" + 
			"c) Click \"Incident -> Create New\"\r\n" + 
			"d) On the right side, a form will come up, enter the mandatory fields\r\n" + 
			"i) Caller: Click on the search button (magnifying lens next to text box). Select \"Aileen Mottern\" from the new popup.\r\n" + 
			"ii) Short Description: Enter in text box - \"This is a Test\"\r\n" + 
			"e) On the top bar (green colour), right click and click on \"Save\"\r\n" + 
			"f) Change the 'Short Description' text box to \"This is a Test - Part A\"\r\n" + 
			"g) Click on \"Update\" button on the top bar (green colour)"
			+ "h) Verify if the ticket is visible in the list")
	public void AddNewIncident_verifyifnewticketnumberisvisbleinthelist() throws InterruptedException {
		
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
		driver.findElement(By.cssSelector("#filter")).sendKeys("Incident");
		Thread.sleep(2500);
		List<WebElement>elelist = driver.findElements(By.xpath("//div[text()='Create New']"));
		elelist.get(0).click();
		Thread.sleep(1500);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		String incNumber = driver.findElement(By.xpath("//*[@id=\"incident.number\"]")).getAttribute("value");
		System.out.println("Incident number is:"+incNumber);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[text()='Aileen Mottern']")).click();
		Thread.sleep(2500);
		System.out.println(driver.getWindowHandles());
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab1.get(0));
		Thread.sleep(1500);
        driver.switchTo().frame(0);
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
		Verify.verifyEquals(driver.findElement(By.xpath("//a[text()='"+incNumber+"']")).isDisplayed(), true, "adding new incident failed");
		
	}
	
	
	
}
