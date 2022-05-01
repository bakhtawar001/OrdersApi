package Email;

import java.util.ArrayList;
import java.util.List;

public class SentEmail_PO {
	
	private int OrderId;
	private boolean IncludeDocument;
	private String DocumentType;
	private List<String> To;
	private List<String> CC;
	private List<String> ReplyTo;
	private String Subject;
	private String Body;
	private int SupplierId;
	private int From;
	
	
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public boolean isIncludeDocument() {
		return IncludeDocument;
	}
	public void setIncludeDocument(boolean includeDocument) {
		IncludeDocument = includeDocument;
	}
	public String getDocumentType() {
		return DocumentType;
	}
	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}

	public List<String> getTo() {
		return To;
	}
	public void setTo(List<String> to) {
		To = to;
	}
	public List<String> getCC() {
		return CC;
	}
	public void setCC(List<String> cC) {
		CC = cC;
	}
	public List<String> getReplyTo() {
		return ReplyTo;
	}
	public void setReplyTo(List<String> replyTo) {
		ReplyTo = replyTo;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public int getFrom() {
		return From;
	}
	public void setFrom(int from) {
		From = from;
	}
	public SentEmail_PO(int OrderId,boolean IncludeDocument,String DocumentType,int SupplierId,int From) {
	
		this.OrderId=OrderId;
		this.IncludeDocument=IncludeDocument;
		this.DocumentType=DocumentType;
		this.SupplierId=SupplierId;
		
		
		
		
	}
	@Override
	public String toString() {
		return "SentEmail_PO [OrderId=" + OrderId + ", IncludeDocument=" + IncludeDocument + ", DocumentType="
				+ DocumentType + ", To=" + To + ", CC=" + CC + ", ReplyTo=" + ReplyTo + ", Subject=" + Subject
				+ ", Body=" + Body + ", SupplierId=" + SupplierId + ", From=" + From + "]";
	}
	
	
	
	
	

}
