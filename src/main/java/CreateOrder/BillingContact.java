package CreateOrder;
import CreateOrder.Address;

public class BillingContact extends Address {
	
	private String CompanyName;
	private String EmailAddress;
	private Address Address;
	
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "BillingContact [CompanyName=" + CompanyName + ", EmailAddress=" + EmailAddress + ", Address=" + Address
				+ "]";
	}
	
	
	
	
	

}
