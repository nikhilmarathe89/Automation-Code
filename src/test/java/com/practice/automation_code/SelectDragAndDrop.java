package com.practice.automation_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectDragAndDrop 
{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
	}
	
	@Test
	public void verifyDragAndDrop() throws InterruptedException
	{
		WebElement box1 = driver.findElement(By.xpath("//div[@id='content']/div/div/div[1]/header"));
		WebElement box2 = driver.findElement(By.xpath("//div[@id='content']/div/div/div[2]/header"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(box1, box2).perform();
		
		box1 = driver.findElement(By.xpath("//div[@id='content']/div/div/div[1]/header"));
		box2 = driver.findElement(By.xpath("//div[@id='content']/div/div/div[2]/header"));
		
		Thread.sleep(4000);
		Assert.assertEquals("A", box2.getText());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
