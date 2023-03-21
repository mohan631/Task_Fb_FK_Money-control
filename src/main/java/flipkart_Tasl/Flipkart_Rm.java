package flipkart_Tasl;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Rm {
	public	WebDriver driver;

	@Test(priority = 1)
	private void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
	}
	@Test(priority = 2)
	private void popup_Handle() {


		WebElement poup=driver.findElement(By.xpath("//button[text()='✕']"));
		poup.click();
	}
	@Test(priority = 3)
	private void Saerch_product() {


		WebElement srbox =driver.findElement(By.name("q"));
		srbox.sendKeys("ipad");
		WebElement search_box_click=driver.findElement(By.xpath("//button[@type='submit']"));
		search_box_click.click();

	}
	@Test(priority = 4)
	private void click_connectivity() throws Throwable {
		Thread.sleep(2000);
		JavascriptExecutor js =( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");

		WebElement click_connetivity = driver.findElement(By.xpath("//div[text()='Connectivity']"));
		click_connetivity.click();

		WebElement click_wifi = driver.findElement(By.xpath("//div[text()='Wi-Fi Only']"));
		click_wifi.click();

	}

	@Test(priority = 5)
	private void First_produc() {
		WebElement click_First_product = driver.findElement(By.xpath("//div[@data-id='TABGJ6XUJXQVHKV7']//child::div/a"));
		click_First_product.click();
	}
	@Test(priority = 6)
	private void Window_handling() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		driver.switchTo().window(windowHandles.toArray()[0].toString());
	}
	@Test(priority = 7)
private void Add_to_cart() {
	WebElement click_First_product = driver.findElement(By.name("domain"));
	click_First_product.click();
}
	@Test(priority = 8)
private void Send_emailvalue() {
	WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
	email.sendKeys("sidisd");
}






}



