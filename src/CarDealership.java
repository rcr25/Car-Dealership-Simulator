//Name: Ryan Rodrigues
//Student ID: 500915227

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;

class CarDealership
{
	private ArrayList<Car> cars;
	private boolean AWDFill, elecFill, priceFill;
	private double max, min;
	
	static DecimalFormat df2 = new DecimalFormat(".##");
	SalesTeam team = new SalesTeam();
	AccountingSystem bank = new AccountingSystem();
	
	/**This constructor sets the instance variable to an empty array list
	 */
	public CarDealership()
	{
		cars = new ArrayList<Car>();
	}
	
	/**This method adds a car to the list of cars in the dealership
	 * @param newCars The car you want to add to the dealership
	 */
	public void AddCars(ArrayList<Car> newCars)
	{
		cars.addAll(newCars);
	}
	
	/**This method buys a car from the lot and removes it from the list of cars
	 * @param VIN The vehicle identification number
	 * @return the bought car
	 */
	public Car buyCar(int VIN)
	{
		int key = bank.getReturnHelper();
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		transactionMap = bank.getTransactionMap();
		Transaction transaction = new Transaction();
		transaction = transactionMap.get(key);
		System.out.println(transaction.display());
		return cars.remove(VIN);
	}
	
	/**This method returns a bought car to the lot
	 * @param car The car you wish to return
	 */
	public void returnCar(Car car)
	{
		if(car != null) 
		{
			cars.add(car);
		}
	}
	
	/**This helper method displays the transaction for a return function
	 */
	public void returnDisplay()
	{
		int key = bank.getReturnHelper();
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		transactionMap = bank.getTransactionMap();
		Transaction transaction = new Transaction();
		transaction = transactionMap.get(key);
		System.out.println(transaction.display());
	}
	/**This method prints the information about the cars
	 */
	public void displayInventory()
	{
		ArrayList<Integer> test = new ArrayList<Integer>();
		if(AWDFill == true)
		{
			for(int i = 0; i < cars.size(); i++)
			{
				if(!(cars.get(i).getAWD() == true))
				{
					test.add(i);
				}
			}
		}
		if(elecFill == true)
		{
			for(int i = 0; i < cars.size(); i++)
			{
				if(!(cars.get(i).getPower() == Vehicle.PowerSource.ELECTRIC_MOTOR))
				{
					test.add(i);
				}
			}
		}
		if(priceFill == true)
		{
			for(int i = 0; i < cars.size(); i++)
			{
				if(!(cars.get(i).getPrice() <= max && cars.get(i).getPrice() >= min))
				{
					test.add(i);
				}
			}
		}
		for (int i = 0; i < cars.size(); i++)
        {
            if (!(test.contains(i)))
            {
                System.out.println(i + " " + cars.get(i).display());
            }
            else
            {
                continue;
            }
        }
	}
	
	/**This method sets the electric filter for use
	 */
	public void filterByElectric()
	{
		elecFill = true;
	}
	
	/**This method sets the AWD filter for use
	 */
	public void filterByAWD()
	{
		AWDFill = true;
	}
	
	/**This method sets the price filter for use
	 * @param minPrice The minimum price for a car
	 * @param maxPrice The maximum price for a car
	 */
	public void filterByPrice(double minPrice, double maxPrice)
	{
		min = minPrice;
		max = maxPrice;
		priceFill = true;
	}
	
	/**This method clears all filters
	 */
	public void FiltersClear()
	{
		elecFill = false;
		AWDFill = false;
		priceFill = false;
	}
	
	class SafteySort implements Comparator<Car>
	{
		/**This method is used to compare the safety rating of two cars
		 */
		public int compare(Car a, Car b)
    	{
			if (a.getSafetyRating() > b.getSafetyRating()) return 1;
			else if (a.getSafetyRating() < b.getSafetyRating()) return -1;
			else return 0;
    	}
	}
	
	class RangeSort implements Comparator<Car>
	{
		/**This method is used to compare the mileage of two cars
		 */
		public int compare(Car a, Car b)
    	{
			if (a.getMaxRange() > b.getMaxRange()) return 1;
			else if (a.getMaxRange() < b.getMaxRange()) return -1;
			else return 0;
    	}
	}
	
	/**This method sorts the cars by price
	 */
	public void SortByPrice()
	{
		Collections.sort(cars);
	}
	
	/**This method sorts the cars by safety rating
	 */
	public void SortBySafetyRating()
	{
		Collections.sort(cars, new SafteySort());
	}
	
	/**This method sorts the cars by mileage
	 */
	public void SortByMaxRange()
	{
		Collections.sort(cars, new RangeSort());
	}
	
	/**This method displays all the transaction in the year
	 */
	public void dispayAllSales()
	{
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		transactionMap = bank.getTransactionMap();
		if(transactionMap.isEmpty())
		{
			System.out.println("There are no sales this year");
		}
		else 
		{	
			for(int key : transactionMap.keySet())
			{
				Transaction transaction = transactionMap.get(key);
				System.out.println(transaction.display());		
			}
		}
	}
	
	/**This method display the sales team
	 */
	public void displaySalesTeam()
	{
		LinkedList<String> salesTeam = team.getTeam();
		for(int i = 0 ; i < salesTeam.size() ; i++)
		{
			System.out.print(salesTeam.get(i) + " ");
		}
	}
	
	/**This method finds the top sales associate;
	 */
	public void findTopSA()
	{
		int counter = 0;
		int max = 0;
		String topSA = "";
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		HashMap<String, String> salesPersonTransaction = new HashMap<>();
		transactionMap = bank.getTransactionMap();
		salesPersonTransaction = bank.getSalesPersonTransaction();
		if(salesPersonTransaction.isEmpty())
		{
			System.out.println("No associates have made a sale");
		}
		else
		{
			for(String key : salesPersonTransaction.keySet())
			{
				if(salesPersonTransaction.get(key).length() > max)
				{
					max = salesPersonTransaction.get(key).length();
					topSA = key;
				}
				
				else if(max > 0 && salesPersonTransaction.get(key).length() == max)
				{
					topSA = topSA + " " + key;
				}
			}
			Scanner scanner = new Scanner(topSA);
			String associate = scanner.next();
			Scanner counterScan = new Scanner(salesPersonTransaction.get(associate));
			while(counterScan.hasNextInt())
			{
				int topAssociate = counterScan.nextInt();
				counter++;
			}
			Scanner topScanner = new Scanner(topSA);
			while(topScanner.hasNext())
			{
				String topSalesPerson = topScanner.next();
				System.out.println("Top SA: " + topSalesPerson + " " + counter );			
			}
		}	
	}
	
	/**This method gets all transactions of a certain month
	 * @param m The month of which the transactions have occurred
	 */
	public void getMonthTransactions(int m)
	{	
		HashMap<Integer, String> monthTransaction = new HashMap<Integer, String>();
		HashMap<Integer, Transaction> transactionMap = new HashMap<Integer, Transaction>();
		transactionMap = bank.getTransactionMap();
		monthTransaction = bank.getMonthTransaction();
		if(!(monthTransaction.containsKey(m)))
		{
			System.out.println("There are no transactions in this month");
		}
		else
		{
			Scanner scanner = new Scanner(monthTransaction.get(m));
			while(scanner.hasNextInt())
			{
				Transaction transaction = transactionMap.get(scanner.nextInt());
				System.out.println(transaction.display());
			}
		}			
	}
	
	/**This method displays the sales stats for the year
	 */
	public void displaySalesStats()
	{
		HashMap<Integer, Double> salesMap = new HashMap<>();
		salesMap = bank.getSalesMap();
		int counter = 0;
		if(salesMap.isEmpty())
		{
			System.out.println("No sales stats to show");
		}
		else
		{
			double total = 0;
			for(int key : salesMap.keySet())
			{
				total = total + salesMap.get(key);
				counter++;
			}
			System.out.println("Total Sales: $" + total + " Total Sold: " + counter + " Avg Sales: $" + df2.format(total/12));
		}
	}
	
	/**This method finds the total returns in a year
	 */
	public void totRET()
	{
		int count = 0;
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		transactionMap = bank.getTransactionMap();
		for(int key : transactionMap.keySet())
		{
			if(transactionMap.get(key).getType().equals("RET"))
			{
				count++;
			}
		}
		System.out.println("Total Returned: " + count);
	}
	
	/**This method finds the highest sales month
	 */
	public void findHM()
	{
		int max = 0;
		String bestMonth = "";
		HashMap<Integer, Transaction> transactionMap = new HashMap<>();
		HashMap<Integer, String> monthTransaction = new HashMap<>();
		monthTransaction = bank.getMonthTransaction();
		transactionMap = bank.getTransactionMap();
		if(monthTransaction.isEmpty())
		{
			System.out.println("");
		}
		else
		{
			for(int key : monthTransaction.keySet())
			{
				if(monthTransaction.get(key).length() > max)
				{
					bestMonth = this.getMonth(key);
					max = monthTransaction.get(key).length();
				}
				else if(monthTransaction.get(key).length() > 0 && monthTransaction.get(key).length() == max)
				{
					bestMonth = bestMonth + " " + this.getMonth(key);
				}
			}
		}
		if(!(bestMonth.equals("")))
		{
			System.out.println("Best Month: " + bestMonth);
		}
	}
	
	/**This helper method gets the month for findHM()
	 */
	private String getMonth(int m)
	{
		return new DateFormatSymbols().getMonths()[m-1];
	}
}