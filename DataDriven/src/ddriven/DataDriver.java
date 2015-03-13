package ddriven;

import java.io.File;

import jxl.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriver {

	@Test(dataProvider="DP2")
	public void mycase(String uname, String pass)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver f = new ChromeDriver();
		f.get("http://mail.in.com");
		f.findElementById("f_id").sendKeys(uname);
		f.findElementById("f_pwd").sendKeys(pass);
		f.findElementByClassName("signin").click();
		f.quit();
				
	}
	
	@DataProvider(name="DP1")
	public Object[][] testData()
	{
	
		Object [][]a={{"uname1","pass1"},{"uname2","pass2"}};
		return a;
	}
	
	
	@DataProvider(name="DP2")
	public Object[][] testData1() throws Exception
	{
	   File f = new File("G:\\TD.xls");
	   Workbook wk = Workbook.getWorkbook(f);
	   Sheet s1 = wk.getSheet(0);
	   
	   Object [][]a= new Object[s1.getRows()-1][s1.getColumns()]; // 3,2
	   
	   for(int i=1;i<s1.getRows();i++)
	   {
		   for(int j=0;j<s1.getColumns();j++)
		   {
			   Cell c1 = s1.getCell(j, i);
			   a[i-1][j]=c1.getContents();
		   }
	   }
	   
	   return a;
	}
	
	
}
