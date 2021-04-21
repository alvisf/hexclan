package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name="itemTransactionDTO")
@Table(name="transaction_details")
public class ItemTransactionDTO implements Serializable,Cloneable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int transactionID;
	
	private int itemQuantity;
	
	//@MapsId("invNo")
	@ManyToOne
	@JoinColumn(name="invNo")
	private InvoiceMasterDTO invoiceMasterDTO;
	
	//@MapsId("itemNo")
	@ManyToOne
	@JoinColumn(name="itemNo")
	private ItemDetailsDTO itemDetailsDTO;
	
	private static ItemTransactionDTO itemTransactionDTO;
	
	public ItemTransactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static ItemTransactionDTO getItemTransactionDTO() {
		if(itemTransactionDTO==null) {
			itemTransactionDTO=new ItemTransactionDTO();
			return itemTransactionDTO;
		}
		else {
			return itemTransactionDTO.createClone();
		}
	}
	
	public ItemTransactionDTO createClone(){
		try {
			return (ItemTransactionDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public final int getItemQuantity() {
		return itemQuantity;
	}
	public final void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public final int getTransactionID() {
		return transactionID;
	}

	public final void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public final InvoiceMasterDTO getInvoiceMasterDTO() {
		return invoiceMasterDTO;
	}

	public final void setInvoiceMasterDTO(InvoiceMasterDTO invoiceMasterDTO) {
		this.invoiceMasterDTO = invoiceMasterDTO;
	}

	public final ItemDetailsDTO getItemDetailsDTO() {
		return itemDetailsDTO;
	}

	public final void setItemDetailsDTO(ItemDetailsDTO itemDetailsDTO) {
		this.itemDetailsDTO = itemDetailsDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemQuantity;
		result = prime * result + transactionID;
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
		ItemTransactionDTO other = (ItemTransactionDTO) obj;
		if (itemQuantity != other.itemQuantity)
			return false;
		if (transactionID != other.transactionID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemTransactionDTO [transactionID=" + transactionID + ", itemQuantity=" + itemQuantity + "]";
	}

	public ItemTransactionDTO(int transactionID, int itemQuantity) {
		super();
		this.transactionID = transactionID;
		this.itemQuantity = itemQuantity;
	}

}
