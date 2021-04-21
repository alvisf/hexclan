package com.controller;

import java.io.Serializable;
import java.util.List;

class ShoppingFormBean implements Serializable,Cloneable{
	private List<String> itemlist;

	public final List<String> getItemlist() {
		return itemlist;
	}

	public final void setItemlist(List<String> itemlist) {
		this.itemlist = itemlist;
	}
	
	private ShoppingFormBean() {
		// TODO Auto-generated constructor stub
	}
	
	private static ShoppingFormBean shoppingFormBean;
	
	synchronized public static ShoppingFormBean getShoppingFormBean() {
		if(shoppingFormBean==null) {
			shoppingFormBean=new ShoppingFormBean();
			return shoppingFormBean;
		}
		else {
			return shoppingFormBean.createClone();
		}
	}
	
	public ShoppingFormBean createClone(){
		try {
			return (ShoppingFormBean)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemlist == null) ? 0 : itemlist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingFormBean other = (ShoppingFormBean) obj;
		if (itemlist == null) {
			if (other.itemlist != null)
				return false;
		} else if (!itemlist.equals(other.itemlist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingFormBean [itemlist=" + itemlist + "]";
	}

	public ShoppingFormBean(List<String> itemlist) {
		super();
		this.itemlist = itemlist;
	}

}
