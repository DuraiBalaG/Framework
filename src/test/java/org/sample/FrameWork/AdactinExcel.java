package org.sample.FrameWork;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinExcel {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		BaseClass1 bc = new BaseClass1();
		bc.getDriver();
		bc.loadUrl("https://adactinhotelapp.com/");
	
		WebElement id = bc.locateById("username");
		String name = bc.getData("Datas", 1, 0);
		bc.textInput(id, name);
		
		WebElement pass = bc.locateById("password");
		String pp = bc.getData("Datas", 1, 1);
		bc.textInput(pass, pp);
		
		WebElement login = bc.locateById("login");
		bc.click(login);
		
		WebElement loc = bc.locateById("location");
		bc.ddnByIndex(loc, 2);
		
		WebElement hotel = bc.locateById("hotels");

		bc.ddnByIndex(hotel, 1);
		
		WebElement room = bc.locateById("room_type");
	
		bc.ddnByIndex(room, 1);
		
		WebElement r= bc.locateById("room_nos");
		
		bc.ddnByIndex(r, 2);
		
		WebElement adult = bc.locateById("adult_room");
		
		bc.ddnByIndex(adult, 1);
		
		WebElement child = bc.locateById("child_room");
		
		bc.ddnByIndex(child, 2);
		
		WebElement element = bc.locateById("Submit");
		bc.click(element);
		
		WebElement radio = bc.locateById("radiobutton_0");
		bc.click(radio);
		
		WebElement submit = bc.locateById("continue");
		bc.click(submit);
		
		WebElement first = bc.locateById("first_name");
		String fn = bc.getData("Datas", 1, 2);
		bc.textInput(first, fn);
		
		WebElement last = bc.locateById("last_name");
		String ln = bc.getData("Datas",1,3);
		bc.textInput(last, ln);
		
		WebElement address = bc.locateById("address");
		String add = bc.getData("Datas", 1,4);
		bc.textInput(address, add);
		
		WebElement credit = bc.locateById("cc_num");
		String card = bc.getData("Datas", 1,5);
		bc.textInput(credit, card);
		
		WebElement cc = bc.locateById("cc_type");
		bc.ddnByText(cc, 1);
		
		WebElement exp = bc.locateById("cc_exp_month");
		
		bc.ddnByIndex(exp, 2);
		
		WebElement expp = bc.locateById("cc_exp_year");
		
		bc.ddnByIndex(expp, 3);
		
		WebElement cre = bc.locateById("cc_cvv");
		String cvv = bc.getData("Datas", 1,6);
		bc.textInput(cre, cvv);
		

		WebElement book = bc.locateById("book_now");
		bc.click(book);
		
		Thread.sleep(9000);
		WebElement order = bc.locateById("order_no");
		String value = bc.getAttribute(order);
		System.out.println(value);
		bc.data("Datas", 1,7, value);
		
		
	}

		
		
		
		
		
		
		
		
		
		
	
}
