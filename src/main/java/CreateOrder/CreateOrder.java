package CreateOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;




public class CreateOrder {
	private	int Id;
	private String  Type;
	private String Number;
	private String Date;
	private List<SalesPerson> Salesperson;
	private String Status;
	private InquiryContact InquiryContact;
	private BillingContact BillingContact;
	private AcknowledgementContact AcknowledgementContact;
	private ShippingContact ShippingContact;
	private boolean ShippingSameAsBilling;
	private boolean AcknowledgementSameAsBilling;
	private List<LineItems> LineItems;
	private List<Tags>Tags;
	private	int Version;
	private	String CurrencyCode;
	private	String CurrencySymbol;
	private	int CurrencyRate;
	private	List<Currencies> Currencies;
	private	float TotalAmount;
	private	float TotalCost;
	private	float Subtotal;
	private	float TotalDiscountAmount;
	private	float TotalMargin;
	private	float TotalMarginPercent;
	private	float TotalSalesTaxAmount;
	private	float AmountDue;
	private	float AmountPaid;
	private boolean CanEditOrderNumber;
	private String ReorderType;
	private String CreateDate;
	private String CreatedBy;
	private String UpdateDate;
	private String UpdatedBy;
	private CustomFields CustomFields;
	
	private int OwnerId;
	private String AccessLevel;
	private boolean IsVisible;
	private boolean IsEditable;
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
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public List<SalesPerson> getSalesperson() {
		return Salesperson;
	}
	public void setSalesperson(List<SalesPerson> salesperson) {
		Salesperson = salesperson;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public InquiryContact getInquiryContact() {
		return InquiryContact;
	}
	public void setInquiryContact(InquiryContact inquiryContact) {
		InquiryContact = inquiryContact;
	}
	public BillingContact getBillingContact() {
		return BillingContact;
	}
	public void setBillingContact(BillingContact billingContact) {
		BillingContact = billingContact;
	}
	public AcknowledgementContact getAcknowledgementContact() {
		return AcknowledgementContact;
	}
	public void setAcknowledgementContact(AcknowledgementContact acknowledgementContact) {
		AcknowledgementContact = acknowledgementContact;
	}
	public ShippingContact getShippingContact() {
		return ShippingContact;
	}
	public void setShippingContact(ShippingContact shippingContact) {
		ShippingContact = shippingContact;
	}
	public boolean isShippingSameAsBilling() {
		return ShippingSameAsBilling;
	}
	public void setShippingSameAsBilling(boolean shippingSameAsBilling) {
		ShippingSameAsBilling = shippingSameAsBilling;
	}
	public boolean isAcknowledgementSameAsBilling() {
		return AcknowledgementSameAsBilling;
	}
	public void setAcknowledgementSameAsBilling(boolean acknowledgementSameAsBilling) {
		AcknowledgementSameAsBilling = acknowledgementSameAsBilling;
	}
	public List<LineItems> getLineItems() {
		return LineItems;
	}
	public void setLineItems(List<LineItems> lineItems) {
		LineItems = lineItems;
	}
	public List<Tags> getTags() {
		return Tags;
	}
	public void setTags(List<Tags> tags) {
		Tags = tags;
	}
	public int getVersion() {
		return Version;
	}
	public void setVersion(int version) {
		Version = version;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}
	public String getCurrencySymbol() {
		return CurrencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		CurrencySymbol = currencySymbol;
	}
	public int getCurrencyRate() {
		return CurrencyRate;
	}
	public void setCurrencyRate(int currencyRate) {
		CurrencyRate = currencyRate;
	}
	public List<Currencies> getCurrencies() {
		return Currencies;
	}
	public void setCurrencies(List<Currencies> currencies) {
		Currencies = currencies;
	}
	public float getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		TotalAmount = totalAmount;
	}
	public float getTotalMargin() {
		return TotalMargin;
	}
	public void setTotalMargin(float totalMargin) {
		TotalMargin = totalMargin;
	}
	public float getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(float totalCost) {
		TotalCost = totalCost;
	}
	public float getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(float subtotal) {
		Subtotal = subtotal;
	}
	public float getTotalDiscountAmount() {
		return TotalDiscountAmount;
	}
	public void setTotalDiscountAmount(float  totalDiscountAmount) {
		TotalDiscountAmount = totalDiscountAmount;
	}
	
	public float  getTotalMarginPercent() {
		return TotalMarginPercent;
	}
	public void setTotalMarginPercent(float  totalMarginPercent) {
		TotalMarginPercent = totalMarginPercent;
	}
	public float  getTotalSalesTaxAmount() {
		return TotalSalesTaxAmount;
	}
	public void setTotalSalesTaxAmount(float  totalSalesTaxAmount) {
		TotalSalesTaxAmount = totalSalesTaxAmount;
	}
	public float getAmountDue() {
		return AmountDue;
	}
	public void setAmountDue(float amountDue) {
		AmountDue = amountDue;
	}
	public float getAmountPaid() {
		return AmountPaid;
	}
	public void setAmountPaid(float amountPaid) {
		AmountPaid = amountPaid;
	}
	public boolean isCanEditOrderNumber() {
		return CanEditOrderNumber;
	}
	public void setCanEditOrderNumber(boolean canEditOrderNumber) {
		CanEditOrderNumber = canEditOrderNumber;
	}
	public String getReorderType() {
		return ReorderType;
	}
	public void setReorderType(String reorderType) {
		ReorderType = reorderType;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	public CustomFields getCustomFields() {
		return CustomFields;
	}
	public void setCustomFields(CustomFields customFields) {
		CustomFields = customFields;
	}
	public int getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}
	public String getAccessLevel() {
		return AccessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		AccessLevel = accessLevel;
	}
	public boolean isIsVisible() {
		return IsVisible;
	}
	public void setIsVisible(boolean isVisible) {
		IsVisible = isVisible;
	}
	public boolean isIsEditable() {
		return IsEditable;
	}
	public void setIsEditable(boolean isEditable) {
		IsEditable = isEditable;
	}
	@Override
	public String toString() {
		return "CreateOrder [Id=" + Id + ", Type=" + Type + ", Number=" + Number + ", Date=" + Date + ", Salesperson="
				+ Salesperson + ", Status=" + Status + ", InquiryContact=" + InquiryContact + ", BillingContact="
				+ BillingContact + ", AcknowledgementContact=" + AcknowledgementContact + ", ShippingContact="
				+ ShippingContact + ", ShippingSameAsBilling=" + ShippingSameAsBilling
				+ ", AcknowledgementSameAsBilling=" + AcknowledgementSameAsBilling + ", LineItems=" + LineItems
				+ ", Tags=" + Tags + ", Version=" + Version + ", CurrencyCode=" + CurrencyCode + ", CurrencySymbol="
				+ CurrencySymbol + ", CurrencyRate=" + CurrencyRate + ", Currencies=" + Currencies + ", TotalAmount="
				+ TotalAmount + ", TotalCost=" + TotalCost + ", Subtotal=" + Subtotal + ", TotalDiscountAmount="
				+ TotalDiscountAmount + ", TotalMargin=" + TotalMargin + ", TotalMarginPercent=" + TotalMarginPercent
				+ ", TotalSalesTaxAmount=" + TotalSalesTaxAmount + ", AmountDue=" + AmountDue + ", AmountPaid="
				+ AmountPaid + ", CanEditOrderNumber=" + CanEditOrderNumber + ", ReorderType=" + ReorderType
				+ ", CreateDate=" + CreateDate + ", CreatedBy=" + CreatedBy + ", UpdateDate=" + UpdateDate
				+ ", UpdatedBy=" + UpdatedBy + ", CustomFields=" + CustomFields + ", OwnerId=" + OwnerId
				+ ", AccessLevel=" + AccessLevel + ", IsVisible=" + IsVisible + ", IsEditable=" + IsEditable + "]";
	}
	
	
	
}