import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Responsibilities of class: test inventory system class
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
 * @version 1.0 11/29/2022
 */

public class testInventorySystem 
{

	public testInventorySystem() throws IOException
	{
		super();
	}

	public static void main(String[] args) throws IOException
	{
		InventorySystem system = new InventorySystem();
//		ArrayList<Item> inventory = new ArrayList<Item>();
//		inventory = system.getList();
//		// read any existing inventory
//		readFromFile("inventoryInfo.txt", inventory);
//
//		// opens stream for input
//		Scanner keyboard = new Scanner(System.in);
//
//		// print Menu
//		printMenu(inventory, keyboard);
//
//		writeToFile("inventoryInfo.txt", inventory);
//
//		printInventory(inventory);
//
//		printQuantity(inventory);
		
		
		//what's the difference???
		system.writeToFile("inventoryInfo.txt");
//		InventorySystem.writeToFile("inventoryInfo.txt", system.getList());
//		InventorySystem.printInventory(system.getList());
		
		
//		keyboard.close();


	}

}
