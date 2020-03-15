package Bill;

public class Bill 
{
	
	public Bill(String aPath, String aSupplier, String aDate, Float aPrice, String aDescription, String aEndOfGuarantee)
	{
		path = aPath;
		supplier = aSupplier;
		date = aDate;
		price = aPrice;
		description = aDescription;
		endOfGuarantee = aEndOfGuarantee;
	}

	public String path;
	public String supplier;
	public String date;
	public Float price;
	public String description;
	public String endOfGuarantee;
}
