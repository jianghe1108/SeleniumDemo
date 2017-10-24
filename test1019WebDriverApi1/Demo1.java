package com.edu.webdriveApi1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver wd =null;

	@BeforeClass
	public void startUpBrowser(){
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		wd = new FirefoxDriver();
	}
	@DataProvider(name="login")
	public Object[][] getUserName(){
		Object[][] users={{"tom01","123456"},{"tom02","654321"}};
		return users;
	}
	
	@Test(dataProvider="login")
	public void testLogin(String name,String passwd){
		System.out.println(name);
		System.out.println(passwd);
		//�򿪵�¼ҳ��
		//����name��passwd
	}
	
	@Test
	public void testAddmovie() throws InterruptedException{
		wd.get("http://localhost:8032/Mymovie/admin.php");
		wd.findElement(By.name("username")).sendKeys("admin");
		wd.findElement(By.name("password")).sendKeys("admin");
		wd.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//h2[contains(.,'FolderӰƬ����')]")).click();
	 
		Thread.sleep(3000);
//		for(int i=1;i<4;i++){
			
	    wd.findElement(By.xpath("//a[@title='���ӰƬ']/span")).click();
	    Thread.sleep(3000);
		wd.findElement(By.name("filmname")).sendKeys("121212");
		wd.findElement(By.name("petname")).sendKeys("zhanlang");
		wd.findElement(By.name("director")).sendKeys("�⾩");
		wd.findElement(By.name("editor")).sendKeys("�⾩");
		wd.findElement(By.name("nation")).sendKeys("�й�");
		wd.findElement(By.name("language")).sendKeys("����");
		wd.findElement(By.name("showtime")).sendKeys("2017-11-01");
		
		wd.findElement(By.name("minutes")).sendKeys("120");
		wd.findElement(By.name("picname")).sendKeys("D:\\demo\\a.jpg");
		Thread.sleep(3000);
		
		WebElement iframe =wd.findElement(By.xpath("//iframe"));
		Actions action =new Actions(wd);
		action.sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB);
		action.sendKeys("hello").perform();
		action.sendKeys(Keys.TAB);
		action.sendKeys(Keys.ENTER).perform();
		
		wd.switchTo().frame(iframe);
		wd.findElement(By.tagName("body")).sendKeys("ս�ǵ�ӰƬ����");
//		wd.switchTo().defaultContent();

//		List<WebElement> list = wd.findElements(By.tagName("iframe"));
//		System.out.println(list.size());
		
		wd.findElement(By.xpath("//button[@type='submit']"));

//		}
	}
		
		@Test
		public void testBrowser() throws InterruptedException{
			
			wd.navigate().to("http://localhost:8032/Mymovie");
			wd.findElement(By.linkText("ע��")).click();
			assertEquals(wd.getTitle(), "ע��Mymovie");
			wd.manage().window().maximize();
			//��ȡ��ҳ��htmlԴ����
			System.out.println(wd.getPageSource());
			//��ȡ��ǰҳ���URL
			System.out.println(wd.getCurrentUrl());
			
			Thread.sleep(5000);
			//������ĺ���
			wd.navigate().back();
			Thread.sleep(5000);
			//���������ǰ
			wd.navigate().forward();
			Thread.sleep(5000);
			//�����ˢ��
			wd.navigate().refresh();
			
		}
		
	

	@Test 
	public void  testMultiWindow(){
		wd.get("http://localhost:8032/MyMovie/");
		JavascriptExecutor  js= (JavascriptExecutor)wd;
		js.executeScript("window.open('https://www.baidu.com/')");
		Set<String> windows=wd.getWindowHandles();
		for(String s:windows){
			System.out.println(s);
			boolean flag = wd.switchTo().window(s).getTitle().contains("�ٶ�");
			if(flag){
				wd.findElement(By.id("kw")).sendKeys("selenium");
				break;
			}
			//wd.close();
			wd.quit();
			
		}
	}
		
	
		@Test
		public void control(){
			wd.get("http://localhost:8032/MyMovie/");
			wd.findElement(By.name("key")).sendKeys("hello");
			wd.findElement(By.xpath("//input[@type='submit']")).submit();
		
		}
		@Test
		public void testSelect(){
			wd.get("http://localhost:8032/test/0601.html");
			Select f=new Select(wd.findElement(By.name("fruit")));
			WebElement w =f.getFirstSelectedOption();
			//getFirstSelectedOption(); ��ȡ��ǰ��ѡ����
			System.out.println(w.getText());
			//���������ѡ��ʽ������:index,value,�ı���Ϣ��ע������ֵ��0��ʼ
			f.selectByIndex(1);
			f.selectByVisibleText("4����");
		
		}
		
		@Test
		public void testMulSelect(){
			List<String> expect=Arrays.asList(new String[]{"1�˶�","2�Ķ�"});
			
			wd.get("http://localhost:8032/test/0601.html");
			Select f=new Select(wd.findElement(By.name("hobby")));
			f.selectByValue("sport");
			f.selectByValue("reading");
			List<WebElement> actual=f.getAllSelectedOptions();
			for(WebElement w :actual){
				System.out.println(w.getText());
			}
			
			assertEquals(actual.toArray(), expect.toArray());
		
		}
	
		@Test
		public void testRadio(){
			wd.get("http://localhost:8032/test/0601.html");
			wd.findElement(By.xpath("//input[@value='watermelon']")).click();
		  
			boolean status=
					wd.findElement(By.xpath("//input[@value='orange']")).isSelected();
		    System.out.println(status);
			assertTrue(status);
		
		
		}
	
		@Test
		public void testFrame(){
			wd.get("http://localhost:8032/test/frame.html");
			System.out.println("��ҳ�棺"+this.wd.getTitle());
			//�����һ��frame
			wd.switchTo().frame(0);
			String s1 = wd.findElement(By.tagName("p")).getText();
			System.out.println(s1);
			wd.switchTo().defaultContent();
			
			System.out.println("��ҳ�棺"+this.wd.getTitle());
			
			wd.switchTo().frame("middleframe");
			String s2 = wd.findElement(By.tagName("p")).getText();
			System.out.println(s2);
			wd.switchTo().defaultContent();
			
			List<WebElement> list = wd.findElements(By.tagName("frame"));
			System.out.println(list.size());
		}


	
}
