//Chris Robertson
//Java project 1
//10-9-17

package stockProject;

public class Week
{
	private String date;
	private double open;
	private double close;
	
	public Week (String inDate, String inOpen, String inClose)
	{
		date = inDate;
		open = Double.parseDouble(inOpen.substring(1));
		//Parses the open price without the $
		close = Double.parseDouble(inClose.substring(1));
	}
	
	public String toString()
	{
		String toReturn;
		toReturn = "Date: " + date + " Open price: $" + open + " Close price: $" + close;
		return toReturn;
		//Since we return a Week object in the interface, might as well make a toString
	}
	
	public String getDate()
	{
		return date;
	}
	
	public double getOpen()
	{
		return open;
	}
	
	public double getClose()
	{
		return close;
	}
}
