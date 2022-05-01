package CreateOrder;

public class Address {
	private int Id;
	private String City;
	private String Line1;
	private String State;
	private int PostalCode;
	private String Country;
	private Phone Phone;
	private boolean IsPrimary;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getLine1() {
		return Line1;
	}
	public void setLine1(String line1) {
		Line1 = line1;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public Phone getPhone() {
		return Phone;
	}
	public void setPhone(Phone phone) {
		Phone = phone;
	}
	public boolean isIsPrimary() {
		return IsPrimary;
	}
	public void setIsPrimary(boolean isPrimary) {
		IsPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "Address [Id=" + Id + ", City=" + City + ", Line1=" + Line1 + ", State=" + State + ", PostalCode="
				+ PostalCode + ", Country=" + Country + ", Phone=" + Phone + ", IsPrimary=" + IsPrimary + "]";
	}
	
	
}
