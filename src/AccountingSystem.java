//Name: Ryan Rodrigues
//Student ID: 500915227

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

class AccountingSystem 
{
	private int id, month;
	private String type, salesPerson, date;
	private Car car;
	
	static int returnHelper = 0;
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM dd, yyyy");
	
	static HashMap<Integer, Transaction> transactionMap = new HashMap<>();
	static HashMap<Integer, Double> salesMap = new HashMap<>();
	static HashMap<String, String> salesPersonTransaction = new HashMap<>();
	static HashMap<Integer, String> monthTransaction = new HashMap<>();
	static HashMap<Integer , Integer> checker = new HashMap<>();
	
	/**This is an empty constructor
	 */
	public AccountingSystem()
	{
		
	}
	
	/**This method generates a random number
	 * @param min The minimum number
	 * @param max The maximum number
	 * @return a random integer between the minimum and maximum
	 */
	public int getRandomNum(int min, int max)
	{
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
	/**This constructor adds the information about the transactions, sales stats, sales associate and month of a transaction to their respective hash maps
	 * @param dates The date of the transaction
	 * @param car The car that was bought or returned
	 * @param salesPerson The sales associate that made the transaction
	 * @param type The type of transaction (BUY or RET)
	 * @param salesPrice The price of the car
	 * @param month The month of the transaction;
	 */
	public AccountingSystem(Calendar dates, Car car, String salesPerson, String type, int month)
	{
		id = this.getTransaction();
		date = sdf.format(dates.getTime());
		this.car = car;
		this.salesPerson = salesPerson;
		this.type = type;
		this.month = month;
		
		if(type.equals("BUY"))
		{
			if(salesPersonTransaction.containsKey(salesPerson))
			{
				String value = salesPersonTransaction.get(salesPerson) + " " + String.valueOf(id);
				salesPersonTransaction.put(salesPerson, value);
			}
			else if(!(salesPersonTransaction.containsKey(salesPerson)))
			{
				salesPersonTransaction.put(salesPerson, String.valueOf(id));
			}
			returnHelper = id;
			double salesPrice = car.getPrice();
			salesMap.put(id, salesPrice);	
		}
		this.add(id, new Transaction(id, date, car, salesPerson, type, month));
		
		if(monthTransaction.containsKey(month))
		{
			String value = monthTransaction.get(month) + " " + String.valueOf(id);
			monthTransaction.put(month, value);
		}
		else if(!(monthTransaction.containsKey(month)))
		{
			monthTransaction.put(month, String.valueOf(id));
		}
	}
	
	/**This method adds the transaction information to the transaction hash map
	 * @param id
	 * @param transaction
	 */
	public void add(int id , Transaction transaction )
	{
		transactionMap.put(id, transaction);
	}
	
	/**This method gets the transaction
	 * @return the transaction
	 */
	public int getTransaction()
	{
		int trans = getRandomNum(1, 98);
		while(checker.containsKey(trans))
		{
			trans = getRandomNum(1, 98);
		}
		checker.put(trans, 1);
		return trans;
	}
	
	/**This method gets the transaction hash map
	 * @return The transaction hash map
	 */
	public HashMap<Integer, Transaction> getTransactionMap()
	{	
		return transactionMap;
	}
	
	/**This method gets the sales hash map
	 * @return The sales hash map
	 */
	public HashMap<Integer, Double> getSalesMap()
	{
		return salesMap;
	}
	
	/**This method gets the associates who made sales
	 * @return The associates who made sales
	 */
	public HashMap<String, String> getSalesPersonTransaction()
	{
		return salesPersonTransaction;
	}
	
	/**This method gets the transactions per month
	 * @return The transactions per month
	 */
	public HashMap<Integer, String> getMonthTransaction()
	{
		return monthTransaction;
	}
	
	/**This method gets the return 
	 * @return	The return helper
	 */
	public int getReturnHelper()
	{
		return returnHelper;
	}
}
