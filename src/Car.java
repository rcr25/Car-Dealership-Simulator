//Name: Ryan Rodrigues
//Student ID: 500915227

class Car extends Vehicle implements Comparable<Car>
{
	public Model model;
	private int maxRange;
	private double safetyRating, price;
	private boolean AWD;
	
	public static enum Model
	{
		SEDAN, SUV, SPORTS, MINIVAN;
	}
	
	/**
	 * A constructor method that initialize the instance variables and inherits variables from class Vehicle
	 * @param VIN The vehicle identification number
	 * @param mfr The manufacturer
	 * @param color The color of the car
	 * @param model The model of the car
	 * @param power The power of the car
	 * @param safetyRating The safety rating of the car
	 * @param maxRange The mileage
	 * @param AWD If the car is all wheel drive or not
	 * @param price The price of the car
	 */
	public Car(int VIN, String mfr, String color, Model model, PowerSource power, double safetyRating, int maxRange, boolean AWD, double price)
	{
		super(VIN, mfr, color, power);
		this.model = model;
		this.maxRange = maxRange;
		this.safetyRating = safetyRating;
		this.price = price;
		this.AWD = AWD;
	}
	
	/**This method returns the information about each car
	 * @return The information about the car
	 */
	public String display()
	{
		return super.display() + " " + model + " " + getPower() + " " + safetyRating + " " 
		+ maxRange + " " + AWD + " " + price;
	}
	
	/**This method compares two cars to see if they are the same car
	 */
	public boolean equals(Object other)
	{
		Car otherCar = (Car) other;
		return super.equals(otherCar) && this.model == otherCar.model 
		&& this.AWD == otherCar.AWD; 
	}
	
	/**This method compares the price of two cars
	 */
	public int compareTo(Car other)
	{
		if (this.price > other.price) return 1;
		else if (this.price < other.price) return -1;
		else return 0;
	}
	
	/**This method sets a car to all wheel drive or two wheel drive
	 * @param AWD If the car is all wheel drive or not
	 */
	public void setAWD(boolean AWD)
	{
		this.AWD = AWD;
	}
	
	/**This method gets the drive wheel of the car
	 * @return If a car is all wheel drive or not
	 */
	public boolean getAWD()
	{
		return AWD;
	}
	
	/**This method sets the price of a car
	 * @param price The price of the car
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**This method gets the price of the car
	 * @return The price of the car
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**This method sets the safety rating of a car
	 * @param safetyRating The price of the car
	 */
	public void setSafetyRating(double safetyRating)
	{
		this.safetyRating = safetyRating;
	}
	
	/**This method gets the safety rating of the car
	 * @return The safety rating of the car
	 */
	public double getSafetyRating()
	{
		return safetyRating;
	}
	
	/**This method sets the mileage of a car
	 * @param maxRange The mileage of the car
	 */
	public void setMaxRange(int maxRange)
	{
		this.maxRange = maxRange;
	}
	
	/**This method gets the mileage of the car
	 * @return The mileage of the car
	 */
	public int getMaxRange()
	{
		return maxRange;
	}
	
	/**This method sets the model of a car
	 * @param model The model of the car
	 */
	public void setModel(Model model)
	{
		this.model = model;
	}
	
	/**This method gets the model of the car
	 * @return The model of the car
	 */
	public Model getModel()
	{
		return model;
	}
}
