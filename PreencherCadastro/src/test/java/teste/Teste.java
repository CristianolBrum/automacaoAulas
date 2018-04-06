package teste;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




	public class Teste {

		static WebDriver driver;
		@Before
		public void setUp(){
			
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.juliodelima.com.br/taskit");
			
		}
		
		@Test
		public void test() {
			driver.findElement(By.linkText("Sign in")).click();
			WebElement formularioSignBox = driver.findElement(By.id("signinbox"));
			formularioSignBox.findElement(By.name("login")).sendKeys("powerguidissimo");
			formularioSignBox.findElement(By.name("password")).sendKeys("cri123");
			driver.findElement(By.linkText("SIGN IN")).click();
			driver.findElement(By.className("me")).click();
			driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
			driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
			WebElement popoupAddMoreData = driver.findElement(By.id("addmoredata"));
			WebElement escolhaType = driver.findElement(By.name("type"));
			new Select(escolhaType).selectByVisibleText("Phone");
			popoupAddMoreData.findElement(By.name("contact")).sendKeys("+5565999981212");
			popoupAddMoreData.findElement(By.linkText("SAVE")).click();
			WebElement mensagemPopup = driver.findElement(By.id("toast-container"));
			String mensagem = mensagemPopup.getText();
			Assert.assertEquals(mensagem, "Your contact has been added!");
			
			
			
		}
		

		@After
		public void tearDown() throws Exception {
			//driver.quit();
		}
		
		

	}



