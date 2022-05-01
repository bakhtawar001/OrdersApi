package DataVerification;

import java.util.List;

import org.testng.Assert;

import com.google.gson.Gson;

import OrdersAPI.API.OrdersAPI;
import AddProductLineItems.AddCustomProduct;
import CreateOrder.CreateOrder;
import CreateOrder.LineItems;
import CreateOrder.Payment;
import Email.SentEmail_PO;
import Notes.Notes;
import io.restassured.path.json.JsonPath;


public class OrdersDataVerification extends OrdersAPI {
	
	
	public static void PostOrdersDataVerifications()
	{
	Gson gson = new Gson();
	CreateOrder pojo=gson.fromJson(createorderinfo, CreateOrder.class);
	System.out.println("LineItems>>> "+ pojo.getLineItems());
	
	String Inquirycontact=pojo.getInquiryContact().getAddress().getPhone().getCountry();
	System.out.println("Inquirycontact>>> "+ Inquirycontact);
	Assert.assertEquals(Inquirycontact,"US");

	String BillingContactCompanyName=pojo.getBillingContact().getCompanyName();
	System.out.println("BillingContactCompanyName>>> "+ BillingContactCompanyName);
	Assert.assertEquals(BillingContactCompanyName,"Auto Supplier ASIQA I");
	
	String BillingContactEmailAddress=pojo.getBillingContact().getEmailAddress();
	System.out.println("BillingContactEmailAddress>>> "+ BillingContactEmailAddress);
	Assert.assertEquals(BillingContactEmailAddress,"bnazir@asicentral.com");
	
	String BillingContactState=pojo.getBillingContact().getAddress().getState();
	System.out.println("BillingContactState>>> "+ BillingContactState);
	Assert.assertEquals(BillingContactState,"PA");
	
	int AcknowledgementContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
	System.out.println("AcknowledgementContactPostalCod>>> "+ AcknowledgementContactPostalCode);
	Assert.assertEquals(AcknowledgementContactPostalCode,19053);
	
	JsonPath jsonPathEvaluator = response.jsonPath();
	System.out.println("InquiryContact ID>>> "+ jsonPathEvaluator.get("InquiryContact.Id"));
	OrderId= jsonPathEvaluator.get("Id");
	System.out.println("Orders ID>>> "+ OrderId);
	OrderNumber=jsonPathEvaluator.get("Number");
	System.out.println("Orders Number>>> "+ OrderNumber);

}
	public static void GetOrdersDataVerifications()
	{
	Gson gson = new Gson();
	CreateOrder pojo=gson.fromJson(GetCreatedOrder_FromID, CreateOrder.class);

	
	int Productid=pojo.getLineItems().get(0).getProductId();
	System.out.println("LineItems_ProductId>>> "+ Productid);
	Assert.assertEquals(Productid, 6390276);
	
	
	String Inquirycontact=pojo.getInquiryContact().getAddress().getPhone().getCountry();
	System.out.println("Inquirycontact>>> "+ Inquirycontact);
	Assert.assertEquals(Inquirycontact,"US");

	String BillingContactCompanyName=pojo.getBillingContact().getCompanyName();
	System.out.println("BillingContactCompanyName>>> "+ BillingContactCompanyName);
	Assert.assertEquals( BillingContactCompanyName,"Auto Supplier ASIQA I");
	
	String BillingContactEmailAddress=pojo.getBillingContact().getEmailAddress();
	System.out.println("BillingContactEmailAddress>>> "+ BillingContactEmailAddress);
	Assert.assertEquals(BillingContactEmailAddress,"bnazir@asicentral.com");
	
	String BillingContactState=pojo.getBillingContact().getAddress().getState();
	System.out.println("BillingContactState>>> "+ BillingContactState);
	Assert.assertEquals(BillingContactState,"PA");
	
	int AcknowledgementContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
	System.out.println("AcknowledgementContactPostalCod>>> "+ AcknowledgementContactPostalCode);
	Assert.assertEquals(AcknowledgementContactPostalCode,19053);
	
	int ShippingContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
	System.out.println("ShippingContactPostalCode>>> "+ ShippingContactPostalCode);
	Assert.assertEquals( ShippingContactPostalCode,19053);
	
	String ShippingContactCompanyName=pojo.getBillingContact().getCompanyName();
	System.out.println("ShippingContactCompanyName>>> "+ ShippingContactCompanyName);
	Assert.assertEquals( ShippingContactCompanyName,"Auto Supplier ASIQA I");
	
	String ShippingContactCountryName=pojo.getBillingContact().getAddress().getCountry();
	System.out.println("ShippingContactCountryName>>> "+ ShippingContactCountryName);
	Assert.assertEquals(ShippingContactCountryName,"United States");
	
	String ShippingContactState=pojo.getBillingContact().getAddress().getState();
	System.out.println("ShippingContactState>>> "+ ShippingContactState);
	Assert.assertEquals(ShippingContactState,"PA");
	
	Amountdue=pojo.getAmountDue();
	System.out.println("Amount Due>>> "+ Amountdue);
	

}
	
	public static void PostNotes_DataVerifications()
	{
		Gson gson = new Gson();
		Notes pojo=gson.fromJson(CreateNotes, Notes.class);
		String UserNameofPostedNotes=pojo.getUserName();
		System.out.println("UserNameofPostedNotes>>> "+ UserNameofPostedNotes);
		Assert.assertEquals(UserNameofPostedNotes,"Automation1 Framework");
		
		String NotesContent=pojo.getContent();
		System.out.println("NotesContent>>> "+ NotesContent);
		Assert.assertEquals("Notes are created by User 1!"+OrderId, NotesContent);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
        NotesId= jsonPathEvaluator.get("Id");
        System.out.println("Notes ID>>> "+ NotesId);
	
	

}
	public static void AfterUpdateNotes_GetNotesDataVerifications()
	{
		Gson gson = new Gson();
		Notes pojo=gson.fromJson(GetCreatedNotes_FromNotesID, Notes.class);
		int UserIDofPostedNotes=pojo.getUserId();
		System.out.println("UserIDofPostedNotes>>> "+ UserIDofPostedNotes);
		Assert.assertEquals(UserIDofPostedNotes,394918);
		
		String UserNameofPostedNotes=pojo.getUserName();
		System.out.println("UserNameofPostedNotes>>> "+ UserNameofPostedNotes);
		Assert.assertEquals( UserNameofPostedNotes,"Automation1 Framework");
		
		String UpdatedNotesContent=pojo.getContent();
		System.out.println("UpdatedNotesContent>>> "+UpdatedNotesContent);
		Assert.assertEquals(UpdatedNotesContent,"Updated Notes are created by User 1!");
		
		/*boolean Editable=pojo.isIsEditable();
		System.out.println("UpdatedNotesContent>>> "+Editable);
		Assert.assertEquals(true, Editable);*/
	

}
	public static void PostCustomProduct_GetProductDataVerifications()
	{
		int TaxableAmountint;
		int Amountint;
		int Costint;
		int Marginint;
		Gson gson = new Gson();
		AddCustomProduct pojo=gson.fromJson(AddCustomProduct, AddCustomProduct.class);
		float TaxableAmount=pojo.getTotals().getTaxableAmount();
		System.out.println("TaxableAmountfloat>>> "+ TaxableAmount);
		TaxableAmountint=(int)TaxableAmount;
		System.out.println("TaxableAmount>>> "+ TaxableAmountint);
		Assert.assertEquals(TaxableAmountint,0.0);
		
		float Amount=pojo.getTotals().getAmount();
		System.out.println("AmountFloat>>> "+ Amount);
		Amountint=(int)Amount;
		System.out.println("Amount>>> "+ Amountint);
		Assert.assertEquals(Amountint,4);
		
		float Cost=pojo.getTotals().getCost();
		Costint=(int)Cost;
		System.out.println("Cost>>> "+ Costint);
		Assert.assertEquals(Costint,4);
		
		String SupplierName=pojo.getSupplier().getName();
		System.out.println("SupplierName>>> "+ SupplierName);
		Assert.assertEquals(SupplierName,"Auto Supplier ASIQA I");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		LineItemId= jsonPathEvaluator.get("Id");
		System.out.println("LineItem Id>>> "+ LineItemId);
		
	
	

}
	
	public static void GetCustomProduct_GetProductDataVerifications()
	{
		int TaxableAmountint;
		int Amountint;
		int Costint;
		int Marginint;
		Gson gson = new Gson();
		
		AddCustomProduct pojo=gson.fromJson(GetCustomProduct, AddCustomProduct.class);
		float TaxableAmount=pojo.getTotals().getTaxableAmount();
		TaxableAmountint=(int)TaxableAmount;
		System.out.println("TaxableAmount>>> "+ TaxableAmountint);
		Assert.assertEquals(0.0, TaxableAmountint);
		
		float Amount=pojo.getTotals().getAmount();
		Amountint=(int)Amount;
		System.out.println("Amount>>> "+ Amountint);
		Assert.assertEquals(Amountint,4);
		
		float Cost=pojo.getTotals().getCost();
		Costint=(int)Cost;
		System.out.println("Cost>>> "+ Costint);
		Assert.assertEquals(Costint,4);
		
		String SupplierName=pojo.getSupplier().getName();
		System.out.println("SupplierName>>> "+ SupplierName);
		Assert.assertEquals( SupplierName,"Auto Supplier ASIQA I");
		
		String ProductName=pojo.getName();
		System.out.println("ProductName>>> "+ ProductName);
		Assert.assertEquals(ProductName,"Keys");
		
		String ProductType=pojo.getType();
		System.out.println("ProductType>>> "+ ProductType);
		Assert.assertEquals(ProductType,"product");
		
		
	

}	
	public static void GetCustomProduct_GetProduct_FieldDataVerifications()
	{
		
		Gson gson = new Gson();
		AddCustomProduct pojo=gson.fromJson(GetCustomProduct, AddCustomProduct.class);
		float TaxableAmount=pojo.getTotals().getTaxableAmount();
		System.out.println("TaxableAmountfloat>>> "+ TaxableAmount);
		Assert.assertEquals(TaxableAmount,0.0);
		
		float Amount=pojo.getTotals().getAmount();
		System.out.println("AmountFloat>>> "+ Amount);
		Assert.assertNotEquals( Amount,4.040404040404041);
		
		float Cost=pojo.getTotals().getCost();
		Assert.assertEquals(Cost,4);
		
		float Margin=pojo.getTotals().getMargin();
		System.out.println("Margin>>> "+  Margin);
		Assert.assertNotEquals( Margin,0.040404040404040664);
		
		float SalesTax=pojo.getTotals().getSalesTax();
		System.out.println("SalesTax>>> "+  SalesTax);
		Assert.assertNotEquals(SalesTax,  0.0);
		
	
		String SupplierName=pojo.getSupplier().getName();
		System.out.println("SupplierName>>> "+ SupplierName);
		Assert.assertEquals( SupplierName,"Auto Supplier ASIQA I");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		LineItemId= jsonPathEvaluator.get("Id");
		System.out.println("LineItem Id>>> "+ LineItemId);
		
	

}
	
	public static void UpdateCustomProduct_GetProductDataVerifications()
	{
		int TaxableAmountint;
		int Amountint;
		int Costint;
		int Marginint;
		Gson gson = new Gson();
		
		AddCustomProduct pojo=gson.fromJson(GetCustomProduct, AddCustomProduct.class);
		float TaxableAmount=pojo.getTotals().getTaxableAmount();
		TaxableAmountint=(int)TaxableAmount;
		System.out.println("TaxableAmount>>> "+ TaxableAmountint);
		Assert.assertEquals(TaxableAmountint,0.0);
		
		float Amount=pojo.getTotals().getAmount();
		Amountint=(int)Amount;
		System.out.println("Amount>>> "+ Amountint);
		Assert.assertEquals(Amountint,4);
		
		float Cost=pojo.getTotals().getCost();
		Costint=(int)Cost;
		System.out.println("Cost>>> "+ Costint);
		Assert.assertEquals(Costint,4);
		
		String SupplierName=pojo.getSupplier().getName();
		System.out.println("SupplierName>>> "+ SupplierName);
		Assert.assertEquals( SupplierName,"Auto Supplier ASIQA I");
		
		String ProductName=pojo.getName();
		System.out.println("ProductName>>> "+ ProductName);
		Assert.assertEquals( ProductName,"Keys");
		
		String ProductType=pojo.getType();
		System.out.println("ProductType>>> "+ ProductType);
		Assert.assertEquals(ProductType,"product");
		
		
}	
	
	public static void PostPaymentVerification()
	{
		
		Gson gson = new Gson();
		Payment pojo=gson.fromJson(PaymentResponse, Payment.class);
		float Amountpaid=pojo.getAmount();
		System.out.println("AmountPaid>>> "+ Amountpaid);
		Assert.assertEquals(Amountpaid, AmountToBePaid);
		
		boolean IsFullPayment=pojo.isIsFullPayment();
		System.out.println("FullPayment>>> "+ IsFullPayment);
		Assert.assertEquals(IsFullPayment,true);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
        PaymentId= jsonPathEvaluator.get("Id");
        System.out.println("Payment ID>>> "+ PaymentId);
    	Assert.assertEquals(200,response.getStatusCode());
		
	}	
	public static void GetPaymentVerification()
	{
		
		Gson gson = new Gson();
		Payment pojo=gson.fromJson(PaymentResponse, Payment.class);
		float Amountpaid=pojo.getAmount();
		System.out.println("AmountPaid>>> "+ Amountpaid);
		Assert.assertEquals(Amountpaid, AmountToBePaid);
		
		String CurrencyCode=pojo.getCurrencyCode();
		System.out.println("CurrencyCode>>> "+ CurrencyCode);
		Assert.assertEquals(CurrencyCode, "USD");
		
		boolean IsFullPayment=pojo.isIsFullPayment();
		System.out.println("FullPayment>>> "+ IsFullPayment);
		Assert.assertEquals(IsFullPayment,true);
	
}
	public static void RemaingPaymentVerification()
	{
		
		Gson gson = new Gson();
		Payment pojo=gson.fromJson(PaymentResponse, Payment.class);
		float Amountpaid=pojo.getAmount();
		System.out.println("AmountPaid>>> "+ Amountpaid);
		Assert.assertEquals(Amountpaid, AmountRemaining);
		
		boolean IsFullPayment=pojo.isIsFullPayment();
		System.out.println("FullPayment>>> "+ IsFullPayment);
		Assert.assertEquals(IsFullPayment,true);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
        PaymentId= jsonPathEvaluator.get("Id");
        System.out.println("Payment ID>>> "+ PaymentId);
    	Assert.assertEquals(200,response.getStatusCode());
		
	}	
	public static void SalesOrdersDataValidation()
	{
		Gson gson = new Gson();
		CreateOrder pojo=gson.fromJson(SalesOrdersResponse, CreateOrder.class);

		
		int Productid=pojo.getLineItems().get(0).getProductId();
		System.out.println("LineItems_ProductId>>> "+ Productid);
		Assert.assertEquals(Productid, 6390276);
		
		
		String Inquirycontact=pojo.getInquiryContact().getAddress().getPhone().getCountry();
		System.out.println("Inquirycontact>>> "+ Inquirycontact);
		Assert.assertEquals(Inquirycontact,"US");

		String BillingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("BillingContactCompanyName>>> "+ BillingContactCompanyName);
		Assert.assertEquals(BillingContactCompanyName,"Auto Supplier ASIQA I");
		
		String BillingContactEmailAddress=pojo.getBillingContact().getEmailAddress();
		System.out.println("BillingContactEmailAddress>>> "+ BillingContactEmailAddress);
		Assert.assertEquals( BillingContactEmailAddress,"bnazir@asicentral.com");
		
		String BillingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("BillingContactState>>> "+ BillingContactState);
		Assert.assertEquals( BillingContactState,"PA");
		
		int AcknowledgementContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("AcknowledgementContactPostalCod>>> "+ AcknowledgementContactPostalCode);
		Assert.assertEquals( AcknowledgementContactPostalCode,19053);
		
		int ShippingContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("ShippingContactPostalCode>>> "+ ShippingContactPostalCode);
		Assert.assertEquals(ShippingContactPostalCode,19053);
		
		String ShippingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("ShippingContactCompanyName>>> "+ ShippingContactCompanyName);
		Assert.assertEquals(ShippingContactCompanyName,"Auto Supplier ASIQA I");
		
		String ShippingContactCountryName=pojo.getBillingContact().getAddress().getCountry();
		System.out.println("ShippingContactCountryName>>> "+ ShippingContactCountryName);
		Assert.assertEquals( ShippingContactCountryName,"United States");
		
		String ShippingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("ShippingContactState>>> "+ ShippingContactState);
		Assert.assertEquals( ShippingContactState,"PA");
		
		
	}
	public static void PostReorderUnderOrderDataValidation()
	{
		Gson gson = new Gson();
		CreateOrder pojo=gson.fromJson(PostReorder_UnderOrderResponse, CreateOrder.class);

		
		int Productid=pojo.getLineItems().get(0).getProductId();
		System.out.println("LineItems_ProductId>>> "+ Productid);
		Assert.assertEquals(Productid, 6390276);
		
		
		String Inquirycontact=pojo.getInquiryContact().getAddress().getPhone().getCountry();
		System.out.println("Inquirycontact>>> "+ Inquirycontact);
		Assert.assertEquals(Inquirycontact,"US");

		String BillingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("BillingContactCompanyName>>> "+ BillingContactCompanyName);
		Assert.assertEquals(BillingContactCompanyName,"Auto Supplier ASIQA I");
		
		String BillingContactEmailAddress=pojo.getBillingContact().getEmailAddress();
		System.out.println("BillingContactEmailAddress>>> "+ BillingContactEmailAddress);
		Assert.assertEquals(BillingContactEmailAddress,"bnazir@asicentral.com");
		
		String BillingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("BillingContactState>>> "+ BillingContactState);
		Assert.assertEquals(BillingContactState,"PA");
		
		int AcknowledgementContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("AcknowledgementContactPostalCod>>> "+ AcknowledgementContactPostalCode);
		Assert.assertEquals(AcknowledgementContactPostalCode,19053);
		
		int ShippingContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("ShippingContactPostalCode>>> "+ ShippingContactPostalCode);
		Assert.assertEquals(ShippingContactPostalCode,19053);
		
		String ShippingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("ShippingContactCompanyName>>> "+ ShippingContactCompanyName);
		Assert.assertEquals(ShippingContactCompanyName,"Auto Supplier ASIQA I");
		
		String ShippingContactCountryName=pojo.getBillingContact().getAddress().getCountry();
		System.out.println("ShippingContactCountryName>>> "+ ShippingContactCountryName);
		Assert.assertEquals( ShippingContactCountryName,"United States");
		
		String ShippingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("ShippingContactState>>> "+ ShippingContactState);
		Assert.assertEquals( ShippingContactState,"PA");
		

	}
	public static void PostQuoteUnderOrderDataValidation()
	{
		Gson gson = new Gson();
		CreateOrder pojo=gson.fromJson(PostReorder_UnderOrderResponse, CreateOrder.class);

		
		int Productid=pojo.getLineItems().get(0).getProductId();
		System.out.println("LineItems_ProductId>>> "+ Productid);
		Assert.assertEquals(Productid, 6390276);
		
		
		String Inquirycontact=pojo.getInquiryContact().getAddress().getPhone().getCountry();
		System.out.println("Inquirycontact>>> "+ Inquirycontact);
		Assert.assertEquals(Inquirycontact,"US");

		String BillingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("BillingContactCompanyName>>> "+ BillingContactCompanyName);
		Assert.assertEquals(BillingContactCompanyName,"Auto Supplier ASIQA I");
		
		String BillingContactEmailAddress=pojo.getBillingContact().getEmailAddress();
		System.out.println("BillingContactEmailAddress>>> "+ BillingContactEmailAddress);
		Assert.assertEquals(BillingContactEmailAddress,"bnazir@asicentral.com");
		
		String BillingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("BillingContactState>>> "+ BillingContactState);
		Assert.assertEquals(BillingContactState,"PA");
		
		int AcknowledgementContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("AcknowledgementContactPostalCod>>> "+ AcknowledgementContactPostalCode);
		Assert.assertEquals(AcknowledgementContactPostalCode,19053);
		
		int ShippingContactPostalCode=pojo.getAcknowledgementContact().getAddress().getPostalCode();
		System.out.println("ShippingContactPostalCode>>> "+ ShippingContactPostalCode);
		Assert.assertEquals(ShippingContactPostalCode,19053);
		
		String ShippingContactCompanyName=pojo.getBillingContact().getCompanyName();
		System.out.println("ShippingContactCompanyName>>> "+ ShippingContactCompanyName);
		Assert.assertEquals(ShippingContactCompanyName,"Auto Supplier ASIQA I");
		
		String ShippingContactCountryName=pojo.getBillingContact().getAddress().getCountry();
		System.out.println("ShippingContactCountryName>>> "+ ShippingContactCountryName);
		Assert.assertEquals( ShippingContactCountryName,"United States");
		
		String ShippingContactState=pojo.getBillingContact().getAddress().getState();
		System.out.println("ShippingContactState>>> "+ ShippingContactState);
		Assert.assertEquals( ShippingContactState,"PA");
		

	}
	public static void PostEmailUnderPurchaseOrderDocumentDataValidation()
	{
		Gson gson = new Gson();
		SentEmail_PO pojo=gson.fromJson(PostEmail_UnderPurchaseOrderDocResponse, SentEmail_PO .class);
		String Subject=pojo.getSubject();
		System.out.println("EmailSubject>>> "+ Subject);
		Assert.assertEquals(Subject,"New Purchase Order"+OrderNumber+"from ASIQA Distributor III");

		
	}
}