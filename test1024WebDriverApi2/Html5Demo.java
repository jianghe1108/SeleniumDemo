package com.edu.webDriverApi2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Html5Demo  extends BaseTest{
	
	@Test
	public void testVideo(){
		wd.get("http://www.w3school.com.cn/tiy/t.asp?f=html5_video");
	
		wd.switchTo().frame("i");
		WebElement vedio=wd.findElement(By.tagName("video"));
		String videoSrc=(String)jse.executeScript("return arguments[0].currentSrc", vedio);
		System.out.println(videoSrc);
		//http://www.w3school.com.cn/i/movie.ogg
		
		
	}
	
	@Test
	public void testCavas() throws InterruptedException{
		wd.get("http://literallycanvas.com/");
		WebElement element =wd.findElement(By.xpath("//*[@id='literally-canvas']/div[1]/div[1]/canvas[2]"));
		action.clickAndHold(element).moveByOffset(80, 30).moveByOffset(20, 50).release().perform();
		Thread.sleep(5000);
	}

}
