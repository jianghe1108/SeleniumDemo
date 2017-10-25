package com.edu.test1025Table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
	private WebElement _table;
	public Table(WebElement table){
		this._table=table;
	}
	
	//��ȡ��������
	public int getRowsSize(){
		List<WebElement>  rows=_table.findElements(By.tagName("tr"));
	    return rows.size();
	
	}
	
	
	//��ȡ��������
	public int getColsSize(){
		List<WebElement>  rows=_table.findElements(By.tagName("tr"));
		List<WebElement>  cols=rows.get(0).findElements(By.tagName("td"));
		return cols.size();
	
	}
	
	
	//��ȡ��n�е�m�еĵ�Ԫ����Ϣ
	public String getCell(int n,int m){
		List<WebElement>  rows=_table.findElements(By.tagName("tr"));
		List<WebElement>  cols=rows.get(n-1).findElements(By.tagName("td"));
		return cols.get(m-1).getText();
		
	}
	
	
	//��ȡn�е�m�еĵ�Ԫ��Ԫ��
	public WebElement getCellBy(int n,int m,By by){
		List<WebElement>  rows=_table.findElements(By.tagName("tr"));
		List<WebElement>  cols=rows.get(n-1).findElements(By.tagName("td"));
		WebElement cellInput=cols.get(m-1).findElement(by);
		return cellInput;
	}
	
	

}
