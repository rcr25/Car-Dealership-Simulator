//Name: Ryan Rodrigues
//Student ID: 500915227

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class CarDealershipSimulator 
{
	/**This method generates a random number
	 * @param min The minimum number
	 * @param max The maximum number
	 * @return a random integer between the minimum and maximum
	 */
	static int getRandomNum(int min, int max)
	{
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
  /** This method runs the dealership program
   * @param args
   */
  public static void main(String[] args) throws IOException
  {
	  	boolean done = false;	  
	  	CarDealership lot = new CarDealership();
	  	ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Car> boughtCars = new ArrayList<Car>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM dd, yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE MM dd, yyyy");
		int month = getRandomNum(1, 11);
		int day = getRandomNum(1, 31);
		Calendar calendar = new GregorianCalendar(2019, month, day);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a command (L, BUY, ADD, RET, etc.) (Q to quit): ");
	 
		while(!(done))
		{
			try
			{
				Scanner commandLine = new Scanner(scanner.nextLine());
				String input = commandLine.next();
				// Loads the car lot
				if(input.equals("L"))
				{
					lot.displayInventory();
				}
				// Quits the program
				else if(input.equals("Q"))
				{
					done = true;
					commandLine.close();
					scanner.close();
					return;
				}
				// Buys a car
				else if(input.equals("BUY"))
				{
					if(!(commandLine.hasNextInt()))
					{
						continue;
					}
					int VIN = commandLine.nextInt();
					for(int i = 0; i < cars.size(); i++)
					{
						if(cars.get(i).getVIN() == VIN)
						{
						SalesTeam team = new SalesTeam();
						String salesPerson = team.getSalesAssociate();
						int boughtDay = (int)(Math.random()*3) + 1;
						calendar.add(Calendar.DAY_OF_MONTH, + boughtDay);			
						String c = sdf2.format(calendar.getTime());
						Scanner boughtScan = new Scanner(c);
						String m = "";
						int boughtMonth;
						for(int j = 0; j < 2; j++)
						{
							m = boughtScan.next();
						}
						boughtMonth = Integer.valueOf(m);
						boughtCars.add(0, cars.get(i));
						boughtCars.add(cars.get(i));
						AccountingSystem bank = new AccountingSystem(calendar, cars.get(i), salesPerson, "BUY", boughtMonth);
						lot.buyCar(i);
						}
					}
				}
				// Returns a car
				else if(input.equals("RET"))
				{	
					if(boughtCars.get(0) == null)
					{
						continue;
					}
					SalesTeam team = new SalesTeam();
					String salesPerson = team.getSalesAssociate();
					int returnDay = (int)(Math.random()*3) + 1;
					calendar.add(Calendar.DAY_OF_MONTH, + returnDay);
					calendar.add(Calendar.DAY_OF_MONTH, + returnDay);
					String c = sdf2.format(calendar.getTime());
					Scanner returnScan = new Scanner(c);
					String m = "";
					int returnMonth;
					for(int j = 0; j < 2; j++)
					{
						m = returnScan.next();
					}
					returnMonth = Integer.valueOf(m);
					lot.returnCar(boughtCars.get(0));
					AccountingSystem bank = new AccountingSystem(calendar, boughtCars.get(0), salesPerson, "RET", returnMonth);
					lot.returnDisplay();
					boughtCars.add(0, null);
				}
				// Adds a car to the lot
				else if(input.equals("ADD"))
				{
					try 
					{
						File carFile = new File("cars.txt");
						Scanner fileScan = new Scanner(carFile);
						while(fileScan.hasNextLine())
						{
							int VIN = (int) (Math.random() * (499 - 100)) + 100;
							String mfr = fileScan.next();
							String color = fileScan.next();
							Car.Model model = Car.Model.valueOf(fileScan.next());
							String powerSourceTest = fileScan.next();
							Vehicle.PowerSource power = Vehicle.PowerSource.valueOf(powerSourceTest);
							double safteyRating = fileScan.nextDouble();
							int maxRange = fileScan.nextInt();
							String AWDTest = fileScan.next();
							boolean AWD = false;
							if(AWDTest.equals("AWD"))
							{
								AWD = true;
							}
							double price = fileScan.nextDouble(); 
							if(powerSourceTest.equals("ELECTRIC_MOTOR"))
							{
								int rechargeTime = fileScan.nextInt();
								cars.add(new ElectricCar(VIN, mfr, color, model, power, safteyRating, maxRange, AWD, price, rechargeTime));
							}
							else
							{
								cars.add(new Car(VIN, mfr, color, model, power, safteyRating, maxRange, AWD, price ));
							}		  
						}
					}
					catch(Exception error4) {System.out.println(error4);}
					lot.AddCars(cars);
				}
				// Sort by price
				else if(input.equals("SPR"))
				{
					lot.SortByPrice();
				}
				// Sort by safety rating
				else if(input.equals("SSR"))
				{
					lot.SortBySafetyRating();
				}
				// Sort by max range
				else if(input.equals("SMR"))
				{
					lot.SortByMaxRange();
				}
				// Filter by price
				else if(input.equals("FPR"))
				{
					if(!(commandLine.hasNextDouble()))
					{
						continue;
					}
					double min = commandLine.nextDouble();
					if(!(commandLine.hasNextDouble()))
					{
						continue;
					}
					double max = commandLine.nextDouble();
					if(max > min || max == min)
					{
						lot.filterByPrice(min, max);
					}
					else
					{
						System.out.println("Invalid price range (Q to quit): ");
					}
				}
				// Filter by electric
				else if(input.equals("FEL"))
				{
					lot.filterByElectric();
				}
				// Filter by all wheel drive
				else if(input.equals("FAW"))
				{
					lot.filterByAWD();
				}
				// Clears all filters
				else if(input.equals("FCL"))
				{
					lot.FiltersClear();
				}
				// Gets the sales for the year
				else if(input.equals("SALES"))
				{
					if(!(commandLine.hasNext()))
					{
						lot.dispayAllSales();
					}
					// Gets the sales for a month 
					else if(commandLine.hasNextInt())
					{
						int m = commandLine.nextInt();
						if(m >= 1 && m <= 12)
						{
							lot.getMonthTransactions(m);
						}
						else
						{
							System.out.println("Invalid month range (range: 1-12) (Q to quit): ");
						}
					}
					else if(commandLine.hasNext())
					{
						String command = commandLine.next();
						// Gest the slaes team
						if(command.equals("TEAM"))
						{
							lot.displaySalesTeam();
						}
						// Gets the top sales associate
						else if(command.equals("TOPSA"))
						{
							lot.findTopSA();
						}
						// Gets the sales stats for the year
						else if(command.equals("STATS"))
						{
							lot.displaySalesStats();
							lot.totRET();
							lot.findHM();
						}
					}
				}
				//handling for non valid commands
				else
				{
					System.out.println("Please enter a valid command (L, BUY, ADD, RET, etc.) (Q to quit): ");
				}
			}
		
			catch(NoSuchElementException error1) 
			{
				continue;			
			}
			catch(ArrayIndexOutOfBoundsException error2)
			{
				System.out.println("Invalid input (Q to quit): ");
			}
			catch(IndexOutOfBoundsException error3)
			{
				System.out.println("Invalid input (Q to quit): ");
			}
		}		
  }
}