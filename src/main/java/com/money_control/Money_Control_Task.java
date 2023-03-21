package com.money_control;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Money_Control_Task {
	CharSequence value;

	
	WebDriver driver;
	@BeforeClass
	private void Launch_Browesr() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}                                                 //xpath for table //div[@class='stAcbx']/div/following::div[@id='in_tgNifty']/table/tbody/tr/td
	@Test
	private void get_url() {
		driver.get("https://www.moneycontrol.com/");
	}
	@Test(dependsOnMethods ="get_url")
	private void Scroll_down()  {
	

		WebElement popup = driver.findElement(By.xpath("//div[@id='wzrk_wrapper']/div/div/button[text()='No thanks']"));
		popup.click();
	}

	@Test(dependsOnMethods ="Scroll_down")
	@Parameters("value")
	private void Find_the_valueoftable(String value) throws InterruptedException {
		//String expected=value;
		WebElement tablevalue=driver.findElement(By.xpath("//div[@class='stAcbx']/div/following::div[@id='in_tgNifty']/table/tbody/tr/td[1]/a[text()='"+value+"']"));
		String text = tablevalue.getText();
		System.out.println(text);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click",tablevalue );
//stcm

		

	

		////body[1]/div[1]/section[1]/div[1]/div[3]/aside[1]/div[11]/div[3]/div[2]/div[2]/div[1]/div[2]
		if (text.contains(value)) {
			System.out.println("done");			
			WebElement tableprice=driver.findElement(By.xpath("//div[@id='in_tgNifty']//thead/following-sibling::tbody/child::tr[4]/child::td[@class='grntxt'][2]"));
			String text2 = tableprice.getText();
			System.err.println("The percentage Gain value is :"+text2);//
	
		}
	driver.close();
	}
	
}
////div[@class='stAcbx']/div/following::div[@id='in_tgNifty']/table/tbody/tr[3]
//////++++//div[@class='stAcbx']/div/following::div[@id='in_tgNifty']/table/tbody/tr/td/a[text()='Coal India']

//}



