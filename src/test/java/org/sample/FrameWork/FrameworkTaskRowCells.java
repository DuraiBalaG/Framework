package org.sample.FrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkTaskRowCells {
//insert value
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Book1.xlsx");
//	FileInputStream stream = new FileInputStream(file);
//	Workbook wb = new XSSFWorkbook(stream);
//	Sheet sheet = wb.getSheet("Datas");
//	Row row = sheet.getRow(1);
//	Cell cell = row.getCell(0);
//	String data = cell.getStringCellValue();
//	if (cell.equals("durai")) {
//		cell.setCellValue("sathan");
//	}
//	FileOutputStream fos = new FileOutputStream(file);
//	wb.write(fos);
//
//}
//}
//create cell,insert value
//public static void main(String[] args) throws IOException {
//File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Book1.xlsx");	
//	FileInputStream stream = new FileInputStream(file);
//	Workbook wb2 = new XSSFWorkbook(stream);
//	Sheet sheet = wb2.getSheet("datas");
//	Row row = sheet.createRow(7);
//	Cell cell = row.createCell(0);
//	cell.setCellValue("welcome");
//	FileOutputStream out = new FileOutputStream(file);
//	wb2.write(out);
//}
//}
//	createsheet,row,cell,insert value
//public static void main(String[] args) throws IOException {
//File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Book3.xlsx");
//	Workbook wb3 = new XSSFWorkbook();
//	Sheet sheet = wb3.createSheet("s1");
//	Row row = sheet.createRow(0);
//	Cell cell = row.createCell(0);
//	cell.setCellValue("welcome");
//	FileOutputStream st = new FileOutputStream(file);
//	wb3.write(st);
//}
//}
//	create workbook,sheet,row,cell,insert value
//public static void main(String[] args) throws IOException {
//	File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\Excel1");
//	Workbook wb4 = new XSSFWorkbook();
//	Sheet sheet = wb4.createSheet("sh1");
//	Row row = sheet.createRow(0);
//	Cell cell = row.createCell(0);
//	cell.setCellValue("Bala");
//	FileOutputStream st1 = new FileOutputStream(file);
//	wb4.write(st1);
//}
//}	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.get("http://demo.automationtesting.in/Register.html");
		WebElement skl = dr.findElement(By.id("Skills"));
		Select select = new Select(skl);
		List<WebElement> list = select.getOptions();
		
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Book1.xlsx");
		Workbook wb5 = new XSSFWorkbook();
		Sheet sheet = wb5.createSheet("Sheet12");
		
		int i=0;
		for (WebElement wb :list){
			String text = wb.getText();
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
			i++;
			
		}
		FileOutputStream fos = new FileOutputStream(file);
		wb5.write(fos);
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	