package CreateOrder;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;




public class LineItems {

 
    private String Type;
    private int Id;
    private String Name;
    private String Description;
    private String Number;
    private String ImageUrl;
    private int ProductId;
	
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "LineItems [Type=" + Type + ", Id=" + Id + ", Name=" + Name + ", Description=" + Description
				+ ", Number=" + Number + ", ImageUrl=" + ImageUrl + ", ProductId=" + ProductId + "]";
	}
	
	
   
}
