package hw2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork2 {

	WebDriver driver;

	By userNameField = By.xpath("//input[@id='username']");
	By passWordField = By.xpath("//input[@id='password']");
	By signinButtonField = By.xpath("//button[@name='login']");
	By dashboardHeaderField = By.xpath("//div[@class='row wrapper white-bg page-heading']/div/h2");
	By customerField = By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]");

	By addCustomerField = By.xpath("//ul[@id='side-menu']/li[3]/ul/li[1]/a");
	By addContactField = By.xpath("//div[@class='col-md-12']/div/div/h5");
	By fullNameField = By.xpath("//input[@id='account']");
	By companyDropdownField = By.xpath("//select[@id='cid']");
	By emailField = By.xpath("//input[@id='email']");
	By phoneField = By.xpath("//input[@id='phone']");
	By adressField = By.xpath("//input[@id='address']");
	By cityField = By.xpath("//input[@id='city']");
	By stateField = By.xpath("//input[@id='state']");
	By postalCodeField = By.xpath("//input[@id='zip']");
	By countryDropdownField = By.xpath("//select[@id='country']");
	By tagField = By.xpath("//select[@id='tags']");
	By currencyDropdownField = By.xpath("//select[@id='currency']");
	By groupDropdownField = By.xpath("//select[@id='group']");
	By passwordField = By.xpath("//input[@id='password']");
	By confirmPasswordField = By.xpath("//input[@id='cpassword']");
	By submitField = By.xpath("//button[@id='submit']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void login() throws InterruptedException {

		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passWordField).sendKeys("abc123");
		driver.findElement(signinButtonField).click();

		Assert.assertEquals("Dashboard not found!!", "Dashboard", driver.findElement(dashboardHeaderField).getText());
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customerField));
		driver.findElement(customerField).click();
		driver.findElement(addCustomerField).click();

		Assert.assertEquals("Add Contact not found!!", "Add Contact", driver.findElement(addContactField).getText());
		driver.findElement(fullNameField).sendKeys("Mekedelawit Asfaw");

		Select sel = new Select(driver.findElement(companyDropdownField));
		sel.selectByValue("6");
		driver.findElement(emailField).sendKeys("abcd@gmail.com");
		driver.findElement(phoneField).sendKeys("123-123-1223");
		driver.findElement(adressField).sendKeys("123 abcde");
		driver.findElement(cityField).sendKeys("Addis Ababa");
		driver.findElement(stateField).sendKeys("Addis Ababa");
		driver.findElement(postalCodeField).sendKeys("12345");

		Select sel2 = new Select(driver.findElement(countryDropdownField));
		sel2.selectByVisibleText("Ethiopia");

		Select sel3 = new Select(driver.findElement(tagField));
		sel3.selectByValue("IT Training");

		Select sel4 = new Select(driver.findElement(currencyDropdownField));
		sel4.selectByValue("4");

		Select sel5 = new Select(driver.findElement(groupDropdownField));
		sel5.selectByVisibleText("Selenium");

		driver.findElement(passwordField).sendKeys("abc123456");
		driver.findElement(confirmPasswordField).sendKeys("abc123456");
		driver.findElement(submitField).click();
	}

	//@After
	//public void teardown() throws InterruptedException {
		//Thread.sleep(5000);
		//driver.close();	
		//driver.quit();
}
//}
