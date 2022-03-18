package beershop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class UC_1001_System {

	@Test
	void TC_1001_system_test() throws InterruptedException {
		WebDriver driver = null;
		String browser = "firefox";
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ITPHONE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ITPHONE\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		    driver.get("http://localhost/beershop/index.php/Welcome/login/1");
		  
		    
			String result = driver.findElement(By.id("nametitle")).getText();
			assertEquals("Tidnueb Login ",result);
			System.out.println("open web Finish!!!");
			
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).sendKeys("0983203391");
		    {
		      WebElement element = driver.findElement(By.cssSelector(".btn"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    driver.findElement(By.cssSelector(".btn")).click();
		    Thread.sleep(4000);
		    
			String logins = driver.findElement(By.id("logintitles")).getText();
			assertEquals("เข้าสู่ระบบสำเร็จ",logins);
			System.out.println("Login Finish!!!");
			
			
			Thread.sleep(4000);
			
			
		    driver.findElement(By.id("loginsucess")).click();
		    
		    Thread.sleep(4000);
		    
		    
		    driver.findElement(By.cssSelector(".col-lg-3:nth-child(1) .card-button")).click();
		    
			String cart =   driver.findElement(By.cssSelector("td:nth-child(2)")).getText();
			assertEquals("ผัดไทกุ้งสด",cart);
					    		 
		    
		    driver.findElement(By.linkText("<< ย้อนกลับ")).click();
		    
		    driver.findElement(By.cssSelector(".col-lg-3:nth-child(2) .card-button")).click();
			String carts =   driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText();
			assertEquals("ชุดเบียร์ช้าง",carts);
			
			String alltotal =   driver.findElement(By.cssSelector(".alltotal")).getText();
			assertEquals("รวมทั้งหมด   160 บาท",alltotal);
			
			System.out.println(cart + " " + carts +" "+ alltotal );
			System.out.println("add cart Finish!!!");
			
		    driver.findElement(By.linkText("บันทึกรายการสั่งซื้อ>>")).click();
		    driver.findElement(By.linkText("ยืนยัน")).click();
		    
		    String bill = driver.findElement(By.id("titlebill")).getText();
			assertEquals("ใบเสร็จเก็บเงิน",bill);
			
			
			String menu1 = driver.findElement(By.cssSelector("tbody > tr:nth-child(1) > .text-left > .font-weight-bold")).getText();
			assertEquals(cart,menu1);			
			String menu2 =  driver.findElement(By.cssSelector("tr:nth-child(2) > .text-left > .font-weight-bold")).getText();
			assertEquals(carts,menu2);
			
			String total = driver.findElement(By.cssSelector("tr:nth-child(3) > .text-right > .font-weight-bold")).getText();
			assertEquals("160 บาท",total);
			System.out.println(menu1 + " " + menu2 +" "+ total );		
			System.out.println("bill Finish!!!");	
		    
		    driver.findElement(By.id("endcart")).click();
		    
		    Thread.sleep(4000);
		    
			String logout = driver.findElement(By.id("logouttitle")).getText();
			assertEquals("ออกจากระบบเเล้ว",logout);
			System.out.println("logout Finish!!!");	
		    
		  //  driver.findElement(By.cssSelector(".button")).click();
		    driver.findElement(By.id("userlogout")).click();
		
		 

//			String result = driver.findElement(By.id("registerpass")).getText();
//			assertEquals("คุณลงทะเบียนเสร็จเรียบร้อยแล้ว",result);
			Thread.sleep(4000);
			driver.close();
			System.out.println("Finish !!!");
	}
	

}
