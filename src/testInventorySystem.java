import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
