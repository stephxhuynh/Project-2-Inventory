import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class testInventorySystem extends InventorySystem
{

	public static void main(String[] args) throws IOException
	{
		
		InventorySystem system = new InventorySystem();
		ArrayList<Item> inventory = new ArrayList<Item>();
		inventory = system.getList();
		// read any existing inventory
		readFromFile("inventoryInfo.txt", inventory);

		// opens stream for input
		Scanner keyboard = new Scanner(System.in);

		// print Menu
		printMenu(inventory, keyboard);

		writeToFile("inventoryInfo.txt", inventory);

		printInventory(inventory);

		printQuantity(inventory);


	}

}
