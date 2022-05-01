package AddProductLineItems;

public class Totals {
	
	private float TaxableAmount;
	private float Amount;
	private float Cost;
	private float Margin;
	private float SalesTax;
	
	
	public float getSalesTax() {
		return SalesTax;
	}
	public void setSalesTax(float salesTax) {
		SalesTax = salesTax;
	}
	public float getTaxableAmount() {
		return TaxableAmount;
	}
	public void setTaxableAmount(float taxableAmount) {
		TaxableAmount = taxableAmount;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public float getCost() {
		return Cost;
	}
	public void setCost(float cost) {
		Cost = cost;
	}
	public float getMargin() {
		return Margin;
	}
	public void setMargin(float margin) {
		Margin = margin;
	}
	@Override
	public String toString() {
		return "Totals [TaxableAmount=" + TaxableAmount + ", Amount=" + Amount + ", Cost=" + Cost + ", Margin=" + Margin
				+ ", SalesTax=" + SalesTax + "]";
	}
	
	
}
