package com.practice.automation_code;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectDropDownTest 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp()
	{
		driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}
	
	@Test
	public void verifyCheckbox() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//select[@id='dropdown']")).click();		
		Thread.sleep(3000);
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByValue("1");
		WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[2]"));
		Assert.assertEquals("Option 1", option1.getText());
		Thread.sleep(3000);
		dropdown.selectByValue("2");
		WebElement option2 = driver.findElement(By.xpath("//select[@id='dropdown']/option[3]"));
		Assert.assertEquals("Option 2", option2.getText());
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
