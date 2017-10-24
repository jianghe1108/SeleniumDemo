package com.edu.webDriverApi2;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	WebDriver wd = null;   
	JavascriptExecutor jse=null;
	Actions action=null;
	Robot robot=null;
	ObjectMap obj=null;
	@BeforeClass
	public void setUpBrowser() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		wd = new FirefoxDriver();
		jse = (JavascriptExecutor)wd;
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		action=new Actions(wd);
		obj = new ObjectMap("conf/object.properties");
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCtrovClipBoardData(String s){
		StringSelection str=new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   robot.keyRelease(KeyEvent.VK_K);
	}
	
	public void pressTab(){
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void pressEnter(){
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	

	
	public void jsClick(WebElement element){
		jse.executeScript("arguments[0].click();", element);
		
	}
	
	public void HighLignt(WebElement element){
		setAttribute(element,"style","background:yellow;border:2 px solid red");
		}
	
	public void setAttribute(WebElement element,String attibute,String value){
		jse.executeScript("arguments[0].setAttribute(arguments[1],arguments[2]);",element,attibute,value);
		
	}
	
	@AfterClass
	public void quitBrower(){
		if(wd != null){
			wd.quit();
		}
	}

	public void screenShot(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		
		File s_file=((TakesScreenshot)wd).
				getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s_file, new File("D:\\demo\\"+nowDateTime+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean testImageCompare(String actualImage,String expectImage) throws IOException {
		

		File actualFile = new File(actualImage);
		File expectFile = new File(expectImage);
		/*
		 * 以下部分为两个文件进行像素对比的算法实现，获取文件的像素个数大小，
		 * 然后使用循环的方式将两张图的所有像素进行对比，如有任一像素不相同，则退出循环。
		 */
		BufferedImage bufileActual = ImageIO.read(actualFile);
		DataBuffer daFileActual = bufileActual.getData().getDataBuffer();
		int sizeActual = daFileActual.getSize();

		BufferedImage bufileExpect = ImageIO.read(expectFile);
		DataBuffer daFileExpect = bufileExpect.getData().getDataBuffer();
		int sizeExpect = daFileExpect.getSize();
		boolean flag = true;
		if (sizeActual == sizeExpect) {
			for (int j = 0; j < sizeActual; j++) {
				if (daFileActual.getElem(j) != daFileExpect.getElem(j)) {
					flag = false;
					break;
				}
			}
		} else
			flag = false;
		return flag;
	}
}
