package com.model;

import java.io.Serializable;


public class OrderDetails implements Serializable,Cloneable
 {
 
	public String amount;
	public String razorpay_payment_id;
	public String razorpay_order_id;
	public String razorpay_signature;

	
	public String getRazorpay_payment_id() {
		return razorpay_payment_id;
	}
	public void setRazorpay_payment_id(String razorpay_payment_id) {
		this.razorpay_payment_id = razorpay_payment_id;
	}
	public String getRazorpay_order_id() {
		return razorpay_order_id;
	}
	public void setRazorpay_order_id(String razorpay_order_id) {
		this.razorpay_order_id = razorpay_order_id;
	}
	public String getRazorpay_signature() {
		return razorpay_signature;
	}
	public void setRazorpay_signature(String razorpay_signature) {
		this.razorpay_signature = razorpay_signature;
	}
	
	
	
	
public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}




private static OrderDetails orderDetails;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static OrderDetails getorderDetails() {
		if(orderDetails==null) {
			orderDetails=new OrderDetails();
			return orderDetails;
		}
		else {
			return orderDetails.createClone();
		}
	}
	
	public OrderDetails createClone(){
		try {
			return (OrderDetails)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}




