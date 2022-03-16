package org.sample.FrameWork;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	WebDriver driver;
	public void getDriver() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public WebElement locateById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public WebElement locateByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	
	public WebElement locateByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}
	
	public WebElement locateByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	
	public String getText(WebElement element) {
		String value = element.getText();
		return value;
	}
	
	public String getAttribute(WebElement element) {
	    String attribute = element.getAttribute("value");
	    return attribute;
	}
	
	public String title() {
		String title = driver.getTitle();
		return title;
	}
	
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public void textInput(WebElement element,String inputData) {
		element.sendKeys(inputData);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void toUrl(String urlData) {
		driver.navigate().to(urlData);
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void forward() {
		driver.navigate().forward();
	}
	
	public void backward() {
		driver.navigate().back();
	}
	
	public void closeBrowser() {
	  driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	private void robotKeyPress(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(key);
	}
	
	private void robotKeyRelease(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(key);
	}
	
	private void keyDown(CharSequence keys) {
		Actions actions = new Actions(driver);
		actions.keyDown(keys).perform();
	}
	
	private void keyUp(CharSequence keys) {
		Actions actions = new Actions(driver);
		actions.keyUp(keys).perform();
	}
	
	private File screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		return file;
	}
	
	private void saveScreenshot(String Url) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		File file2 = new File(Url);
		FileUtils.copyFile(file, file2);

	}
	
	public void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void frameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void frameById(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void getOutFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void foToInnerFrame() {
		driver.switchTo().parentFrame(); 
	}
	
	public void ddnByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void ddnByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void ddnByText(WebElement element,int i) {
		Select s = new Select(element);
		s.selectByIndex(i);
	}
	
	public void createByJs(WebElement element,String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value',"+text+")", element);
	}
	
	public void clickInJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
	
	public void returnJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return arguments[0].getAttribute('value')", element);
	}
	
	public void downJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void upJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	
	
	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	public WebElement firstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	public void deselectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	public void deselectByText(WebElement element,String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	public void deselectByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}
	public void simpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public void confirmAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	
	public void promptAlert(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);
	}
	
	public String getData(String sheetName,int rowIndex,int cellIndex) throws IOException {
		
		String value =null;
        File f  = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Adactin Excel Sheet.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		CellType type = cell.getCellType();
		
		switch (type) {
		case STRING:
			
			value = cell.getStringCellValue();
			
			break;
        case NUMERIC:
			
        	if (DateUtil.isCellDateFormatted(cell)) {
        		
        		Date date = cell.getDateCellValue();
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        		 dateFormat.format(date);
        	
				
			} else {

            	double d = cell.getNumericCellValue();
            	BigDecimal bigDecimal = BigDecimal.valueOf(d);
            	
            	value = bigDecimal.toString();
        
			}
default:
	break;

		}
		return value;
		

	}
	    public void excelWrite(String sheetName,int rowIndex,int cellIndex,String value) throws IOException {
		    File f  = new File("C:\\Users\\HP\\Documents\\adactin details.xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fin);
			Sheet sheet = w.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.createCell(cellIndex);
			cell.setCellValue(value);
			FileOutputStream fout = new FileOutputStream(f);
			w.write(fout);

	}
	   
	    public void updateData(String sheetName,int rowNo,int cellNo,String oldData,String newData) throws IOException {
			
	    	    File f  = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Adactin Excel Sheet.xlsx");
				FileInputStream fin = new FileInputStream(f);
				Workbook w = new XSSFWorkbook(fin);
				Sheet sheet = w.getSheet(sheetName);
				Row row = sheet.getRow(rowNo);
				Cell cell = row.getCell(cellNo);
				String cellValue = cell.getStringCellValue();
				if (cellValue.equals(oldData)) {
					cell.setCellValue(newData);
				}
				FileOutputStream fout = new FileOutputStream(f);
				w.write(fout);
				
		}
	    public void writeData(String sheetName,int rowNo,int cellNo,String data) throws IOException {
			
	    	File f  = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Adactin Excel Sheet.xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fin);
			Sheet sheet = w.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = row.createCell(cellNo);
			cell.setCellValue(data);
			FileOutputStream fout = new FileOutputStream(f);
			w.write(fout);
		}
	public void data(String sheetName,int rowNo,int cellNo, String data) throws IOException {
		
		
		File f  = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\excel\\Adactin Excel Sheet.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
	    Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		
		FileOutputStream out = new FileOutputStream(f);
		w.write(out);
	}
	
	
	
	
	
	
}





