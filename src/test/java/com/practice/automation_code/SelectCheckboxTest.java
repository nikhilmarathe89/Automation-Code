package com.practice.automation_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectCheckboxTest 
{
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	}
	
	@Test
	public void verifyCheckbox()
	{
		WebElement box1 = driver.findElement(By.xpath("//div[@id=\"content\"]/div/form/input[1]"));
		Assert.assertEquals(box1.isSelected(), false);
		WebElement box2 = driver.findElement(By.xpath("//div[@id=\"content\"]/div/form/input[2]"));
		Assert.assertEquals(box2.isSelected(), true);
		box1.click();
		Assert.assertEquals(box1.isSelected(), true);
		box2.click();
		Assert.assertEquals(box2.isSelected(), false);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
