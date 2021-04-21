package com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="invoiceMasterDTO")
@Table(name="INVOICE_MASTER")
public class InvoiceMasterDTO implements Serializable,Cloneable{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int invNo;
	private LocalDate invDate;
	
	
	@ManyToOne
	@JoinColumn(name = "customerID",nullable = false)
	private UserDetailsDTO userDetailsDTO;
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy = "invoiceMasterDTO",orphanRemoval=true)
	private Set<ItemTransactionDTO> transactions;
	
	private static InvoiceMasterDTO invoiceMasterDTO;
	
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoiceMasterDTO==null) {
			invoiceMasterDTO=new InvoiceMasterDTO();
			return invoiceMasterDTO;
		}
		else {
			return invoiceMasterDTO.createClone();
		}
	}
	
	public InvoiceMasterDTO createClone(){
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	public final UserDetailsDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}

	public final void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}

	public final Set<ItemTransactionDTO> getTransactions() {
		return transactions;
	}

	public final void setTransactions(Set<ItemTransactionDTO> transactions) {
		this.transactions = transactions;
	}

	public final int getInvNo() {
		return invNo;
	}

	public final void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public final LocalDate getInvDate() {
		return invDate;
	}

	public final void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invNo;
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
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invNo != other.invNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invNo=" + invNo + ", invDate=" + invDate + "]";
	}

	public InvoiceMasterDTO(int invNo, LocalDate invDate) {
		super();
		this.invNo = invNo;
		this.invDate = invDate;
	}

}
