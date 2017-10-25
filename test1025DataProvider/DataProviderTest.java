package com.edu.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderTest {

	@DataProvider(name = "keyw")
	public Object[][] getData() {
		return new Object[][] { { "淘宝" ,"123456"}, { "京东" ,"123457"}, { "拉手","11111" }, };
	}

	@Test(dataProvider = "keyw")
	public void searchTest(String keyWord,String s2) throws InterruptedException {
		System.out.println(keyWord+" "+s2);

	}

}
