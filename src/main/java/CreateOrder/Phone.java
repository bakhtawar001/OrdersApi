package CreateOrder;

public class Phone {
 private int Id;
 private String Type;
 private int PhoneCode;
 private String Country;
 
 public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public int getPhoneCode() {
	return PhoneCode;
}
public void setPhoneCode(int phoneCode) {
	PhoneCode = phoneCode;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
@Override
public String toString() {
	return "Phone [Id=" + Id + ", Type=" + Type + ", PhoneCode=" + PhoneCode + ", Country=" + Country + "]";
}

}
