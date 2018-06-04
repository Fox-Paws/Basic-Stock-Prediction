//Chris Robertson
//Java project 1
//10-9-17

package stockProject;

public interface PredictorADT
{
	public void setPortfolioAmount(double amount);
	//Set current amount of cash on hand
	
	public double getPortfolioAmount();
	//Gets current amount of cash on hand
	public void setDataSet(StockDataADT dataSet);
	//Sets the local DataADT object
	
	public void predict();
	//Start prediction based on data set in setDataSet
}
