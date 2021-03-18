package script;
import java.io.File;
import java.io.FileInputStream;
//
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteExcel extends ReadExcel {
//	public static void main(String[] args) throws IOException {
//		WriteExcel write=new WriteExcel();
//		write.writeData();

	private WebDriver driver;
	private XSSFWorkbook workbook;
	private Sheet worksheet;
	XSSFRow row=null;
	XSSFCell cell=null;

	private String title;

	//WebDriver driver;
	public WriteExcel(WebDriver driver, XSSFWorkbook workbook,Sheet worksheet,String title) {
		this.driver=driver;
		this.workbook=workbook;
		this.worksheet=worksheet;
		this.title=title;
	}
 
	public  void writeData() throws IOException  {
		
		
		 try {
			 File file = new File("C:\\Users\\user\\Desktop\\Readdata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		 XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	     Sheet worksheet = workbook.getSheetAt(0);
	     worksheet.getRow(i).createCell(2).setCellValue("Status");
	    
	    	   if (title.equals("Student Dashboard | Test Maker - TestYou")) {
	    	   
	          
	    		 cell= (XSSFCell) worksheet.getRow(i).getCell(i);
	    		   cell.setCellValue("pass");
	           
	       } else {
	           
	    	    cell=(XSSFCell) worksheet.getRow(i).getCell(i);
    		   cell.setCellValue("fail");
    		   
	    	
	       }
//	    	  inputStream.close();
	    	   FileOutputStream outputStream = new FileOutputStream("C:\\Users\\user\\Desktop\\Readdata.xlsx");
	       workbook.write(outputStream);
	       
	       outputStream.close();
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }
	      
		
	       
	      
		
	}
}


