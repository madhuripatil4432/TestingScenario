package tests;


	

	

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import resources.Base;
import org.testng.annotations.Test;

	public class DemoTest extends Base {
         @Test
		public  void login() {
			String modulevalue="Add Customer";
			try {
				//Open Browser and navigate to URL and Maximize the page
				WebDriver d = initializeDriver();
				
				d.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
				d.manage().window().maximize();
				
				Thread.sleep(1000);
				//Click On Bank Manager Login
				WebElement bmlogin= d.findElement(By.xpath("//button[text()='Bank Manager Login']"));
				bmlogin.click();
				Thread.sleep(1000);
				//Validate Bank Manager Login Page Opened
				Assert.assertEquals(d.getCurrentUrl().contains("manager"), true);
				
				Thread.sleep(1000);
				//Click On Add Customer Button
				WebElement addcustomerbutton= d.findElement(By.xpath("//button[contains(text(),'"+modulevalue+"')]"));
				addcustomerbutton.click();
				
				Thread.sleep(1000);
				//Entered First Name
				WebElement firstnamefield= d.findElement(By.xpath("//label[contains(text(),'First Name :')]/following-sibling::input"));
				firstnamefield.sendKeys("Mathew");
				String firstnamefieldvalue= firstnamefield.getAttribute("value");
				//Entered Last Name
				WebElement lastnamefield= d.findElement(By.xpath("//label[contains(text(),'Last Name :')]/following-sibling::input"));
				lastnamefield.sendKeys("Rob");
				//Entered Post Code
				WebElement postcodefield= d.findElement(By.xpath("//label[contains(text(),'Post Code :')]/following-sibling::input"));
				postcodefield.sendKeys("Post MathewRob21");
				
				//click on Add customer button
				WebElement addcutomer= d.findElement(By.xpath("//button[text()='Add Customer']"));
				addcutomer.click();
				
				Thread.sleep(1000);
				//Handle Successful message Alert
				Alert alt= d.switchTo().alert();
				String successalertText=alt.getText();
				Thread.sleep(1000);
				Assert.assertEquals(successalertText.contains("Customer added successfully"), true);
				alt.accept();
				Thread.sleep(1000);
				
				//Click on Customer Button
				WebElement customerbutton= d.findElement(By.xpath("//button[contains(text(),'Customers')]"));
				customerbutton.click();
				
				//Search with the created user
				WebElement searchfield= d.findElement(By.xpath("//div[@class='input-group-addon']/following-sibling::input"));
				searchfield.click();
				searchfield.sendKeys(firstnamefieldvalue);
				
				
				//Validated user created
				WebElement firstnamevalue= d.findElement(By.xpath("//table//tbody//td[text()='"+firstnamefieldvalue+"']"));
				Assert.assertEquals(firstnamevalue.getText(), "Mathew");
				
				Thread.sleep(1000);
				//Click On Account
				WebElement openaccount= d.findElement(By.xpath("//button[contains(text(),'Open Account')]"));
				openaccount.click();
				Thread.sleep(1000);
				//Select user
				WebElement userselect=d.findElement(By.id("userSelect"));
				Select sel = new Select(userselect);
				Thread.sleep(1000);
				sel.selectByVisibleText("Mathew Rob");
				
				Thread.sleep(1000);
				//Selct Currency
				WebElement currency=d.findElement(By.id("currency"));
				Select sel2 = new Select(currency);
				Thread.sleep(1000);
				sel2.selectByVisibleText("Pound");
				
				Thread.sleep(1000);
				//CLick on Process Button
				WebElement processbutton= d.findElement(By.xpath("//button[contains(text(),'Process')]"));
				processbutton.click();
				
				Thread.sleep(1000);
				//Handle createdaccount alert
				Alert alt2= d.switchTo().alert();
				String accountcreatealertText=alt2.getText();
				Thread.sleep(1000);
				Assert.assertEquals(accountcreatealertText.contains("Account created successfully"), true);
				alt2.accept();
				
				Thread.sleep(1000);
				//Close the browser
				d.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				

		}

		

	}



