package com.chatak.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Base {

		public  WebDriver driver;
		public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\GSPLKLPA196\\eclipse-workspace\\ZEcommerce\\src\\main\\java\\resources\\inputdata.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{	
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\GSPLKLPA196\\Desktop\\jars\\chromedriver\\chromedriver.exe");
	 driver= new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 driver.manage().window().maximize();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 	driver= new FirefoxDriver();
	 	System.setProperty("webdriver.firefox.driver", "C:\\Users\\GSPLKLPA196\\Desktop\\jars\\Firefoxdriver\\geckodriver.exe");
		driver= new FirefoxDriver(); 
		driver.manage().window().maximize();
}
else if (browserName.equals("IE"))
{
//	IE code
}

return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
