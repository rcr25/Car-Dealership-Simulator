//Name: Ryan Rodrigues
//Student ID: 500915227

import java.util.LinkedList;
import java.util.Random;
//import java.util.ListIterator;

public class SalesTeam 
{
	
	private String associate;
	private int employeeSize;
	
	String[] names = {"Cartman", "Kyle", "Stan", "Kenny", "Butters", "Wendy"};
	
	/**This constructor adds the names to the linked list
	 */
	LinkedList<String> salesTeam = new LinkedList<String>();
	{
		for (int i = 0; i < names.length; i++)
		{
			salesTeam.add(names[i]);
		}
		employeeSize = salesTeam.size();
		associate = salesTeam.get(getRandomNum(0, 5));
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
	
	/**This method gets a sales associate
	 * @return an associate
	 */
	public String getSalesAssociate()
	{
		return associate;
	}
	
	/**This method gets the sales team
	 * @return the names in the sales team
	 */
	public LinkedList<String> getTeam()
	{
		return salesTeam;
	}

	/**This method gets the size of the sales team
	 * @return the number of employees
	 */
	public int getEmployees()
	{
		return employeeSize;
	}
}