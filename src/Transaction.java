//Name: Ryan Rodrigues
//Student ID: 500915227

import java.text.SimpleDateFormat;

class Transaction 
{
	private int id, month;
	private Car car;
	private String salesPerson, type, date;
	
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy");
	
	/**This is an empty constructor
	 */
	public Transaction()
	{
		
	}
	
	/**This constructor initializes the instant variables
	 * @param id The transaction ID
	 * @param date The date of the transaction
	 * @param car The car that was bought or returned
	 * @param salesPerson The sales associate that made the transaction
	 * @param type The type of transaction (BUY or RET)
	 * @param month The month of the transaction
	 */
	public Transaction(int id, String date, Car car, String salesPerson, String type, int month)
	{
		this.id = id;
		this.date = date;
		this.car = car;
		this.salesPerson = salesPerson;
		this.type = type;
		this.month = month;
	}

	/**This method gets the ID of the transaction
	 * @return The transaction ID
	 */
	public int getID() 
	{
		return id;
	}
	
	/**This method gets the date of the transaction
	 * @return The date of the transaction
	 */
	public String getDate()
	{
		return date;
	}
	
	/**This method gets the sales associate that made the transaction
	 * @return The sales associate that made the transaction
	 */
	public String getSalesPerson() 
	{
		return salesPerson;
	}
	
	/**This method gets the car that was bought or returned
	 * @return The car that was bought or returned
	 */
	public Car getCar()
	{
		return car;
	}
	
	/**This method gets the type of transaction (BUY or RET)
	 * @return The type of transaction (BUY or RET)
	 */
	public String getType()
	{
		return type;
	}
	
	/**This method display the transaction
	 * @return The transaction
	 */
	public String display() 
	{
		return "ID: " + this.getID() + " " + this.getDate() + " " + this.getType() + " $" + car.getPrice() + " Sales Associate: " + this.getSalesPerson() + " " + car.display();
	}
}
