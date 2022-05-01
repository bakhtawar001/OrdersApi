package CreateOrder;

public class Payment {
	
	float Amount;
	String CurrencyCode;
    boolean IsFullPayment;
    
    
    public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}


	public String getCurrencyCode() {
		return CurrencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}

	public boolean isIsFullPayment() {
		return IsFullPayment;
	}

	public void setIsFullPayment(boolean isFullPayment) {
		IsFullPayment = isFullPayment;
	}

	public Payment(float amountdue, String CurrencyCode, boolean IsFullPayment) {
        this.Amount = amountdue;
        this.CurrencyCode = CurrencyCode;
        this.IsFullPayment = IsFullPayment;
    }

	@Override
	public String toString() {
		return "Payment [Amount=" + Amount + ", CurrencyCode=" + CurrencyCode + ", IsFullPayment=" + IsFullPayment
				+ "]";
	}

	

   

    // other getters & setters excluded for brevity

    
}
