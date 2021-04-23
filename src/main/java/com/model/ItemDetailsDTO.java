package com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="itemDetailsDTO")
@Table(name="ITEM_DETAILS")
public class ItemDetailsDTO implements Serializable,Cloneable{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int itemNo;
	private String imgurl;
	@Column(name="itemName")
	private String itemDesc;
	private double itemPrice;
	private String itemUnit;
	private String itemCategory;
	private int stockQuantity;
	
	private static ItemDetailsDTO itemDetailsDTO;
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy = "itemDetailsDTO",orphanRemoval=true)
	private Set<ItemTransactionDTO> transactions;
	
	public ItemDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static ItemDetailsDTO getItemDetailsDTO() {
		if(itemDetailsDTO==null) {
			itemDetailsDTO=new ItemDetailsDTO();
			return itemDetailsDTO;
		}
		else {
			return itemDetailsDTO.createClone();
		}
	}
	
	public ItemDetailsDTO createClone(){
		try {
			return (ItemDetailsDTO)super.clone();
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

	public final String getImgurl() {
		return imgurl;
	}

	public final void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public final String getItemDesc() {
		return itemDesc;
	}

	public final void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public final double getItemPrice() {
		return itemPrice;
	}

	public final void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public final String getItemUnit() {
		return itemUnit;
	}

	public final void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public final String getItemCategory() {
		return itemCategory;
	}

	public final void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public final int getStockQuantity() {
		return stockQuantity;
	}

	public final void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Set<ItemTransactionDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<ItemTransactionDTO> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((itemCategory == null) ? 0 : itemCategory.hashCode());
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + itemNo;
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((itemUnit == null) ? 0 : itemUnit.hashCode());
		result = prime * result + stockQuantity;
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
		ItemDetailsDTO other = (ItemDetailsDTO) obj;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
			return false;
		if (itemCategory == null) {
			if (other.itemCategory != null)
				return false;
		} else if (!itemCategory.equals(other.itemCategory))
			return false;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemNo != other.itemNo)
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		if (itemUnit == null) {
			if (other.itemUnit != null)
				return false;
		} else if (!itemUnit.equals(other.itemUnit))
			return false;
		if (stockQuantity != other.stockQuantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDetailsDTO [itemNo=" + itemNo + ", imgurl=" + imgurl + ", itemDesc=" + itemDesc + ", itemPrice="
				+ itemPrice + ", itemUnit=" + itemUnit + ", itemCategory=" + itemCategory + ", stockQuantity="
				+ stockQuantity + "]";
	}

	public ItemDetailsDTO(int itemNo, String imgurl, String itemDesc, double itemPrice, String itemUnit,
			String itemCategory, int stockQuantity) {
		super();
		this.itemNo = itemNo;
		this.imgurl = imgurl;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.itemUnit = itemUnit;
		this.itemCategory = itemCategory;
		this.stockQuantity = stockQuantity;
	}

	
}
