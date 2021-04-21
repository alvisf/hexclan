package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


@Service
@Transactional
public class XMLToExcelServiceImpl implements XMLToExcelService {
	private static XSSFWorkbook workbook;
	
	public XMLToExcelServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void createFile(String sheetName) throws Exception{
		workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		CellStyle style = workbook.createCellStyle();
        Font myFont = workbook.createFont();
        myFont.setFontName("Courier New");
        style.setFont(myFont);
     
	}
	
	@Override
	public void writeData(String fileName) throws Exception{
		
		createFile(fileName);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(fileName);
		
		
		Element rootElement = doc.getDocumentElement();
		
		int rowCount=0;
		Row header = sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Customer Name:");
		header.createCell(1).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
		header.createCell(2).setCellValue("Bill no:");
		header.createCell(3).setCellValue(Integer.parseInt(rootElement.getChildNodes().item(1).getChildNodes().item(0).getNodeValue()));
		header.createCell(4).setCellValue("Bill date:");
		header.createCell(5).setCellValue(rootElement.getChildNodes().item(2).getChildNodes().item(0).getNodeValue());

		Row top = sheet.createRow(rowCount++);
		top.createCell(0).setCellValue("S.no");
		top.createCell(1).setCellValue("Item name");
		top.createCell(2).setCellValue("Price");
		top.createCell(3).setCellValue("Quantity");
		top.createCell(4).setCellValue("Amount");
		
		List<List> arr = new ArrayList<>();
		
		NodeList list = rootElement.getElementsByTagName("item");
		int length = list.getLength();
		for(int i=0;i<length;i++) {
			List l = new ArrayList<>();
			Node n = list.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				int sno=i+1;
				l.add(sno);
				String customerName = n.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
				l.add(customerName);
				double price = Double.parseDouble(n.getChildNodes().item(2).getChildNodes().item(0).getNodeValue());
				l.add(price);
				int quantity = Integer.parseInt(n.getChildNodes().item(3).getChildNodes().item(0).getNodeValue());
				l.add(quantity);
				double amount = Double.parseDouble(n.getChildNodes().item(4).getChildNodes().item(0).getNodeValue());
				l.add(amount);
				
				arr.add(l);
			}
		}
		for(List l:arr) {
			int listLength = l.size();
			Row row = sheet.createRow(rowCount++);
			Iterator iter = l.iterator();
			int count=0;
			while(iter.hasNext()) {
				Object obj = iter.next();
				if(obj instanceof String) {
					row.createCell(count++).setCellValue((String)obj);
				}
				else if(obj instanceof Integer) {
					row.createCell(count++).setCellValue((Integer)obj);
				}
				else if(obj instanceof Double) {
					row.createCell(count++).setCellValue((Double)obj);
				}
			}
		}
		Row bottom = sheet.createRow(rowCount++);
		bottom.createCell(0).setCellValue("");
		bottom.createCell(1).setCellValue("");
		bottom.createCell(2).setCellValue("");
		bottom.createCell(3).setCellValue("Total: ");
		bottom.createCell(4).setCellValue(rootElement.getChildNodes().item(5).getChildNodes().item(0).getNodeValue());
		
		try(FileOutputStream fos = new FileOutputStream(System.getProperty("user.home")+"/Downloads/invoice.xlsx");){
			workbook.write(fos);
			workbook.close();
			fos.close();
			System.out.println("file writtend successfully");
		}		
		
	}
}
