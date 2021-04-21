package com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompKey1 implements Serializable,Cloneable{
	
	private int itemNo;
	private int invNo;
	
	private static CompKey1 compKey;
	public CompKey1() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static CompKey1 getCompKey() {
		if(compKey==null) {
			compKey=new CompKey1();
			return compKey;
		}
		else {
			return compKey.createClone();
		}
	}
	
	public CompKey1 createClone(){
		try {
			return (CompKey1)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final int getInvNo() {
		return invNo;
	}
	public final void setInvNo(int invNo) {
		this.invNo = invNo;
	}
	@Override
	public String toString() {
		return "CompKey1 [itemNo=" + itemNo + ", invNo=" + invNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invNo;
		result = prime * result + itemNo;
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
		CompKey1 other = (CompKey1) obj;
		if (invNo != other.invNo)
			return false;
		if (itemNo != other.itemNo)
			return false;
		return true;
	}
	public CompKey1(int itemNo, int invNo) {
		this.itemNo = itemNo;
		this.invNo = invNo;
	}
	
}
