package OrdersAPI.API;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ExecutionFile {
	
	static String Suite="OrdersAPI.html";
	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException{

		OrdersAPI.StartupReportProperty(Suite);
	} 

	 @Test(priority = 1)
	 public void Orders_Signin() throws IOException
	 { 
		 OrdersAPI.Orders_Signin();
	 
	 }
	 
	 @Test(priority = 2)
	 public void Get_AllOrders() throws IOException
	 {
		 OrdersAPI.Get_Orders();
	 }
	 @Test(priority = 3)
	 public  void POST_Orders() throws IOException
	 {
		 OrdersAPI.POST_Orders();
	 }
	 
	 @Test(priority = 4)
	 public  void GetCreatedOrder_FromID() throws IOException 
	 {
		 OrdersAPI.GetCreatedOrder_FromID();
	 }
	 
	 @Test(priority = 5)
	 public static void GetCreatedOrder_FromNumber() throws IOException
	 {
		 OrdersAPI.GetCreatedOrder_FromNumber();
	 }
	
	 @Test(priority = 6)
	 public static void POSTNotes_Order() throws IOException
	 {
		 OrdersAPI.POSTNotes_Order();
	 }
	 @Test(priority = 7)
	 public static void UpdateNotes_Order() throws IOException
	 {
		 OrdersAPI.UpdateNotes_Order();
	 }
	 @Test(priority =8)
	 public static void GETCreatedNotes_NotesID() throws IOException 
	 {
		 
		 OrdersAPI.GETCreatedNotes_NotesID();
	 }
	
	 @Test(priority = 9)
	 public static void GETAllNotes() throws IOException 
	 {
		 OrdersAPI.GETAllNotes();
	 }
	 @Test(priority =10)
	 public static void Delete_CreatedNotes() throws IOException 
	 {
		 
		 OrdersAPI.DeleteCreatedNotes();
	 }
	 @Test(priority = 11)
	 public static void PostCustomProduct_LineItem() throws IOException 
	 {
		 OrdersAPI.PostCustomProduct_LineItem();
	 }
	 @Test(priority = 12)
	 public static void PostCustomProduct_LineItem_FieldValidaion() throws IOException 
	 {
		 OrdersAPI.GetCustomProduct_LineItem_FieldValidaion();
	 }
	 
	 @Test(priority = 13)
	 public static void GetCustomProduct_LineItem() throws IOException 
	 {
		 OrdersAPI.GetCustomProduct_LineItem();
	 }
	 @Test(priority = 14)
	 public static void GetAllCustomProduct_LineItem() throws IOException 
	 {
		 OrdersAPI.GetAllCustomProduct_LineItem();
	 }
	 @Test(priority = 15)
	 public static void Import_LineItem() throws IOException 
	 {
		 OrdersAPI.Import_LineItem(); 
	 }
	 @Test(priority = 16)
	 public static void GetAmountDue_FromOrder() throws IOException 
	 {
		 OrdersAPI.GetAmountDue_FromOrder();
	 }
	
	 @Test(priority = 17)
	 public static void PostPaymentsUnderOrder() throws IOException 
	 {
		 OrdersAPI.PostPaymentsUnderOrder();
	 }
	 @Test(priority = 18)
	 public static void GetPaymentsRecordUnderOrder_PaymentID() throws IOException
	 {
		 OrdersAPI.GetPaymentsRecordUnderOrder_PaymentID();
	 }
	 @Test(priority = 19)
	 public static void UpdatePaymentsRecordUnderOrder() throws IOException
	 {
		 OrdersAPI.PostRemaingPaymentsRecordsUnderOrder();
	 }
	 
	 @Test(priority = 20)
	 public static void GetAllPaymentsRecords() throws IOException
	 {
		 OrdersAPI.GetAllPaymentsRecords();
	 }
	 
	 @Test(priority = 21)
	 public static void PostSalesOrders_UnderOrder() throws IOException
	 {
		 OrdersAPI.PostSalesOrders_UnderOrder();
	 }
	 
	 @Test(priority = 22)
	 public static void PostReorder_UnderOrder() throws IOException 
	 {
		 OrdersAPI.PostReorder_UnderOrder();
	 }
	 
	 @Test(priority = 23)
	 public static void PostTitle_LineItem() throws IOException 
	 {
		 OrdersAPI.PostTitle_LineItem();
	 }
	 @Test(priority = 24)
	 public static void PostQuote_UnderOrder() throws IOException 
	 {
		 OrdersAPI.PostQuote_UnderOrder();
	 }
	 @Test(priority = 25)
	 public static void UpdateTitle_LineItem()  throws IOException 
	 {
		 OrdersAPI.UpdateTitle_LineItem() ;
	 }
	 @Test(priority = 26)
	 public static void PostEmail_UnderOrder() throws IOException 
	 {
		 OrdersAPI.PostEmail_UnderOrder();
	 }
	 @Test(priority = 27)
	 public static void Delete_CreatedOrder() throws IOException 
	 {
		 OrdersAPI.Delete_CreatedOrder();
	 }
	 @AfterMethod
		public void getResult(ITestResult result){
		 OrdersAPI.test = OrdersAPI.extent.createTest(result.getName());
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			OrdersAPI.test.log(Status.PASS, result.getMethod().getDescription());
			OrdersAPI.test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case is Passed", ExtentColor.GREEN));
			OrdersAPI.extent.flush();
		}
		if(result.getStatus()==ITestResult.FAILURE)
		{
			OrdersAPI.test.log(Status.FAIL, result.getMethod().getDescription());
			OrdersAPI.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
			OrdersAPI.test.fail(result.getThrowable());
			OrdersAPI.extent.flush();
		}
			
			
		}
}
	 
