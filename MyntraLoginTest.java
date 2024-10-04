package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Scanner;

public class MyntraLoginTest {

	WebDriver driver; // Instance variable for WebDriver

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();

		// Initialize Chrome browser
		driver = new ChromeDriver(); // Use the instance variable here
		
		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
	}

	@Test
	public void otpLoginTest() throws InterruptedException {
		// Click on the 'Profile' icon
		WebElement profileIcon = driver.findElement(By.xpath("//span[text()='Profile']"));
		profileIcon.click();

		// Click on the 'Log In' option
		WebElement loginOption = driver.findElement(By.xpath("//a[normalize-space()='login / Signup']"));
		loginOption.click();

		// Wait for the login popup to appear
		Thread.sleep(2000); 

		// Enter the valid mobile number
		WebElement mobileNumberField = driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']"));
		mobileNumberField.sendKeys("9892469327");

		// Click the "Continue" button
		WebElement continueButton = driver.findElement(By.xpath("//div[text()='CONTINUE']"));
		continueButton.click();

		// Wait for the OTP input field to appear
		Thread.sleep(2000); 

		// Prompt user to enter the OTP manually
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the OTP sent to your mobile: ");
		String otp = scanner.nextLine();

		// Enter the OTP
		WebElement otpField = driver.findElement(By.xpath("//input[@type='tel']"));
		otpField.sendKeys(otp);

		// Wait for login to complete
		Thread.sleep(3000); 

	}

	@AfterTest
	public void teardown() throws InterruptedException {
		
		// Close the browser after the test
		if (driver != null) { // Check if driver is initialized
			Thread.sleep(1000); 
			driver.quit();
		}
	}
}
