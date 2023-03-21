package faceb;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FaceBook_TestNG {
	WebDriver driver;
	String currentUrl="";
	@BeforeClass
	private void launch() {

		System.setProperty("webdriver.chrome.driver","D:\\workspace\\ipttask\\src\\main\\java\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);

		currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (title.contains(currentUrl)) {

			System.out.println("title are same");
		}else {
			System.out.println("not equal in url");
		}

	}
	@Test
	private void User_name() throws InterruptedException {

		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("mohan");

		Thread.sleep(2000);
		WebElement password =driver.findElement(By.id("pass"));
		password.sendKeys("234567");
	}
	@Test
	private void Login_click() {

		WebElement login=driver.findElement(By.name("login"));
		login.click();
	}
	@Test
	private void Screen_Shot(String name) throws IOException {

		TakesScreenshot image1=(TakesScreenshot) driver;
		File captimg=image1.getScreenshotAs(OutputType.FILE);
		String desination1=("C:\\Users\\sgowt\\eclipse-workspace\\facebook\\src\\screenshot\\"+name+".png");
		org.openqa.selenium.io.FileHandler.copy(captimg, new File(desination1));
		//nagivate window
		driver.navigate().back();
	}
	@Test
	private void Create_Account() throws InterruptedException {
		Thread.sleep(2000);
		WebElement createaccount=driver	.findElement(By.xpath("(//a[@role='button'])[2]"));
		createaccount.click();

	}
	@Test

	private void Create_acc_fillDetails() throws InterruptedException {
		Thread.sleep(2000);
		WebElement Firstname =driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		Firstname.sendKeys("mohan");

		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.sendKeys("raj");

		WebElement mobilenumber=driver.findElement(By.name("reg_email__"));
		mobilenumber.sendKeys("9876543210");
		WebElement password1=driver.findElement(By.id("password_step_input"));
		password1.sendKeys("mk099@");


		Select date=new Select(driver.findElement(By.id("day")));
		date.selectByIndex(7);


		Select month =new Select(driver.findElement(By.id("month")));
		month.selectByIndex(3);
		Select year =new Select(driver.findElement(By.id("year")));
		year.selectByIndex(67);

		WebElement gender=driver.findElement(By.xpath("//*[text()='Female']"));
		gender.click();


		WebElement signup =driver.findElement(By.xpath("(//*[text()='Sign Up'])[2]"));
		String text1 = signup.getText();
		System.out.println(text1);
		WebElement signup1 =driver.findElement(By.xpath("(//*[text()='Sign Up'])[3]"));
		String text2 = signup.getText();
		System.out.println(text2);

		if (text1.contains(text2)) {
			System.out.println("signup are equal");

			WebElement signup3 =driver.findElement(By.name("websubmit"));
			signup3.click();


		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement close=driver.findElement(By.xpath("//*[@class='_8idr img']"));
		//--------
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//img[contains(@src,'v3/yZ/r/C6QZ-pcv3Bd.png')]")).click();
		String currentUrl2 = driver.getCurrentUrl();

		//System.out.println(currentUrl2 + " " + currentUrl);

		if (currentUrl.equals(currentUrl2)) {
			System.out.println("Equal");
		}
	}
	@AfterClass

	private void Window_Close() {
		driver.close();
	}

}
