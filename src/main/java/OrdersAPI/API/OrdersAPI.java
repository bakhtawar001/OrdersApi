package OrdersAPI.API;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.Gson;

import CreateOrder.CreateOrder;
import CreateOrder.LineItems;
import CreateOrder.Payment;
import DataVerification.OrdersDataVerification;
import Email.To;
import Email.SentEmail_PO;
import EndPoints.EndPoints;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.internal.util.IOUtils;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class OrdersAPI extends EndPoints {
	public Cookies cookie;
	public static String accessToken;
	public static String refreshtoken;
	public static Response response;
	
	public static int OrderId;
	public static int NotesId;
	public static int PaymentId;
	public static int LineItemId;
	public static float Amountdue;
	public static   float AmountToBePaid;
	public static float AmountRemaining;
	static Integer ImportLineItemID;
	public static String OrderNumber;
	public static String AddCustomProduct;
	public static String GetCustomProduct;
	public static String GetAllCustomProduct;
	public static String UpdateCustomProduct;
	public static String createorderinfo;
	public static String CreateNotes;
	public static String GetCreatedNotes_FromNotesID;
	public static String UpdateNotes;
	public static String PaymentResponse;
	public static String SalesOrdersResponse;
	public static String GetPaymentResponse;
	public static String PostReorder_UnderOrderResponse;
	public static String PostEmail_UnderPurchaseOrderDocResponse;
	public static String  GetCreatedOrder_FromID;
	public static String get_order;
	
	
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static String envirnment=EndPoints.uat;
	
	
	//Report properties once execution is completed
	public static void StartupReportProperty(String Suite) throws InterruptedException, AWTException, IOException
	
	{
		
		ExtentHtmlReporter htmlReporter;
		htmlReporter = new ExtentHtmlReporter("./Reports/"+Suite);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Bakhtawar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Bakhtawar Malik");
		extent.setSystemInfo("URL", envirnment);
		htmlReporter.config().setDocumentTitle("Automation Testing Report");
		htmlReporter.config().setReportName("Orders API Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();
		
		}

		//Token generation against 125748/CRMRegression1/Pakistan786
	    public static void Orders_Signin() throws IOException {
	        try
	        {
	        	//
	        	Response response =RestAssured.given()
	            .header("Content-Type","application/x-www-form-urlencoded")
	            .header("Authorization","Basic NTAwMDU4Mjk0Ojg1Mjk0NDgyZWIzODdmMDhmODk0Y2U1N2ExNjg0NmRh")
	            .formParam("grant_type", "password")
	            .formParam("asi_number", "125748")
	            .formParam("username", "CRMRegression1")
	            .formParam("password", "Pakistan786")
	            .post("https://authentication.uat-asicentral.com/oauth2/token");	
	            System.out.println("API Response >>> "+response.jsonPath().prettify());
	            accessToken=response.jsonPath().get("access_token");
	            System.out.println("API Response >>> "+accessToken);

	        } 
	        catch (Exception e) 
	        {
	            System.out.println("ERROR: " + e.getMessage());
	            Assert.fail(e.getMessage());
	        }
		
	 }
	 
	    //Get All Order information that are posted against 125748/CRMRegression1/Pakistan786
	    public static void Get_Orders() throws IOException {
	        try 
	        {
	        	
	        	Response resp1=RestAssured.given()
    		   	.auth().oauth2(accessToken)
    		   	.header("Content-Type","application/x-www-form-urlencoded")
    		   	.header("Accept","application/x-www-form-urlencoded")
    		   	.get(BaseURI+GetOrder);
	        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
	        	System.out.println("Get Orders >>> "+resp1.prettyPeek().prettyPrint());
	        	Assert.assertEquals(resp1.getStatusCode(),200);

	        } 
	        catch (Exception e) 
	        {
	            System.out.println("ERROR: " + e.getMessage());
	            Assert.fail(e.getMessage());
	        }
		
	 }
	
	 //Create Order with LineItem
	    public static void POST_Orders() throws IOException {
	        try {
	        	
	        	RequestSpecification request=RestAssured.given();
	        
	        	request.header("Authorization", "Bearer " +accessToken);
	        	request.header("Content-Type","application/json");
	        	request.expect().defaultParser(Parser.JSON);
	        	FileInputStream fileinputstream=new FileInputStream(new File("JsonFile\\CreateOrder.json"));
		        request.body(IOUtils.toByteArray(fileinputstream));	
		        response=request.post(BaseURI + PostOrder);
	        	createorderinfo=response.jsonPath().prettyPrint();
	        	
	        	System.out.println("Create Orders >>> "+createorderinfo);
	        	int statuscode=response.getStatusCode();
	        	
	        	OrdersDataVerification.PostOrdersDataVerifications();
	        	Assert.assertEquals(statuscode,201); 
	        	
	        	

	        } 
	        catch (Exception e) 
	        {
	            System.out.println("ERROR: " + e.getMessage());
	            Assert.fail(e.getMessage());
	        }
	 }
	  //Get Posted order with OrderID
		    public static void GetCreatedOrder_FromID() throws IOException {
		        try 
		        {
		        	
		        	Response resp1=RestAssured.given()
	    		   	.auth().oauth2(accessToken)
	    		   	.header("Content-Type","application/x-www-form-urlencoded")
	    		   	.header("Accept","application/x-www-form-urlencoded")
	    		   	.get(BaseURI+"api/v1/orders/"+OrderId);
		        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
		        	GetCreatedOrder_FromID=resp1.prettyPeek().prettyPrint();
		        	System.out.println("GetCreatedOrder_FromID >>> "+GetCreatedOrder_FromID);
		        	
		        	OrdersDataVerification.GetOrdersDataVerifications();
		        	Assert.assertEquals(resp1.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        
		  //Get Posted order with OrderNumber
		    public static void GetCreatedOrder_FromNumber() throws IOException {
		        try 
		        {
		        	
		        	Response resp1=RestAssured.given()
	    		   	.auth().oauth2(accessToken)
	    		   	.header("Content-Type","application/x-www-form-urlencoded")
	    		   	.header("Accept","application/x-www-form-urlencoded")
	    		   	.get(BaseURI+"api/v1/orders/"+"number"+"/"+OrderNumber);
		        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
		        	System.out.println("GetCreatedOrder_FromNumber >>> "+resp1.prettyPeek().prettyPrint());
		        	
		        	OrdersDataVerification.GetOrdersDataVerifications();
		        	Assert.assertEquals(resp1.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        
	        //Post notes under created order
		    public static void POSTNotes_Order() throws IOException {
		        try 
		        {
		        	
		        	RequestSpecification request=RestAssured.given();
		        	request.header("Authorization", "Bearer " +accessToken);
		        	request.header("Content-Type","application/json");
	    		   	JSONObject json=new JSONObject();
		        	json.put("Content","Notes are created by User 1!"+OrderId);
		        	request.body(json.toString());
		        	System.out.println(request.body(json.toString()));
	    		   	response=request.post(BaseURI+"api/v1/orders/"+OrderId+"/"+"notes");
		        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
		        	CreateNotes=response.jsonPath().prettyPrint();
		        	System.out.println("CreateNotesUnderOrder >>> "+CreateNotes);
		        	
		        	OrdersDataVerification.PostNotes_DataVerifications();
		        	Assert.assertEquals(response.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		  //Update notes under created order
		    public static void UpdateNotes_Order() throws IOException {
		        try 
		        {
		        	RequestSpecification request=RestAssured.given();
		        	request.header("Authorization", "Bearer " +accessToken);
		        	request.header("Content-Type","application/json");
	    		   	JSONObject json=new JSONObject();
	    		   	json.put("Content","Updated Notes are created by User 1!");
	    		   	json.put("Id", NotesId);
		        	request.body(json.toString());
	    		    response=request.put(BaseURI+"api/v1/orders/"+OrderId+"/notes/"+NotesId);
		        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
		        	UpdateNotes=response.prettyPeek().prettyPrint();
		        	System.out.println("Update Notes  >>> "+UpdateNotes);
		        	Assert.assertEquals(response.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    //Get notes with notes ID
		    public static void GETCreatedNotes_NotesID() throws IOException {
		        try 
		        {
		        	
		        	Response resp1=RestAssured.given()
	    		   	.auth().oauth2(accessToken)
	    		   	.header("Content-Type","application/x-www-form-urlencoded")
	    		   	.header("Accept","application/x-www-form-urlencoded")
	    		   	.get(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"notes"+"/"+NotesId);
		        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
		        	GetCreatedNotes_FromNotesID=resp1.prettyPeek().prettyPrint();
		        	System.out.println("GetCreatedNotes_FromNotesID >>> "+GetCreatedNotes_FromNotesID);
		        	
		        	OrdersDataVerification.AfterUpdateNotes_GetNotesDataVerifications();
		        	Assert.assertEquals(resp1.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    //Delete notes under created order
		    public static void DeleteCreatedNotes() throws IOException {
		        try 
		        {
		        	
		        	Response resp1=RestAssured.given()
	    		   	.auth().oauth2(accessToken)
	    		   	.header("Content-Type","application/x-www-form-urlencoded")
	    		   	.header("Accept","application/x-www-form-urlencoded")
	    		   	.delete(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"notes"+"/"+NotesId);
		        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
		        	GetCreatedNotes_FromNotesID=resp1.prettyPeek().prettyPrint();
		        	
		        	System.out.println("Delete Notes >>> "+GetCreatedNotes_FromNotesID);
		        	Assert.assertEquals(resp1.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    //Get All the Notes under the created Order
		    public static void GETAllNotes() throws IOException {
		        try 
		        {
		        	
		        	Response resp1=RestAssured.given()
	    		   	.auth().oauth2(accessToken)
	    		   	.header("Content-Type","application/x-www-form-urlencoded")
	    		   	.header("Accept","application/x-www-form-urlencoded")
	    		   	.get(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"notes");
		        	System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
		        	System.out.println("GetALLNotes >>> "+resp1.prettyPeek().prettyPrint());
		        	Assert.assertEquals(resp1.getStatusCode(),200);

		        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	  //Create CustomProduct_LineItem under created order
		    public static void PostCustomProduct_LineItem() throws IOException {
	        	 try 
			        {
	        		 
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		    FileInputStream fileinputstream1=new FileInputStream(new File("JsonFile\\AddCustomProduct.json"));
			        	request.body(IOUtils.toByteArray(fileinputstream1));		
			        	//System.out.println(request.body(json.toString()));
		    		   	response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems?updateTaxes=added");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	AddCustomProduct=response.prettyPeek().prettyPrint();
			        	System.out.println("Add Custom Product>>> "+AddCustomProduct);
			        	
			        	OrdersDataVerification.PostCustomProduct_GetProductDataVerifications();
			        	Assert.assertEquals(response.getStatusCode(),200);
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    
	        
		    //GET CustomProduct_LineItem under created order 
		    public static void GetCustomProduct_LineItem() throws IOException {
	        	 try 
			        {
	        		 
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	response=request.get(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId);
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	GetCustomProduct=response.prettyPeek().prettyPrint();
			        	System.out.println("Get Custom Product>>> "+GetCustomProduct);
			        	
			        	OrdersDataVerification.GetCustomProduct_GetProductDataVerifications();
			        	Assert.assertEquals(response.getStatusCode(),200);
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    //Get CustomProduct Line item with negative scenarios against field validation
		    public static void GetCustomProduct_LineItem_FieldValidaion() throws IOException {
	        	 try 
			        {
	        		 
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	response=request.get(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId);
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	GetCustomProduct=response.prettyPeek().prettyPrint();
			        	System.out.println("Get Custom Product>>> "+GetCustomProduct);
			        	
			        	OrdersDataVerification. GetCustomProduct_GetProduct_FieldDataVerifications();
			        	Assert.assertEquals(response.getStatusCode(),200);
			        	
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	    // Get Custom Product LineItem 
		    public static void GetAllCustomProduct_LineItem() throws IOException {
	        	 try 
			        {
	        		 
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	response=request.get(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	GetAllCustomProduct=response.prettyPeek().prettyPrint();
			        	System.out.println("Get All Custom Product>>> "+GetCustomProduct);
			        	Assert.assertEquals(response.getStatusCode(),200);
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        
	
	 //Import line item 
		    public static void Import_LineItem() throws IOException {
	        	 try 
			        {
	        		 
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		    FileInputStream fileinputstream1=new FileInputStream(new File("JsonFile\\importlineitem.json"));
		    		  
			        	request.body(IOUtils.toByteArray(fileinputstream1));		
			        	//System.out.println(request.body(json.toString()));
		    		   	Response response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/import");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("LineItemAdded >>> "+response.prettyPeek().prettyPrint());
			        	List<Integer> ids = response.jsonPath().getList("LineItems.Id");
			        	System.out.println(ids.size());
			        	ImportLineItemID = ids.get(0);
			        	System.out.println(ImportLineItemID);
			        	Assert.assertEquals(response.getStatusCode(),200);
			        	
			        	// validate required.time required
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 } 
	        //Verify payment calculations against posted line items
		    public static void GetAmountDue_FromOrder() throws IOException {
	        	 try 
			        {
			        	
	        		 GetCreatedOrder_FromID();

			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        
	        
	     //Post payments under created order
		    public static void PostPaymentsUnderOrder() throws IOException {
	        	 try 
			        {
	        		
	        		  	AmountToBePaid=Amountdue/2;
	        		  
	        		  	System.out.println(AmountToBePaid);
			        	Payment payloadpayment=new Payment(AmountToBePaid,"USD",true);
			        	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
			        	request.body(payloadpayment);
		    		    response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"payments");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	PaymentResponse=response.prettyPeek().prettyPrint();
			        	System.out.println("PostPaymentsUnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	
			        	OrdersDataVerification.PostPaymentVerification();
			        	Assert.assertEquals(response.getStatusCode(),200);

			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		  //Get all payments under created order with payment ID
		    public static void GetPaymentsRecordUnderOrder_PaymentID() throws IOException {
	        	 try 
			        {
	        		 	Response resp1=RestAssured.given()
	     	    		.auth().oauth2(accessToken)
	     	    		.header("Content-Type","application/x-www-form-urlencoded")
	     	    		.header("Accept","application/x-www-form-urlencoded")
	     	    		.get(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"payments"+"/"+PaymentId);
	     		         System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
	     		         GetPaymentResponse= resp1.prettyPeek().prettyPrint();
	     		          System.out.println("GetPaymentsRecordWithPaymentId >>> "+resp1.prettyPeek().prettyPrint());
	     		          
	     		          OrdersDataVerification.GetPaymentVerification();
	     		          Assert.assertEquals(resp1.getStatusCode(),200);
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		 
		    public static void PostRemaingPaymentsRecordsUnderOrder() throws IOException {
        	try 
		        {
		        	
		        	AmountRemaining=Amountdue-AmountToBePaid;
		        	Payment payloadpayment=new Payment(AmountRemaining,"USD",true);
		        	RequestSpecification request=RestAssured.given();
		        	request.header("Authorization", "Bearer " +accessToken);
		        	request.header("Content-Type","application/json");
		        	request.body(payloadpayment);
	    		    response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"payments");
		        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
		        	PaymentResponse=response.prettyPeek().prettyPrint();
		        	System.out.println("PostPaymentsUnderOrder >>> "+response.prettyPeek().prettyPrint());
		        	
		        	OrdersDataVerification.RemaingPaymentVerification();
		        	Assert.assertEquals(response.getStatusCode(),200);

		        } 
	        catch (Exception e) 
	        {
	            System.out.println("ERROR: " + e.getMessage());
	            Assert.fail(e.getMessage());
	        }
		
	 }  
		    
		    
	     //Get All payments records under created order
		    public static void GetAllPaymentsRecords() throws IOException {
	        	 try 
			        {
			        	
	        		 	Response resp1=RestAssured.given()
	     	    		.auth().oauth2(accessToken)
	     	    		.header("Content-Type","application/x-www-form-urlencoded")
	     	    		.header("Accept","application/x-www-form-urlencoded")
	     	    		.get(BaseURI+"api/v1/orders"+"/"+OrderId+"/payments");
	     		         System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
	     		         System.out.println("GetALLPayments >>> "+resp1.prettyPeek().prettyPrint());
	     		         Assert.assertEquals(resp1.getStatusCode(),200);
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    
		    
	      //Create Sales order under created order
		    public static void PostSalesOrders_UnderOrder() throws IOException {
	        	 try 
			        {
	        		 
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
			        	json.put("IncludeArtwork",true);
			        	json.put("IncludeNotes",true);
			        	json.put("IncludeInstructions",true);
			        	json.put("IncludePoReference",true);
			        	request.body(json.toString());
			        	System.out.println(request.body(json.toString()));
		    		    response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"salesorders");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	SalesOrdersResponse=response.prettyPeek().prettyPrint();
			        	System.out.println("PostSalesOrders_UnderOrder >>> "+SalesOrdersResponse);
			        	
			        	OrdersDataVerification.SalesOrdersDataValidation();
			        	Assert.assertEquals(response.getStatusCode(),201);

			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }    
	      //Post reorder under the created order
		    public static void PostReorder_UnderOrder() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
			        	json.put("IncludeArtwork",true);
			        	json.put("Customer","Auto Supplier ASIQA I");
			        	json.put("IncludeNotes",true);
			        	json.put("IncludeInstructions",true);
			        	json.put("IncludePoReference",true);
			        	request.body(json.toString());
			        	System.out.println(request.body(json.toString()));
		    		   	response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/reorder/order");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("PostReorder_UnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	PostReorder_UnderOrderResponse=response.prettyPeek().prettyPrint();
			        	
			        	OrdersDataVerification.PostReorderUnderOrderDataValidation();
			        	Assert.assertEquals(response.getStatusCode(),201);
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		  
		    public static void PostQuote_UnderOrder() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
			        	json.put("IncludeArtwork",true);
			        	json.put("IncludeNotes",true);
			        	json.put("IncludeInstructions",true);
			        	json.put("IncludePoReference",true);
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"quotes");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("PostQuote_UnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	OrdersDataVerification.PostQuoteUnderOrderDataValidation();
			        	Assert.assertEquals(201,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		   
		    public static void PostTitle_LineItem() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
		    		   	json.put("Type","order");
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/lineitems?updateTaxes=added");
			        	System.out.println("Post LineItem Title Status Code>>> "+response.getStatusCode());
			        	System.out.println("Post LineItem Title  >>> "+response.prettyPeek().prettyPrint());
			        	JsonPath jsonPathEvaluator = response.jsonPath();
				        LineItemId= jsonPathEvaluator.get("Id");
				        System.out.println("PostTitle_LineItem>>> "+ LineItemId);
			        	Assert.assertEquals(200,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	       
		    public static void UpdateTitle_LineItem() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
		    		   	json.put("Id",LineItemId);
		    		   	json.put("Type","Title");
		    		   	json.put("Name","LineItem");
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.put(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId+"?updateTaxes=added");
			        	System.out.println("Get UpdateTitle_LineItem Status Code>>> "+response.getStatusCode());
			        	System.out.println("UpdateTitle_LineItem >>> "+response.prettyPeek().prettyPrint());
			        	
			        	Assert.assertEquals(200,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 } 
		    //Genarate Email under purchase order document
		    public static void PostEmail_UnderOrder() throws IOException {
	        	 try 
			        {
	        		 	List<String> ToPOEmail=new ArrayList<String>();
	        		 	ToPOEmail.add("bnazir@asicentral.com");
	        		 	ToPOEmail.add("CRMRegression1@asicentral.com");
	        		 	ToPOEmail.add("asiqa102@asicentral.com");
	        		 	
	        		 	
	        		 	SentEmail_PO payloadEmail=new SentEmail_PO(OrderId,true,"po",507918952,394918);
	        		 	payloadEmail.setTo(ToPOEmail);
	        		 	payloadEmail.setCC(ToPOEmail);
	        		 	payloadEmail.setReplyTo(ToPOEmail);
	        		 	payloadEmail.setSubject("New Purchase Order"+OrderNumber+"from ASIQA Distributor III");
	        		 	payloadEmail.setBody("Hello Auto Supplier ASIQA I,Included is a Purchase Order.");
	        		 	System.out.println("payloadEmail"+payloadEmail.toString());
			        	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        
			        	request.header("Content-Type","application/json");
			        	request.header("Accept","application/x-www-form-urlencoded");
			        	request.body(payloadEmail);
		    		   	response=request.post(BaseURI+"api/v1/orders/email");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("PostReorder_UnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	PostEmail_UnderPurchaseOrderDocResponse=response.prettyPeek().prettyPrint();
			        	//OrdersDataVerification.PostEmailUnderPurchaseOrderDocumentDataValidation();
			        	Assert.assertEquals(response.getStatusCode(),200);
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    //Delete Order
		    public static void Delete_CreatedOrder() throws IOException {
	        	 try 
			        {
			        	
	        		 	Response resp1=RestAssured.given()
	     	    		.auth().oauth2(accessToken)
	     	    		.header("Content-Type","application/x-www-form-urlencoded")
	     	    		.header("Accept","application/x-www-form-urlencoded")
	     	    		.delete(BaseURI+"api/v1/orders"+"/"+OrderId);
	     		         System.out.println("Get Orders Status Code>>> "+resp1.getStatusCode());
	     		         System.out.println("Delete_CreatedOrder >>> "+resp1.prettyPeek().prettyPrint());
	     		         Assert.assertEquals(resp1.getStatusCode(),200);
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
		    
		  
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    

		    /*      @Test(priority = 13)
		    public void UpdateCustomProduct_LineItem() throws IOException {
	        	 try 
			        {
	        		 
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
			        
			        	request.expect().defaultParser(Parser.JSON);
			        	
			        	FileInputStream fileinputstream1=new FileInputStream(new File("JsonFile\\UpdateCustomProduct.json"));
			        	request.body(IOUtils.toByteArray(fileinputstream1));	
		    		   	response=request.put(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId+"?updateTaxes=none");
		    		   	System.out.println(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId+"?updateTaxes=none");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	UpdateCustomProduct=response.prettyPeek().prettyPrint();
			        	System.out.println("Update Custom Product>>> "+UpdateCustomProduct);
			        	OrdersDataVerification.UpdateCustomProduct_GetProductDataVerifications();
			        	Assert.assertEquals(response.getStatusCode(), 200);
			        	
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			//serialization using product id
		 }  */
	       
	  /*      @Test(priority = 11)
		    public void UpdatePaymentsRecordsUnderOrder() throws IOException {
	        	try 
			        {
			        	
	        		 	RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
		    		   	json.put("Amount",4.0);
		    		   	json.put("Id", PaymentId);
			        	request.body(json.toString());
		    		   	Response response=request.put(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"payments"+"/"+PaymentId);
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("Update Payments  >>> "+response.prettyPeek().prettyPrint());
			        	Assert.assertEquals(200,response.getStatusCode());
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        
	        
	        @Test(priority = 15)
		    public void PostQuote_UnderOrder() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
			        	json.put("IncludeArtwork",true);
			        	json.put("IncludeNotes",true);
			        	json.put("IncludeInstructions",true);
			        	json.put("IncludePoReference",true);
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/"+"quotes");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("PostQuote_UnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	Assert.assertEquals(201,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	      
	        @Test(priority = 17)
		    public void PostTitle_LineItem() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
		    		   	json.put("Type","order");
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.post(BaseURI+"api/v1/orders"+"/"+OrderId+"/lineitems?updateTaxes=added");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("PostPaymentsUnderOrder >>> "+response.prettyPeek().prettyPrint());
			        	JsonPath jsonPathEvaluator = response.jsonPath();
				        LineItemId= jsonPathEvaluator.get("Id");
				        System.out.println("PostTitle_LineItem>>> "+ LineItemId);
			        	Assert.assertEquals(200,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  
	        @Test(priority = 18)
		    public void UpdateTitle_LineItem() throws IOException {
	        	 try 
			        {
	        		 RequestSpecification request=RestAssured.given();
			        	request.header("Authorization", "Bearer " +accessToken);
			        	request.header("Content-Type","application/json");
		    		   	JSONObject json=new JSONObject();
		    		   	json.put("Id",LineItemId);
		    		   	json.put("Type","Title");
		    		   	json.put("Name","LineItem");
			        	request.body(json.toString());
			        	 System.out.println(request.body(json.toString()));
		    		   	Response response=request.put(BaseURI+"api/v1/orders"+"/"+OrderId +"/lineitems/"+LineItemId+"?updateTaxes=added");
			        	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
			        	System.out.println("UpdateTitle_LineItem >>> "+response.prettyPeek().prettyPrint());
			        	
			        	Assert.assertEquals(200,response.getStatusCode());
	     
			        } 
		        catch (Exception e) 
		        {
		            System.out.println("ERROR: " + e.getMessage());
		            Assert.fail(e.getMessage());
		        }
			
		 }  */
	  
	 }
	
		
	
	
	

