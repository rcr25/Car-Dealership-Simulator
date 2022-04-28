//Name: Ryan Rodrigues
//Student ID: 500915227

class ElectricCar extends Car
{
	private int rechargeTime;
	private String batteryType;
	
	/**
	 * A constructor method that initialize the instance variables and inherits variables from class Car
	 * @param VIN The vehicle identification number
	 * @param mfr The manufacturer
	 * @param color The color of the car
	 * @param model The model of the car
	 * @param power The power of the car
	 * @param safetyRating The safety rating of the car
	 * @param maxRange The mileage
	 * @param AWD If the car is all wheel drive or not
	 * @param price The price of the car
	 * @param rechargeTime How long it takes the battery to recharge
	 */
	public ElectricCar(int VIN, String mfr, String color, Model model, PowerSource power, double safetyRating, int maxRange, boolean AWD, double price, int rechargeTime)
	{
		super(VIN, mfr, color, model, power, safetyRating, maxRange, AWD, price);
		this.setRechargeTime(rechargeTime);
	}

	/**This method gets the recharge time
	 * @return How long it takes the battery to recharge
	 */
	public int getRechargeTime() 
	{
		return rechargeTime;
	}

	/**This method sets the recharge time
	 * @param rechargeTime How long it takes the battery to recharge
	 */
	public void setRechargeTime(int rechargeTime) 
	{
		this.rechargeTime = rechargeTime;
	}

	/**This method gets the type of battery for the car
	 * @return The type of battery for the car
	 */
	public String getBatteryType() 
	{
		return batteryType;
	}

	/**This method sets the type of battery for the car
	 * @param batteryType The type of battery inside the car
	 */
	public void setBatteryType(String batteryType) 
	{
		this.batteryType = batteryType;
	}
	
	/**This method returns the information about each electric car
	 * @return The information about the electric car
	 */
	public String display()
	{
		return super.display() + " " + rechargeTime;
	}
}
