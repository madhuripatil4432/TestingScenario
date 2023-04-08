package resources;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	WebDriver d;
	public WebDriver initializeDriver() throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
		
	String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		
		
		WebDriverManager.chromedriver().setup();
		
		 d = new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		 d = new FirefoxDriver();
		
	}else if(browserName.equalsIgnoreCase("ie")) {
		
		WebDriverManager.iedriver().setup();
		 d = new InternetExplorerDriver();
		
	}
	
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	return d;
	
	}}
	
	