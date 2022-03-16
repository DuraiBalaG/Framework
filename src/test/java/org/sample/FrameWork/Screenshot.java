package org.sample.FrameWork;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();
		}
	@Before
	public void beforeMethod() throws IOException {
		TakesScreenshot scr = (TakesScreenshot)driver;
		File s = scr.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\screenshot\\beforead.png");
		FileUtils.copyFile(s, d);
	}
	@After
	public void afterMethod() throws IOException {
		TakesScreenshot scr = (TakesScreenshot)driver;
		File s = scr.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\screenshot\\afterad.png");
		FileUtils.copyFile(s, d);
	}
	@Test
	public void login() {
		WebElement txtUser = driver.findElement(By.id("username"));
		txtUser.sendKeys("BalaG128");
		WebElement txtPass = driver.findElement(By.id("password"));
		txtPass.sendKeys("BalajiV120898");
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
}






