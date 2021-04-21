/*
package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.service.InvoiceService;
import com.service.InvoiceServiceImpl;
import com.service.ShoppingService;
import com.service.ShoppingServiceImpl;


public class ProductList extends TagSupport{
	@Override
	public int doEndTag() throws JspException {
		int count=0;
		JspWriter out=pageContext.getOut();	
		
		HttpSession session = pageContext.getSession();
		ShoppingService shoppingService = (ShoppingService)ShoppingServiceImpl.getShoppingServiceImpl();
		List<ItemDetailsDTO> items=(ArrayList<ItemDetailsDTO>)session.getAttribute("items");
		
		
		String uName =(String) session.getAttribute("uname");
		InvoiceService invoiceService = (InvoiceService)InvoiceServiceImpl.getInvoiceServiceImpl();
		Double total = shoppingService.getTotal(items);
//		int invNo = invoiceService.getInvNo();
		
		session.setAttribute("total", total);
//		System.out.println("Invoice number is "+invNo);
//		session.setAttribute("invNo", invNo);
//		invoiceService.createInvoice(invNo,customerNo,itemList);
		
		
		try {
			out.println("<table style=\"width:25%\"> ");
			out.println("<tr>");
			out.println("<th>S.No<th>");
			out.println("<th>"+"Item Name"+"</th>");
			out.println("<th>"+"Item price"+"</th>");
			out.println("</tr>");
			
			
			for(ItemDetailsDTO item:items) {
				out.println("<tr>");
				out.println("<td>"+(++count)+"<td>");
				out.println("<td>"+item.getItemDesc()+"</td>");
				out.println("<td>"+item.getItemPrice()+"</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<td>"+"<td>");
			out.println("<td>"+"Total:"+"</td>");
			out.println("<td>"+total+"</td>");
			out.println("</tr>");
			out.println("</table>");
		}catch(Exception e) {e.printStackTrace();}
		
		return super.doEndTag();
	}
}
*/
