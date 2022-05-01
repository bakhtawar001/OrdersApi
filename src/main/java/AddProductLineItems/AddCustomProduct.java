package AddProductLineItems;

public class AddCustomProduct {
	private String Type;
	private String Name;
	private String Description;
	private Totals Totals;
	private Supplier Supplier;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	public Totals getTotals() {
		return Totals;
	}
	public void setTotals(Totals totals) {
		Totals = totals;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	@Override
	public String toString() {
		return "AddCustomProduct [Type=" + Type + ", Name=" + Name + ", Description=" + Description + ", Totals="
				+ Totals + ", Supplier=" + Supplier + "]";
	}

}
