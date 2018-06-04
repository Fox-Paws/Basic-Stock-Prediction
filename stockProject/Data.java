//Chris Robertson
//Java project 1
//10-9-17

package stockProject;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Data implements StockDataADT
{
	private ArrayList<Stock> Stocks;
	private String fileName;
	
	public Data(String fn)
	{
		fileName = fn;
		initialize();
	}
	
	public int getStockCount()
	{
		return Stocks.size();
	}

	public int getWeekCount()
	{
		int sum = 0;
		for (Stock temp : Stocks)
		{//Adds up all the number of weeks of each stock, just in case they aren't all equal
			sum += temp.numOfWeeks();
		}
		return sum;
	}

	public Week getStocksWeek(int stock, int week)
	{
		return Stocks.get(stock).getWeek(week);
	}

	public String getStockName(int stock)
	{
		return Stocks.get(stock).getName();
	}

	public String getWeekDate(int week)
	{
		return Stocks.get(0).getWeek(week).getDate();
	}
	
	private void initialize()
	{
		Stocks = new ArrayList<Stock>(0); //Array started with 0 entries so "add" makes sense
		String aline;
		String [] tokens;
		File file = new File(fileName);
		Scanner scan;
		try { //Try/Catch for file name given in tester
			scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				aline = scan.nextLine();
				if (aline.substring(0,1).equals("q"))
				{//If the description of columns is on the first line, skip it
					aline = scan.nextLine();
				}
				tokens = aline.split(",");
				if (aline.contains(",,,"))
				{
					Stocks.add(new Stock(tokens));
					//Constructor for Stock stores the name and data for first week
					//So passing the entire line is necessary
				}
				else
				{
					Stocks.get(Stocks.size() - 1).addWeek(tokens[2], tokens[3], tokens[6]);
					//Since the stock already has a name, only the data for week is necessary
					//Tokens[2] contains the date
					//Tokens[3] contains the opening price
					//Tokens[6] contains the closing price
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			System.exit(1); //Terminates program so it doesn't continue, because no data is accessible
		}
	}
}
