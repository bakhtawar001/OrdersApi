package CreateOrder;

public class Currencies {
	
	private int Id;
	private String CurrancyCode;
	private float ConversionRate;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCurrancyCode() {
		return CurrancyCode;
	}
	public void setCurrancyCode(String currancyCode) {
		CurrancyCode = currancyCode;
	}
	public float getConversionRate() {
		return ConversionRate;
	}
	public void setConversionRate(float conversionRate) {
		ConversionRate = conversionRate;
	}
	

}
