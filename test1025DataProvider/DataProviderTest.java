package com.edu.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderTest {

	@DataProvider(name = "keyw")
	public Object[][] getData() {
		return new Object[][] { { "�Ա�" ,"123456"}, { "����" ,"123457"}, { "����","11111" }, };
	}

	@Test(dataProvider = "keyw")
	public void searchTest(String keyWord,String s2) throws InterruptedException {
		System.out.println(keyWord+" "+s2);

	}

}
