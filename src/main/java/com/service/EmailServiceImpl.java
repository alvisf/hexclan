package com.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



@Service
@Transactional
public class EmailServiceImpl implements EmailService,Cloneable{
	
	

	
	public void sendMail(String toEmail,String fileName) throws Exception{
		System.out.println(fileName);
		DocumentBuilderFactory  dbf =  DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(fileName);
		
		Element rootElement = doc.getDocumentElement();
		
		String customerName = rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
		String invNo = rootElement.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
		String invDate = rootElement.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
		
		
		
		String to = toEmail;
		String from = "ezhilan03@gmail.com";
		String pass = "Ee*180999"; 
		
		String host = "smtp.gmail.com";
		 
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
	    prop.put("mail.smtp.port", "587");
		
		
	    Session session = Session.getInstance(prop,new Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		 return new PasswordAuthentication(from, pass);
	    	}
		});
	    
	    session.setDebug(true);
	    
	    try {
	    	MimeMessage msg = new MimeMessage(session);
	    	
	    	msg.setFrom(new InternetAddress(from));
	    	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	msg.setSubject("Invoice Details");
	    	
	    	
	    	StringBuilder content = new StringBuilder();
	    	content.append("Hello. This is your invoice details");
	    	content.append("<html><body>");
	    	content.append("<br>Name : "+customerName);
	    	content.append("&nbsp; &nbsp; Invoice Number : "+invNo);
	    	content.append("&nbsp; &nbsp; Invoice Date : "+invDate);
	    	
	    	content.append("<table style='border:2px solid black'>");
	    	content.append("<tr>");
	    	content.append("<th>Item No</th>");
	    	content.append("<th>Item Name </th>");
	    	content.append("<th>Price</th>");
	    	content.append("<th>Quantity</th>");
	    	content.append("<th>Amount</th>");
	    	content.append("</tr>");
	    	
			NodeList list = doc.getElementsByTagName("item");
			int length = list.getLength();
			for(int i=0;i<length;i++) {
				Node node = list.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					content.append("<tr>");
					
					String itemNo = i+1+"";
			    	content.append("<td>"+itemNo+"</td>");
			    	
					String itemName = node.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
					content.append("<td>"+itemName+"</td>");
					
					String price = node.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
					content.append("<td>"+price+"</td>");
					
					String quantity = node.getChildNodes().item(3).getChildNodes().item(0).getNodeValue();
					content.append("<td>"+quantity+"</td>");
					
					String amount = node.getChildNodes().item(4).getChildNodes().item(0).getNodeValue();
					content.append("<td>"+amount+"</td>");
				}
			}
			content.append("<tr>");
	    	content.append("<td></td>");
	    	content.append("<td></td>");
	    	content.append("<td></td>");
	    	content.append("<td>Total: </td>");
	    	content.append("<th>"+rootElement.getChildNodes().item(5).getChildNodes().item(0).getNodeValue()+"</th>");
	    	content.append("</tr>");
	    	
	    	 MimeBodyPart mimeBodyPart = new MimeBodyPart();
	         mimeBodyPart.setContent(content.toString(), "text/html");
	
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(mimeBodyPart);
	         msg.setContent(multipart);
	         
	    	Transport.send(msg);
	        System.out.println("E-mail sent successfully....");
	    }catch(Exception e) {e.printStackTrace();}
	}
}
