package script;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadData extends ReadExcel{
     WebDriver driver;
  
	@SuppressWarnings("deprecation")
	public void tc() throws IOException, InterruptedException {
		
		int flag=0;
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");  
    WebDriver driver=new ChromeDriver();  
    driver. get("http://www.testyou.in/Login.aspx"); 

    ArrayList<String> userID=readExcelData(0);
    ArrayList<String> password=readExcelData(1);
    for(int i=0;i<userID.size();i++) {

    	 driver.findElement(By.xpath("//*[@name='ctl00$CPHContainer$txtUserLogin']")).clear();
	   driver.findElement(By.xpath("//*[@name='ctl00$CPHContainer$txtUserLogin']")).sendKeys(userID.get(i));
	   driver.findElement(By.xpath("//*[@name='ctl00$CPHContainer$txtPassword']")).clear();
	   driver.findElement(By.xpath("//*[@name='ctl00$CPHContainer$txtPassword']")).sendKeys(password.get(i));
	   
	   WebElement button=  driver.findElement(By.xpath("//*[@name='ctl00$CPHContainer$btnLoginn']"));
	   Thread.sleep(3000);
      button.click();
      Thread.sleep(3000);
      String title=driver.getTitle();
     
      System.out.println(title);
      WriteExcel write=new WriteExcel(driver, workbook, worksheet,title);
		write.writeData();
  		   
    	     try {  
      driver.findElement(By.xpath("//a[@id='ctl00_headerTopStudent_lnkbtnSignout']")).click();
     
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    
  }
	
	
	
	}
	}
