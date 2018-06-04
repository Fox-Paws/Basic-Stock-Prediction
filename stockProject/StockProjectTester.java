//Chris Robertson
//Java project 1
//10-9-17

package stockProject;

public class StockProjectTester
{
	public static void main(String[] args)
	{
		StockDataADT myData = new Data("dow_jones_index1_3.data");
		System.out.println("Number of stocks in file: " + myData.getStockCount());
		System.out.println("Number of weeks in file: " + myData.getWeekCount());
		System.out.println(myData.getStocksWeek(0, 0));
		System.out.println(myData.getStockName(29));
		System.out.println(myData.getWeekDate(3));
		
		PredictorADT myPred = new Predictor();
		myPred.setDataSet(myData);
		myPred.predict();
		System.out.println(myPred.getPortfolioAmount());
	}
}
