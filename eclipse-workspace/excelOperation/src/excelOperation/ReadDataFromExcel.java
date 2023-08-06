package excelOperation;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
public class ReadDataFromExcel {
    public static  void main(String args[]) throws IOException {
        //set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
 
        //Create an object of File class to open xls file
        File file =    new File("C:\\Users\\user\\Desktop\\data.xlsx");
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        
        //creating workbook instance that refers to .xls file
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        
        //creating a Sheet object
        HSSFSheet sheet=wb.getSheetAt(0);
        
        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        
       //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        //Navigate to the URL
        driver.get("https://twitter.com/LOGIN/");
 
 
        //Identify the WebElements for the student registration form
        WebElement userID=driver.findElement(By.xpath("//*[@type='text']"));
        WebElement password=driver.findElement(By.xpath("//*[@type='password']"));
 
        //iterate over all the rows in Excel and put data in the form.
        for(int i=1;i<=rowCount;i++) {
            //Enter the values read from Excel in firstname,lastname,mobile,email,address
        	userID.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
     	   password.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
            
            
            
            //Verify the confirmation message
     	  String title=driver.getTitle();
          System.out.println(title);
            
            //create a new cell in the row at index 6
            HSSFCell cell = sheet.getRow(i).createCell(2);
            
            //check if confirmation message is displayed
            if (title.equals("Twitter")) {
                // if the message is displayed , write PASS in the excel sheet
                cell.setCellValue("PASS");
                
            } else {
                //if the message is not displayed , write FAIL in the excel sheet
                cell.setCellValue("FAIL");
            }
            
            // Write the data back in the Excel file
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\user\\Desktop\\data.xlsx");
            wb.write(outputStream);
 
           
            
            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            
        }
        
        //Close the workbook
       // wb.close();
        
        //Quit the driver
       // driver.quit();
        }
}