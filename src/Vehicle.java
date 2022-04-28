//Name: Ryan Rodrigues
//Student ID: 500915227

class Vehicle 
{
	public PowerSource power;
	private String mfr, color;
	private int numWheels, VIN;
	
	public static enum PowerSource
	{
	ELECTRIC_MOTOR, GAS_ENGINE;
	}
	
	/**This constructor initializes the instance variables
	 * @param VIN The vehicle identification number
	 * @param mfr The manufacturer
	 * @param color The color of the vehicle
	 * @param power The power of the vehicle
	 */
	public Vehicle(int VIN, String mfr, String color, PowerSource power)
	{
		this.VIN = VIN;
		this.mfr = mfr;
		this.color = color;
		this.power = power;
	}
	
	/**This method sets the manufacturer of the vehicle
	 * @param mfr The manufacturer
	 */
	public void setMFR(String mfr)
	{
		this.mfr = mfr;
	}
	
	/**This method sets the color of the vehicle
	 * @param color The color of the vehicle
	 */
	public void setColor(String color)
	{
		this.color = color;
	}
	
	/**This method sets what powers the vehicle
	 * @param power The power of the vehicle
	 */
	public void setPower(PowerSource power) 
	{
		this.power = power;
	}
	
	/**This method sets the number of wheels of the vehicle
	 * @param numWheels the number of wheels the vehicle has
	 */
	public void setNumWheels(int numWheels)
	{
		this.numWheels = numWheels;
	}
	
	/**This method gets the manufacturer of the vehicle
	 * @return The manufacturer
	 */
	public String getMFR()
	{
		return mfr;
	}
	
	/**This method gets the color of the vehicle
	 * @return The color of the vehicle
	 */
	public String getColor()
	{
		return color;
	}
	
	/**This method gets what powers the vehicle
	 * @return The power of the vehicle
	 */
	public PowerSource getPower() 
	{
		return power;
	}
	
	/**This method gets the number of wheels of the vehicle
	 * @return The number of wheels
	 */
	public int getNumWheels()
	{
		return numWheels;
	}

	/**This method compares two vehicles to see if they are the same vehicle
	 */
	public boolean equals(Object other)
	{
		Vehicle otherVehicle = (Vehicle) other;
		return this.mfr.equals(otherVehicle.mfr) && this.power == otherVehicle.power 
		&& this.numWheels == otherVehicle.numWheels;
	}
	
	/**This method returns the manufacturer name and color of the vehicle
	 * @return The vehicle identification number, the manufacturer and color of the vehicle
	 */
	public String display()
	{
		return VIN + " " + mfr + " " + color;
	}

	/**This method gets the vehicle identification number
	 * @return The vehicle identification number
	 */
	public int getVIN() 
	{
		return VIN;
	}
}