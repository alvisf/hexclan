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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="userDetailsDTO")
@Table(name="USER_DETAILS")
public class UserDetailsDTO implements Serializable,Cloneable{
	@Id
	@GeneratedValue
	@Column(name="userID",nullable = false)
	private int uid;
	
	@Column(unique = true,nullable = false)
	private String uname;
	
	@Column(nullable = false)
	private String upass;
	
	@Column(name = "flag", nullable = false) 
	private int flag;
	
	@Column()
	private String userAddress;
	
	@Column(nullable = false)
	private String role;
	
	@Column()
	private String userEmail;
	
	@Column()
	private long userPhone;
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "userDetailsDTO")
	private Set<InvoiceMasterDTO> invoices;
	
	private static UserDetailsDTO userDetailsDTO;
	
	public UserDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static UserDetailsDTO getUserDetailsDTO() {
		if(userDetailsDTO==null) {
			userDetailsDTO=new UserDetailsDTO();
			return userDetailsDTO;
		}
		else {
			return userDetailsDTO.createClone();
		}
	}
	
	public UserDetailsDTO createClone(){
		try {
			return (UserDetailsDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public final int getUid() {
		return uid;
	}

	public final void setUid(int uid) {
		this.uid = uid;
	}

	public final String getUname() {
		return uname;
	}

	public final void setUname(String uname) {
		this.uname = uname;
	}

	public final String getUpass() {
		return upass;
	}

	public final void setUpass(String upass) {
		this.upass = upass;
	}

	public final int getFlag() {
		return flag;
	}

	public final void setFlag(int flag) {
		this.flag = flag;
	}

	public final String getUserAddress() {
		return userAddress;
	}

	public final String getRole() {
		return role;
	}

	public final void setRole(String role) {
		this.role = role;
	}

	public final void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public final String getUserEmail() {
		return userEmail;
	}

	public final void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public final long getUserPhone() {
		return userPhone;
	}

	public final void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public final Set<InvoiceMasterDTO> getInvoices() {
		return invoices;
	}

	public final void setInvoices(Set<InvoiceMasterDTO> invoices) {
		this.invoices = invoices;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upass == null) ? 0 : upass.hashCode());
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + (int) (userPhone ^ (userPhone >>> 32));
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
		UserDetailsDTO other = (UserDetailsDTO) obj;
		if (flag != other.flag)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (upass == null) {
			if (other.upass != null)
				return false;
		} else if (!upass.equals(other.upass))
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userPhone != other.userPhone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDetailsDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag
				+ ", userAddress=" + userAddress + ", role=" + role + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + "]";
	}

	public UserDetailsDTO(int uid, String uname, String upass, int flag, String userAddress, String role,
			String userEmail, long userPhone) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.flag = flag;
		this.userAddress = userAddress;
		this.role = role;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}


	
	
}
