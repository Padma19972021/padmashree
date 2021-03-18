package script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReadExcel {
	 XSSFWorkbook workbook;
	 Sheet worksheet;
//	 static WebDriver driver;
	static int i;
//	static int rowCount;
	 public static void main(String[] args) throws IOException, InterruptedException {
		 ReadData data= new ReadData();
		 data.tc();
		 
	 }
	 
	 public ArrayList<String> readExcelData(int colno) throws IOException{
		 
		 File file =    new File("C:\\Users\\user\\Desktop\\Readdata.xlsx");
		
			 FileInputStream inputStream = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		     Sheet worksheet = workbook.getSheetAt(0);
		     Iterator<Row> it=worksheet.iterator();
		     it.next();
		     ArrayList<String> list=new ArrayList<>();
		     while(it.hasNext()) {
		    	 list.add(it.next().getCell(colno).getStringCellValue());
		     }
		    	 return list;
		    	 
	 }
}
	  


