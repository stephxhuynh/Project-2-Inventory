import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.awt.*;			// Needed for Color class
import java.io.*;  			// Needed for file reading
import java.util.*;			// Needed for file reading

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsibilities of class: Contain home page of GUI for inventory system
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
 * @version 1.0 11/21/2022
 */

public class InventoryMainView extends JFrame
{
	private JFrame frame;				// To reference the J frame
	private JPanel mainPanel;			// To reference the main panel
	private JPanel buttonPanel;			// To reference the button panel
	private JPanel addPanel;			// To reference the add panel
	private JPanel removePanel;			// To reference the remove panel
	private JPanel checkPanel;			// To reference the check panel
	private JPanel infoPanel;			// To reference the info panel
	private JPanel jTablePanel;			// To reference the jTable panel
	private JButton addButton;			// To reference an add button
	private JButton removeButton;		// To reference a remove button
	private JButton checkButton;		// To reference a check button
	private JTextArea textInput;		// To reference text area
	private JTable table;				// to reference table
	private JScrollPane scrollPane;		// to reference a scroll pane
	
	final int WINDOW_WIDTH = 1200;		// Window width in pixels
	final int WINDOW_HEIGHT = 700;		// Window height in pixels
	
	// Model/View fields
	private InventoryMainView view;
	private InventorySystem system;
	
	/**
	 * Constructor
	 * @throws Exception 
	 */
	public InventoryMainView(InventorySystem system) throws Exception
	{	
		view = this;
		this.system = system;
		
		// Create new JFrame
		frame = new JFrame();
		
		// Set the title.
		frame.setTitle("Inventory System");
		
		// Set the size of the window.
//		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		buildMainPanel();
		
		frame.add(mainPanel);
		
		mainPanel.add(buttonPanel, BorderLayout.WEST);
		mainPanel.add(jTablePanel, BorderLayout.CENTER);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
	/**
	 * builds panel of main view window
	 * @throws Exception 
	 */
	private void buildMainPanel() throws Exception
	{
		// Button Panel
		buttonPanel = new JPanel();
		addPanel = new JPanel();
		removePanel = new JPanel();
		checkPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 1));
		addButton = new JButton("Add");
		addButton.setPreferredSize(new Dimension(150, 150));
		removeButton = new JButton("Remove");
		removeButton.setPreferredSize(new Dimension(150, 150));
		checkButton = new JButton("Check");
		checkButton.setPreferredSize(new Dimension(150, 150));
		addPanel.add(addButton);
		removePanel.add(removeButton);
		checkPanel.add(checkButton);
		buttonPanel.add(addPanel);
		buttonPanel.add(removePanel);
		buttonPanel.add(checkPanel);
		
		
		
		addButton.addActionListener(new ButtonListener());
		checkButton.addActionListener(new ButtonListener());
		
		// Info Panel
		infoPanel = new JPanel();
		jTablePanel = new JPanel();
		// Data to be displayed in the JTable
		String[][] data = create2DMatrixFromFile("inventoryinfo.txt", 6);
		
		// Column Names
		String[] columnNames = {"Type", "Category", "Screen Size", "Quantity", "Aisle", "Shelf"};
		// Initialize table
		table = new JTable(data, columnNames);
//		table.setBounds(30, 40, 1000, 700);
		scrollPane = new JScrollPane(table);
		jTablePanel.add(scrollPane);
		infoPanel.add(jTablePanel);
	}
	
	/**
	 * Action listener for check or add buttons 
	 * Opens new window of check or add based on what's clicked
	 */
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == checkButton)
			{
				frame.dispose();
				CheckWindow checkWindow = new CheckWindow(system);
			}
			
			if(e.getSource() == addButton)
			{
				frame.dispose();
				AddWindow addWindow = new AddWindow(system);
//				AddWindow aWindow = new AddWindow();
			}
		}
	}
	
	
	public static String[][] create2DMatrixFromFile(String fileName, int numOfFields) throws Exception
	{
		List<String> infoList = new ArrayList<String>();
		
		String delimiter = "\\s+";
		String currentLine;
		
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null)
			{
				infoList.add(currentLine);
			}
			// Get size of the infoList
			int infoCount = infoList.size();
			
			String infoArray[][] = new String[infoCount][numOfFields];
			String[] data;
			
			for (int i = 0; i < infoCount; i++)
			{
				data = infoList.get(i).split(delimiter);
				for (int j = 0; j < data.length; j++)
				{
					infoArray[i][j] = data[j];
				}
			}
			return infoArray;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * main method to create a window of the main view
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		new InventoryMainView(new InventorySystem());
//		new InventoryMainView();
	}
}
