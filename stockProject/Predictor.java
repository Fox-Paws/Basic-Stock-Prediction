//Chris Robertson
//Java project 1
//10-9-17

package stockProject;

public class Predictor implements PredictorADT
{
	private double cash;
	private StockDataADT data;
	
	public Predictor()
	{
		setPortfolioAmount(10000.00);
	}
	
	public void setPortfolioAmount(double amount)
	{
		cash = amount;
	}

	public double getPortfolioAmount()
	{
		return cash;
	}

	public void setDataSet(StockDataADT dataSet)
	{
		data = dataSet;
	}

	public void predict()
	{//Very *VERY* simple predictor, just looks for positive trends from the past week
		//It is still fairly consistent at providing positive return
		//At least on this data set
		Week current;
		Week previous;
		int stockNum = 0;
		for(int i = 0; i < (data.getStockCount() - 1); i++)
		{
			for (int j = 1; j < (data.getWeekCount() / data.getStockCount()) - 1; j++)
			{//Dynamic week counting just in case that changes
				previous = data.getStocksWeek(i, j - 1);
				current = data.getStocksWeek(i, j);
				if (previous.getClose() < current.getOpen())
				{ //If there was a price increase since last Friday
					//This code is always going to be from the perspective that today is Monday
					//Since you need to predict on the day you are buying
					if (previous.getOpen() > previous.getClose())
					{ //There might be a decline soon if the price has been constantly going up
						//So don't invest as much, 60%
						stockNum = (int)((cash * 0.6) / current.getOpen());
						cash -= (stockNum * current.getOpen());
					}
					else
					{ //The rising price developed recently, meaning now is a relative low point in price
						//So invest a crapton, 90% of current cash
						stockNum = (int)((cash * 0.9) / current.getOpen());
						cash -= (stockNum * current.getOpen());
					}
					//This is effectively Friday, the end of the week.
					//Calculate what your stock currently is worth, sell it, add it to cash
					cash += (stockNum * current.getClose());
					stockNum = 0;
				}
			}
		}
	}
}
