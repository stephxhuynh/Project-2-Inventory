import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Responsibilities of class: Run program for user to input inventory
 * and search inventory.
 * 
 * @author Stephanie Huynh
 * @author Abraham Kim
 * Other contributors:
 * Tasha Frankie
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley.
 * 
 *         
 * @version 1.0 10/03/2022
 */

public class InventorySystem
{

	// Global constraint variable to keep track of index of the inventory
	// arraylist
	static int count = 0;
	
	private ArrayList<Item> inventory;
	
	public InventorySystem() throws IOException
	{
		inventory = new ArrayList<Item>();
		readFromFile("inventoryInfo.txt");
	}

	public static void main(String[] args) throws IOException
	{}

	/**
	 * Prints Menu options and goes into check/add depending on choice
	 * 
	 * @param inventory to add/search
	 * @param keyboard
	 */
	public void printMenu(Scanner keyboard)
	{
		String choice;

		boolean askCont = true;
		// while loop to continue as user likes
		while (askCont != false)
		{
			// ask if they want to add or check or show all
			choice = askMenu(keyboard);
			if (choice.equalsIgnoreCase("Add"))
			{
				addInventory(keyboard);
			}

			else if (choice.equalsIgnoreCase("Check"))
			{
				checkInventory(keyboard);
			}

			else if (choice.equalsIgnoreCase("Show all"))
			{
				printInventory();
			}
			askCont = askMenuContinue(keyboard);
		}
	}

	/**
	 * Add inventory to Item arrayList
	 * 
	 * @param inventory to add to
	 * @param keyboard
	 */
	public void addInventory(Scanner keyboard)
	{
		String category = null;

		boolean choice = true;

		// while loop as user decides when they want to stop or keep adding more
		// items
		while (choice != false)
		{
			// get category from user
			category = askCategory(keyboard);

			if (category.equalsIgnoreCase("TV"))
			{
				addTV(category, keyboard);

				keyboard.nextLine(); // clear input
				choice = askContinue(keyboard);

			}
			else if (category.equalsIgnoreCase("Computer"))
			{
				addComputer(category, keyboard);

				keyboard.nextLine(); // clear input

				choice = askContinue(keyboard);
			}
		}
	}

	/**
	 * Check inventory
	 * 
	 * @param inventory
	 * @param keyboard
	 */
	public void checkInventory(Scanner keyboard)
	{
		// holds user input variables that will help us check inventory
		String category;
		String type;
		int size;

		boolean choice = true;

		while (choice != false)
		{
			category = askCategory(keyboard);

			if (category.equalsIgnoreCase("TV"))
			{
				// ask type of TV
				type = askTVType(keyboard);

				if (type.equalsIgnoreCase("OLED"))
				{
					// ask size of TV
					size = askTVSize(keyboard);

					keyboard.nextLine();

					// search for item in inventory arrayList and print quantity
					// if found
					searchTVInventory(category, size, type);

					choice = askContinue(keyboard);
				}
				else if (type.equalsIgnoreCase("LCD"))
				{
					// ask size of tv
					size = askTVSize(keyboard);

					keyboard.nextLine(); // clear input
					// search for item in inventory arrayList and print quantity
					// if found
					searchTVInventory(category, size, type);

					choice = askContinue(keyboard);
				}
			}
			else if (category.equalsIgnoreCase("Computer"))
			{
				// ask size of computer
				size = askComputerSize(keyboard);

				keyboard.nextLine(); // clear input

				// search for item in inventory arrayList and print quantity if
				// found
				searchComputerInventory(category, size);

				choice = askContinue(keyboard);
			}
		}
	}

	/**
	 * add TV object to inventory
	 * 
	 * @param inventory to add to
	 * @param category  for constructor
	 * @param keyboard
	 */
	public void addTV(String category,
			Scanner keyboard)
	{
		String type;
		int size;

		type = askTVType(keyboard);

		size = askTVSize(keyboard);
	}

	/**
	 * add Computer object to inventory
	 * 
	 * @param inventory to add to
	 * @param category  for constructor
	 * @param keyboard
	 */
	public void addComputer(String category, Scanner keyboard)
	{
		int size;

		size = askComputerSize(keyboard);
	}

	/**
	 * ask if user would like to add or check inventory
	 * 
	 * @param keyboard
	 * @return string choice
	 * @throws IllegalArgumentException if choice is not "ADD" "CHECK" or "SHOW
	 *                                  ALL".
	 *                                  prompts user to enter information again.
	 * @throws InputMistmatchException  if choice is not a string
	 */
	public String askMenu(Scanner keyboard)
	{
		boolean validInput = false;
		String choice = null;
		System.out.println("What would you like to do?");
		System.out.println("Add or Check or Show all");
		do
		{
			try
			{
				choice = keyboard.nextLine();
				choice = choice.toUpperCase();
				if (choice.equals("ADD") || choice.equals("CHECK")
						|| choice.equals("SHOW ALL"))
					validInput = true;
				else throw new IllegalArgumentException();

			}
			catch (IllegalArgumentException e)
			{
				System.out.println(
						"Please enter Add or Check or show all. Try again.");
			}
			catch (InputMismatchException e)
			{
				System.out.println("Please enter a String. Try again.");
			}
		} while (!validInput);
		return choice;
	}

	/**
	 * ask user for category
	 * 
	 * @param keyboard
	 * @return String category
	 * @throws IllegalArgumentException if choice category is not "TV" or
	 *                                  "COMPUTER"
	 */
	public String askCategory(Scanner keyboard)
	{
		boolean validInput = false;
		String category = null;
		System.out.println("\nEnter category of TV or Computer: ");
		do
		{
			try
			{
				category = keyboard.nextLine();
				category = category.toUpperCase();
				if (category.equals("TV") || category.equals("COMPUTER"))
					validInput = true;
				else throw new IllegalArgumentException();
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("Please enter TV or Computer. Try again.");
			}
			catch (InputMismatchException e)
			{
				System.out.println("Please enter a String. Try again.");
			}
		} while (!validInput);
		return category;
	}

	/**
	 * ask user for type of TV
	 * 
	 * @param keyboard
	 * @return String type
	 * @throws IllegalArgumentException if type is not "OLED" or "LCD"
	 */
	public String askTVType(Scanner keyboard)
	{
		boolean validInput = false;
		String type = null;
		System.out.println("Enter type: OLED or LCD ");
		do
		{
			try
			{
				type = keyboard.nextLine();
				type = type.toUpperCase();
				if (type.equals("OLED") || type.equals("LCD"))
					validInput = true;
				else throw new IllegalArgumentException();
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("\nPlease enter OLED or LCD. Try again.");
			}
			catch (InputMismatchException e)
			{
				System.out.println("Please enter a String. Try again.");
			}
		} while (!validInput);
		return type;
	}

	/**
	 * Ask user for TV size
	 * 
	 * @param keyboard
	 * @return int size
	 * @throws IllegalArgumentException if size is not an int of 40, 50, or 60
	 */
	public static int askTVSize(Scanner keyboard)
	{
		int size = 0;
		boolean validInput = false;
		System.out.println("\nEnter screen size of 40, 50, or 60: ");
		do
		{
			try
			{
				size = keyboard.nextInt();
				if (size == 40 || size == 50 || size == 60) validInput = true;
				else throw new IllegalArgumentException();

			}
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.out.println(
						"Please enter a number of 40, 50, or 60. Try again");
				keyboard.nextLine(); // clear input
			}
		} while (!validInput);
		return size;
	}

	/**
	 * Ask user for Computer size
	 * 
	 * @param keyboard
	 * @return int size
	 * @throws IllegalArgumentException if size is not an int of 15, 20, or 25
	 */
	public int askComputerSize(Scanner keyboard)
	{
		int size = 0;
		boolean validInput = false;
		System.out.println("\nEnter screen size of 15, 20, or 25: ");
		do
		{
			try
			{
				size = keyboard.nextInt();
				if (size == 15 || size == 20 || size == 25) validInput = true;
				else throw new IllegalArgumentException();

			}
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.out.println(
						"Please enter screen size of 15, 20, or 25. Try again");
				keyboard.nextLine(); // clear input
			}
		} while (!validInput);
		return size;
	}

	/**
	 * ask user for quantity they want to add
	 * 
	 * @param keyboard
	 * @return int quantity
	 * @throws IllegalArgument if quantity is negative or equal to 0
	 */
	public int askQuantity(Scanner keyboard)
	{
		int quantity = 0;
		boolean validInput = false;
		System.out.println("\nEnter quantity: ");
		do
		{
			try
			{
				quantity = keyboard.nextInt();
				if (quantity <= 0) throw new IllegalArgumentException();
				validInput = true;

			}
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.out.println("Please enter valid number. Try again.");
				keyboard.nextLine(); // clear input
			}
		} while (!validInput);
		return quantity;
	}

	/**
	 * Ask user if they want to continue
	 * 
	 * @param keyboard
	 * @return boolean
	 * @throws IllegalArgumentException if "y" or "n" is not entered
	 * 
	 */
	public boolean askContinue(Scanner keyboard)
	{
		boolean validInput = false;
		String value;
		System.out.println("\nDo you wish to continue?: y or n: ");
		do
		{
			try
			{
				value = keyboard.nextLine();
				if (value.equalsIgnoreCase("y") || value.equalsIgnoreCase("n"))
					validInput = true;
				else throw new IllegalArgumentException();
				if (value.equals("y"))
				{
					return true;
				}
				else if (value.equals("n")) return false;
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("Please enter y or n. Try again");
			}
		} while (!validInput);
		return false;
	}

	/**
	 * Prompt user to check or add again
	 * 
	 * @param keyboard
	 * @return boolean
	 * @throws IllegalArgumentException if "y" or "n" is not entered
	 * 
	 */
	public boolean askMenuContinue(Scanner keyboard)
	{
		boolean validInput = false;
		String value;
		System.out.println("\nDo you wish to add or check again? y or n: ");
		do
		{
			try
			{
				value = keyboard.nextLine();
				if (value.equalsIgnoreCase("y") || value.equalsIgnoreCase("n"))
					validInput = true;
				else throw new IllegalArgumentException();
				if (value.equals("y"))
				{
					return true;
				}
				else if (value.equals("n")) return false;
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("Please enter y or n. Try again");
			}
		} while (!validInput);
		return false;
	}

	/**
	 * Print all inventory out
	 * 
	 * @param inventory
	 */
	public void printInventory()
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			System.out.println(inventory.get(i).toString());
		}
		System.out.println();
	}

	/**
	 * Print total quantities of inventory
	 * 
	 * @param inventory
	 */
	public void printQuantity()
	{
		int total = 0;
		for (int i = 0; i < inventory.size(); i++)
		{
			total += inventory.get(i).getQuantity();
		}
		System.out.println("Inventory has " + total + " items");
	}

	/**
	 * Read information from file
	 * 
	 * @param filename  to read from
	 * @param inventory to add to
	 * @throws FileNotFoundException thrown if no such file exists
	 */
	public void readFromFile(String fileName)
			throws FileNotFoundException
	{
		Scanner input = null;
		String type;
		String category;
		int size;
		int quantity;

		try
		{
			File myFile = new File(fileName);
			input = new Scanner(myFile);
			while (input.hasNextLine())
			{
				type = input.next();
				if (type.equals("OLED") || type.equals("LCD"))
				{
					category = input.next();
					size = input.nextInt();
					quantity = input.nextInt();

					input.nextLine(); // clear newline

					inventory.add(new TV(category, size, type));
					inventory.get(count).setQuantity(quantity);
					count++;
				}
				else
				{
					category = input.next();
					size = input.nextInt();
					quantity = input.nextInt();

					input.nextLine(); // clear newline

					inventory.add(new Computer(category, size));
					inventory.get(count).setQuantity(quantity);
					count++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File does not exist");
		}
		finally
		{
			if (input != null)
			{
				input.close();
			}
			System.out.println(
					"System finished reading any existing inventory file.\n");
		}
	}

	/**
	 * Write inventory to file
	 * 
	 * @param fileName  to write to
	 * @param inventory to copy information from
	 * @throws IOException
	 * @throws FileNotFoundException if no such file exists
	 */
	public void writeToFile(String fileName)
			throws IOException, FileNotFoundException
	{
		FileWriter fWriter = null;
		PrintWriter pWriter = null;
		count = 0;
		try
		{
			fWriter = new FileWriter(fileName);
			pWriter = new PrintWriter(fWriter);
			for (int i = 0; i < inventory.size(); i++)
			{
				/*
				 * instanceof because TV and Computer data is written in a bit
				 * differently
				 * TV: type = LCD OR OLED
				 * Computer: type = NA
				 */

				if (inventory.get(i) instanceof TV)
				{
					count++;
					pWriter.println(((TV) inventory.get(i)).getType() + "\t"
							+ inventory.get(i).getCategory() + "\t"
							+ inventory.get(i).getScreenSize() + "\t"
							+ inventory.get(i).getQuantity() + "\t"
							+ inventory.get(i).getLocation());
				}
				else if (inventory.get(i) instanceof Computer)
				{
					count++;
					pWriter.println("NA " + inventory.get(i).getCategory() + "\t"
							+ inventory.get(i).getScreenSize() + "\t"
							+ inventory.get(i).getQuantity() + "\t"
							+ inventory.get(i).getLocation());
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Cannot write to file, file does not exist");
		}
		finally
		{
			System.out.println("System saved information to file");
			pWriter.close();
		}
	}
	
	/**
	 * GUI IMPLEMENTATION:
	 * Check if item exists before adding to inventory
	 * If it does exist, update quantity
	 * If it does not, add new item to arraylist
	 * @param category
	 * @param size
	 * @param type
	 * @param quantity
	 */
	public void ifItemExists(String category, int size, String type, int quantity)
	{
		boolean exists = false;
		int indexExist = -1;
		
		for (int i = 0; i < inventory.size(); i++)
		{
			if (inventory.get(i) instanceof TV)
			{
				if (((TV) inventory.get(i)).getType().equals(type))
					if (inventory.get(i).getScreenSize() == size)
					{
						exists = true;
						indexExist = i;
					}
			}
			else if (inventory.get(i) instanceof Computer)
			{
				if (inventory.get(i).getScreenSize() == size)
				{
					exists = true;
					indexExist = i;
				}
			}
		}

		// if item exists, add quantity of items to that item
		if (exists == true)
		{
			System.out.println("\nItem already exists. Quantity has been updated");
			quantity = quantity + inventory.get(indexExist).getQuantity();
			inventory.get(indexExist).setQuantity(quantity);
		}
		// else if inventory does not exist, create new item/object depending on
		// specified category
		else if (exists == false)
		{
			if (category.equals("TV"))
			{
				inventory.add(new TV(category, size, type));
				inventory.get(count).setQuantity(quantity);
				//increasing count to index through arraylist for new items
				count++;
			}
			else
			{
				inventory.add(new Computer(category, size));
				inventory.get(count).setQuantity(quantity);
				//increasing count to index through arraylist for new items
				count++;
			}
		}
	}
	
	/**
	 * GUI IMPLEMENTATION
	 * search TV inventory and get quantity
	 * @param category
	 * @param size
	 * @param type
	 * @return int of quantity
	 */
	public int searchTVInventory(String category, int size, String type)
	{
		boolean exists = false;
		int quantity = 0;
		for (int i = 0; i < inventory.size(); i++)
		{
			if (inventory.get(i).getCategory().equals(category))
			{
				if (inventory.get(i).getScreenSize() == size)
					if (((TV) inventory.get(i)).getType().equals(type))
				{
					exists = true;
					quantity = inventory.get(i).getQuantity();
				}
			}
		}
		return quantity;
	}
	
	/**
	 * GUI IMPLEMENTATION
	 * Search for computer in inventory and get quantity
	 * @param category
	 * @param size
	 * @return int of quantity
	 */
	public int searchComputerInventory(String category, int size)
	{
		boolean exists = false;
		int quantity = 0;
		for (int i = 0; i < inventory.size(); i++)
		{
			if (inventory.get(i).getCategory().equals(category))
				if (inventory.get(i).getScreenSize() == size)
			{
				exists = true;
				quantity = inventory.get(i).getQuantity();
			}
		}
		return quantity;
	}
	
	/**
	 * get ArrayList of inventory system
	 * @return array list of items
	 */
	public ArrayList<Item> getList()
	{
		return inventory;
	}
}
