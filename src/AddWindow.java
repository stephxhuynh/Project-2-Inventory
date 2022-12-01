import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.io.IOException; // Needed for IO exception
import java.util.ArrayList;
import java.io.IOException;
import java.awt.*;			// Needed for Color class

/**
 * Responsibilities of class: Contain GUI and information to add/modify inventory
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

public class AddWindow extends JFrame
{
	// Panels
	private JFrame frame;						// To reference the J frame
	private JPanel tvCategoryPanel;				// To reference TV category panel
	private JPanel compCategoryPanel;			// To reference computer category panel
	private JPanel mainPanel;					// To reference the main panel
	private JPanel tvSpecPanel;					// To reference the TV specification panel
	private JPanel compSpecPanel;				// To reference the computer specification panel
	private JPanel typePanel;					// To reference the TV type panel
	
	// TV Type
	private JLabel TVLabel;						// To reference the TV label
	private JLabel typeLabel;					// To reference the type label
	private JRadioButton OLEDrButton;			// To reference OLED radio button
	private JRadioButton LCDrButton;			// To reference LCD radio button
	private ButtonGroup typeRadioButtonGroup;	// To reference the type radio button group
	
	// TV Screen size
	private JPanel tvScreenPanel;				// To reference the size
	private JLabel tvScreenLabel;				// To reference TV screen label
	private JRadioButton screen40;				// To reference 40 inch TV screen size
	private JRadioButton screen50;				// To reference 50 inch TV screen size
	private JRadioButton screen60;				// To reference 60 inch TV screen size
	private ButtonGroup screenTVButtonGroup;
	
	// Comp screen size
	private JPanel compScreenPanel;				// To reference the computer screen size panel
	private JLabel compLabel;					// To reference the computer label
	private JLabel compSizeLabel;				// To reference the computer size label
	private JRadioButton screen15;				// To reference 15 inch computer screen size
	private JRadioButton screen20;				// To reference 20 inch computer screen size
	private JRadioButton screen25;				// To reference 25 inch computer screen size
	private ButtonGroup compScreenButtonGroup;	
	
	// Quantity
	private JTextField tvQuantityTextField;		// To reference the TV quantity text field
	private JTextField compQuantityTextField;	// To reference the computer quantity text field
	private JPanel tvQuantityPanel;				// To reference the TV quantity panel
	private JLabel tvQuantityLabel;				// To reference the TV quantity label
	private JPanel compQuantityPanel;			// To reference the computer quantity panel
	private JLabel compQuantityLabel;			// To reference the computer quantity label
	
	// Add/Modify
	private JPanel tvUpdatePanel;				// To reference TV update panel
	private JPanel compUpdatePanel;				// To reference computer update panel
	private JButton tvUpdateButton;				// To reference TV update button
	private JButton compUpdateButton;			// To reference computer update button
	
	// Cancel
	private JPanel exitPanel;					// To reference cancel panel
	private JButton exitButton;				// To reference cancel button
	
	// Window size
	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = 500;
	
	// Inventory System object and info
	private InventorySystem system;
	private String tvType = "";
	private int tvSize;
	private int quantity;
	private int compSize;
//	private ArrayList<Item> inventory;
	
	/**
	 * Constructor
	 * @param InventorySystem information to access arraylist and methods
	 */
	public AddWindow(InventorySystem system)
//	public AddWindow()
	{
		this.system = system;
		system.printInventory();
		
		// Create new JFrame
		frame = new JFrame();
		
		// Set the title.
		frame.setTitle("Add");
		
		// Set the size of the window.
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4, 4));
		
		buildMainPanel();
		
		frame.add(mainPanel);
		mainPanel.add(tvCategoryPanel);
		mainPanel.add(compCategoryPanel);
		mainPanel.add(TVLabel);
		mainPanel.add(tvSpecPanel);
		mainPanel.add(compLabel);
		mainPanel.add(compSpecPanel);
		mainPanel.add(exitPanel);
		
		exitButton.addActionListener(new exitButtonListener());
		
		frame.setVisible(true);
	}
	
	/**
	 * builds panel of add window
	 */
	
	private void buildMainPanel()
	{
		// Category Panel
		tvCategoryPanel = new JPanel();
		tvCategoryPanel.setLayout(new FlowLayout());
		TVLabel = new JLabel("TV");
		TVLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TVLabel.setVerticalAlignment(SwingConstants.CENTER);
		tvCategoryPanel.add(TVLabel);
		compCategoryPanel = new JPanel();
		compCategoryPanel.setLayout(new FlowLayout());
		compLabel = new JLabel("Computer");
		compLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compLabel.setVerticalAlignment(SwingConstants.CENTER);
		compCategoryPanel.add(compLabel);
		
		// Specifications Panel
		tvSpecPanel = new JPanel();
		tvSpecPanel.setLayout(new GridLayout(1, 0));
		compSpecPanel = new JPanel();
		compSpecPanel.setLayout(new GridLayout(1, 0));
		
		// Type panel inside spec panel
		typePanel = new JPanel();
		typePanel.setLayout(new GridLayout(3, 1));
		typeLabel = new JLabel("Type");
		OLEDrButton = new JRadioButton("OLED");
		LCDrButton = new JRadioButton("LCD");
		typePanel.add(typeLabel);
		typePanel.add(OLEDrButton);
		typePanel.add(LCDrButton);
		// Group type radio buttons
		typeRadioButtonGroup = new ButtonGroup();
		typeRadioButtonGroup.add(OLEDrButton);
		typeRadioButtonGroup.add(LCDrButton);
		
		// Screen size panel for TV inside spec panel
		tvScreenPanel = new JPanel();
		tvScreenPanel.setLayout(new GridLayout(4, 1));
		tvScreenLabel = new JLabel("Screen Size");
		screen40 = new JRadioButton("40");
		screen50 = new JRadioButton("50");
		screen60 = new JRadioButton("60");
		tvScreenPanel.add(tvScreenLabel);
		tvScreenPanel.add(screen40);
		tvScreenPanel.add(screen50);
		tvScreenPanel.add(screen60);
		// Group TV screen radio buttons
		screenTVButtonGroup = new ButtonGroup();
		screenTVButtonGroup.add(screen40);
		screenTVButtonGroup.add(screen50);
		screenTVButtonGroup.add(screen60);
		
		// Screen size panel for Computer
		compScreenPanel = new JPanel();
		compScreenPanel.setLayout(new GridLayout(4, 1));
		compSizeLabel = new JLabel("Screen Size");
		screen15 = new JRadioButton("15");
		screen20 = new JRadioButton("20");
		screen25 = new JRadioButton("25");
		compScreenPanel.add(compSizeLabel);
		compScreenPanel.add(screen15);
		compScreenPanel.add(screen20);
		compScreenPanel.add(screen25);
		// Group Computer screen radio buttons
		compScreenButtonGroup = new ButtonGroup();
		compScreenButtonGroup.add(screen15);
		compScreenButtonGroup.add(screen20);
		compScreenButtonGroup.add(screen25);
		
		// Quantity panel for TV
		tvQuantityLabel = new JLabel("Quantity");
		tvQuantityTextField = new JTextField(5);
		tvQuantityTextField.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				char input = e.getKeyChar();
				if ((input >= '0') || (input <= '9') && (input != '\b'))
				{
					e.consume();
				}
			}
		});
		tvQuantityPanel = new JPanel(new FlowLayout());
		tvQuantityPanel.add(tvQuantityLabel);
		tvQuantityPanel.add(tvQuantityTextField);
		
		// Quantity panel for computer
		compQuantityPanel = new JPanel();
		compQuantityLabel = new JLabel("Quantity");
		compQuantityTextField = new JTextField(5);
		compQuantityPanel = new JPanel(new FlowLayout());
		compQuantityPanel.add(compQuantityLabel);
		compQuantityPanel.add(compQuantityTextField);
		
		// Update quantities for items in inventory
		tvUpdatePanel = new JPanel();
		tvUpdateButton = new JButton("Add/Modify");
		tvUpdateButton.setPreferredSize(new Dimension(100, 100));
		tvUpdatePanel.add(tvUpdateButton);
		compUpdatePanel = new JPanel();
		compUpdateButton = new JButton("Add/Modify");
		compUpdateButton.setPreferredSize(new Dimension(100, 100));
		compUpdatePanel.add(compUpdateButton);
//		((JLabel) compUpdatePanel.add(compUpdateButton)).setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Top TV spec panel
		tvSpecPanel.add(typePanel);
		tvSpecPanel.add(tvScreenPanel);
		tvSpecPanel.add(tvQuantityPanel);
		tvSpecPanel.add(tvUpdatePanel);
		
		
		// Bottom Computer spec panel
		compSpecPanel.add(compScreenPanel);
		compSpecPanel.add(compQuantityPanel);
		compSpecPanel.add(compUpdatePanel);
		
		// Cancel panel
		exitPanel = new JPanel();
		exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(150, 100));
		exitPanel.add(exitButton);
		
		// Button Listeners
		OLEDrButton.addActionListener(new tvTypeRadioListener());
		LCDrButton.addActionListener(new tvTypeRadioListener());
		
		screen40.addActionListener(new tvScreenRadioListener());
		screen50.addActionListener(new tvScreenRadioListener());
		screen60.addActionListener(new tvScreenRadioListener());
		
		screen15.addActionListener(new compScreenRadioListener());
		screen20.addActionListener(new compScreenRadioListener());
		screen25.addActionListener(new compScreenRadioListener());
		
		tvUpdateButton.addActionListener(new tvUpdateListener());
		compUpdateButton.addActionListener(new compUpdateListener());
		
		
	}
	
	/**
	 * Action listener for TV type radio buttons
	 *
	 */
	private class tvTypeRadioListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == OLEDrButton)
			{
				tvType = "OLED";
			}
			if(e.getSource() == LCDrButton)
			{
				tvType = "LCD";
			}
		}
	}
	
	/**
	 * Action listener for TV screen size radio buttons
	 *
	 */
	private class tvScreenRadioListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == screen40)
				tvSize = 40;
			if (e.getSource() == screen50)
				tvSize = 50;
			if (e.getSource() == screen60)
				tvSize = 60;
			
		}
	}
	
	/**
	 * Action listener to update (add or modify) inventory arraylist for TV items
	 *
	 */
	private class tvUpdateListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String input = "";
			input = tvQuantityTextField.getText();
			quantity = Integer.parseInt(input);
			
			
			system.ifItemExists("TV", tvSize, tvType, quantity);
//			system.getList().add(new TV("TV", tvSize, tvType));
//			system.getList().get(InventorySystem.count).setQuantity(quantity);
//			InventorySystem.count++;
			JOptionPane.showMessageDialog(AddWindow.this, "Quantity: " + quantity 
					+ "\t TV Size: " + tvSize + " Type: " + tvType + " added");
			
		}
		
	}
	
	
	/**
	 * Action listener for computer screen size radio buttons
	 *
	 */
	
	private class compScreenRadioListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == screen15)
				compSize = 15;
			if (e.getSource() == screen20)
				compSize = 20;
			if (e.getSource() == screen25)
				compSize = 25;
		}
		
	}
	
	/**
	 * Action listener to update (add or modify) inventory arraylist for computer items
	 *
	 */
	private class compUpdateListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String input = "";
			input = compQuantityTextField.getText();
			quantity = Integer.parseInt(input);
			
			system.ifItemExists("COMPUTER", compSize, "NA", quantity);
//			system.getList().add(new Computer("COMPUTER", compSize));
//			system.getList().get(InventorySystem.count).setQuantity(quantity);
//			InventorySystem.count++;
			JOptionPane.showMessageDialog(AddWindow.this, "Quantity: " + quantity 
					+ "\t Computer Size: " + compSize + "in. added");
			
		}
		
	}
	
	/**
	 * Action listener when user clicks exit button on add window
	 * Takes user back to main view window
	 *
	 */
	private class exitButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == exitButton)
			{
				frame.dispose();
				//added system for constructor
//				InventoryMainView mWindow = new InventoryMainView(system);

				try
				{
					InventoryMainView mWindow = new InventoryMainView(system);
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
	

}
