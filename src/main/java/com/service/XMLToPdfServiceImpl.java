package com.service;

import java.io.File;
import java.io.FileOutputStream;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Service
@Transactional
public class XMLToPdfServiceImpl implements XMLToPdfService{
	@Override
	public void convert(String fileName) throws Exception{
		
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(fileName);
		
		Element rootElement = doc.getDocumentElement();
		
		com.itextpdf.text.Document pdfDoc = new com.itextpdf.text.Document();
		PdfWriter writer = PdfWriter.getInstance(pdfDoc, new FileOutputStream(System.getProperty("user.home")+"/Downloads/invoice.pdf"));
		pdfDoc.open();
		
		String customerName = rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
		String invNo = rootElement.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
		String invDate = rootElement.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
		
		Font myFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		Paragraph header = new Paragraph("Customer name: "+customerName +"  Bill no: "+invNo+"  Bill date: "+invDate ,myFont);
		pdfDoc.add(header);
		
		PdfPTable table = new PdfPTable(5);
		
		table.addCell("S.no");
		table.addCell("Item name");
		table.addCell("Price");
		table.addCell("Quantity");
		table.addCell("Amount");
		
		NodeList list = doc.getElementsByTagName("item");
		int length = list.getLength();
		for(int i=0;i<length;i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				String itemNo =(i+1)+"";
				table.addCell(itemNo);
				String itemName = node.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
				table.addCell(itemName);
				String price = node.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
				table.addCell(price);
				String quantity = node.getChildNodes().item(3).getChildNodes().item(0).getNodeValue();
				table.addCell(quantity);
				String amount = node.getChildNodes().item(4).getChildNodes().item(0).getNodeValue();
				table.addCell(amount);
			}
		}
		System.out.println();
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("Total : ");
		table.addCell(rootElement.getChildNodes().item(5).getChildNodes().item(0).getNodeValue());
		
		pdfDoc.add(table);
		System.out.println("pdf is created");
		pdfDoc.close();
		writer.close();
	}
}
