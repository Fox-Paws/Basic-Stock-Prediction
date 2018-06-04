//Chris Robertson
//Java project 1
//10-9-17

package stockProject;

public interface StockDataADT
{
	public int getStockCount(); //Return number of stocks
	public int getWeekCount(); //Return number of weeks
	public Week getStocksWeek(int stock, int week);
	//Return a Week given index of which stock and index of which week
	public String getStockName(int stock); //Return the name of a stock given its index
	public String getWeekDate(int week); //Return the date of the week given its index
}
