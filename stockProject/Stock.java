//Chris Robertson
//Java project 1
//10-9-17

package stockProject;
import java.util.*;

public class Stock
{
	private String name;
	private ArrayList<Week> Weeks;
	
	public Stock(String [] tokens)
	{//Constructor which applies the name to the new stock
		//Then populates the first week using the line of tokens provided
		name = tokens[1];
		Weeks = new ArrayList<Week>(0);
		addWeek(tokens[2], tokens[3], tokens[6]);
	}
	
	public void addWeek(String date, String open, String close)
	{
		Weeks.add(new Week(date, open, close));
		//Passes the appropriate data for the week into the Week constructor
	}
	
	public int numOfWeeks()
	{
		return Weeks.size();
	}
	
	public Week getWeek(int week)
	{
		return Weeks.get(week);
	}
	
	public String getName()
	{
		return name;
	}
}
