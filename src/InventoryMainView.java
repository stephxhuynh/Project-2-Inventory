import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.awt.*;			// Needed for Color class
import java.io.*;  			// Needed for file reading
import java.util.*;			// Needed for file reading

public class InventoryMainView extends JFrame
{
	private JFrame frame;				// To reference the J frame
	private JPanel mainPanel;			// To reference the main panel
	private JPanel buttonPanel;			// To reference the button panel
	private JPanel addPanel;			// To reference the add panel
	private JPanel checkPanel;			// To reference the check panel
	private JPanel infoPanel;			// To reference the info panel
	private JButton addButton;			// To reference an add button
	private JButton checkButton;		// To reference a check button
	private JTextArea textInput;		// To reference text area
	private JTable table;				// to reference table
	private JScrollPane scrollPane;		// to reference a scroll pane
	
	final int WINDOW_WIDTH = 1200;		// Window width in pixels
	final int WINDOW_HEIGHT = 700;		// Window height in pixels
	
	// Model/View fields
	private InventoryMainView view;
	private InventorySystem system;
//	private ArrayList<Item> inventory;
	
	/**
	 * Constructor
	 * @throws IOException 
	 */

	//public InventoryMainView(InventorySystem system)

	public InventoryMainView() throws IOException
	{	
		view = this;
		system = new InventorySystem();
		
		// Create new JFrame
		frame = new JFrame();
		
		// Set the title.
		frame.setTitle("Inventory System");
		
		// Set the size of the window.
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		buildMainPanel();
		
		frame.add(mainPanel);
		
		mainPanel.add(buttonPanel, BorderLayout.WEST);
		mainPanel.add(infoPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	private void buildMainPanel() throws IOException
	{
		// Button Panel
		buttonPanel = new JPanel();
		addPanel = new JPanel();
		checkPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		addButton = new JButton("Add");
		addButton.setPreferredSize(new Dimension(200, 200));
		checkButton = new JButton("Check");
		checkButton.setPreferredSize(new Dimension(200, 200));
		addPanel.add(addButton);
		checkPanel.add(checkButton);
		buttonPanel.add(addPanel);
		buttonPanel.add(checkPanel);
		
		addButton.addActionListener(new ButtonListener());
		checkButton.addActionListener(new ButtonListener());
		
		// Info Panel
		infoPanel = new JPanel();
		// Data to be displayed in the JTable
		String[][] data = {
				{"OLED", "TV", "40", "25", "1", "1"},
				{"NA", "COMPUTER", "20", "23", "2", "2"}
		};
		
		// Column Names
		String[] columnNames = {"Type", "Category", "Screen Size", "Quantity", "Aisle", "Shelf"};
		// Initialize table
		table = new JTable(data, columnNames);
		table.setBounds(30, 40, 700, 500);
		scrollPane = new JScrollPane(table);
//		try
//		{
//			FileReader reader = new FileReader("inventoryInfo.txt");
//			// Create a scanner object from FileReader
//			Scanner s = new Scanner(reader);
//			// Create a string that will store all the text in the text file
//			String storeAllString = "";
//			
//			// Put all text from text file into created string
//			while (s.hasNextLine())
//			{
//				String temp = s.nextLine();
//				storeAllString = storeAllString + temp;
//			}
//			textInput = new JTextArea(storeAllString);
//			JScrollPane scrollPane = new JScrollPane(textInput);
//			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		}
//		catch (FileNotFoundException e)
//		{
//			JOptionPane.showMessageDialog(InventoryMainView.this, "File not found.");
//		}
//		infoPanel.add(textInput);
		infoPanel.add(scrollPane);
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == checkButton)
			{
				frame.dispose();
				CheckWindow checkWindow = new CheckWindow();
			}
			if(e.getSource() == addButton)
			{
				frame.dispose();
				AddWindow addWindow = new AddWindow(system);
//				AddWindow aWindow = new AddWindow();
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
//		new InventoryMainView(new InventorySystem());
		new InventoryMainView();
	}
}
