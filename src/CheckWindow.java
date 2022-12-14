import javax.swing.*; // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface
import java.awt.*; // Needed for Color class


/**
 * Responsibilities of class: Contain GUI check window and information to check inventory items
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

public class CheckWindow extends JFrame
{
	// Panels
	private JFrame frame;						// To reference the J frame
	private JPanel tvCategoryPanel; 			// To reference TV category panel
	private JPanel compCategoryPanel; 			// To reference computer category panel
	private JPanel mainPanel; 					// To reference the main panel
	private JPanel TVSpecPanel; 				// To reference the specification TV panel
	private JPanel CompSpecPanel;				// To reference the specification computer panel
	private JPanel typePanel; 					// To reference the TV type panel

	// TV Type
	private JLabel TVLabel; 					// To reference the TV label
	private JLabel typeLabel; 					// To reference the type label
	private JRadioButton OLEDrButton; 			// To reference OLED radio button
	private JRadioButton LCDrButton; 			// To reference LCD radio button
	private ButtonGroup typeRadioButtonGroup; 	// To reference the type radio button group
	
	// TV Screen size
	private JPanel tvScreenPanel; 				// To reference the size
	private JLabel tvScreenLabel; 				// To reference TV screen label
	private JRadioButton screen40; 				// To reference 40 inch TV screen size
	private JRadioButton screen50; 				// To reference 50 inch TV screen size
	private JRadioButton screen60; 				// To reference 60 inch TV screen size
	private ButtonGroup screenTVButtonGroup; 	// To reference TV screen size radio button group

	// Computer Screen size
	private JPanel compScreenPanel; 			// To reference the computer screen size panel
	private JLabel compLabel; 					// To reference the computer label
	private JLabel compSizeLabel; 				// To reference the computer size label
	private JRadioButton screen15; 				// To reference 15 inch computer screen size
	private JRadioButton screen20; 				// To reference 20 inch computer screen size
	private JRadioButton screen25; 				// To reference 25 inch computer screen size
	private ButtonGroup compScreenButtonGroup;	// To reference computer screen size radio button group
	
	// Check Button/Panel
	private JPanel tvCheckPanel;				// To reference the TV check panel
	private JButton tvCheckButton;				// To reference the TV check button
	private JPanel compCheckPanel;				// To reference the computer check panel
	private JButton compCheckButton;			// To reference the computer check button

	// Cancel
	private JPanel exitPanel; // To reference cancel panel
	private JButton exitButton; // To reference cancel button

	// Window size
	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = 500;

	// Inventory System object and other variables
	private InventorySystem system;
	private int tvSize;
	private String tvType;
	private int compSize;

	/**
	 * Constructor
	 * @param InventorySystem
	 */
	public CheckWindow(InventorySystem system)
	{
		this.system = system;
		// Create new JFrame
		frame = new JFrame();

		// Set the title.
		frame.setTitle("Check");

		// Set the size of the window.
//		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 3));

		buildMainPanel();

		frame.add(mainPanel);
		mainPanel.add(tvCategoryPanel);
		mainPanel.add(TVSpecPanel);
		mainPanel.add(compCategoryPanel);
		mainPanel.add(CompSpecPanel);
		mainPanel.add(exitPanel);

		exitButton.addActionListener(new exitButtonListener());
		
		frame.pack();

		frame.setVisible(true);
	}

	/**
	 * Builds panel of check window
	 */
	private void buildMainPanel()
	{
		// Category Panel
		tvCategoryPanel = new JPanel();
		TVLabel = new JLabel("TV");
		TVLabel.setPreferredSize(new Dimension(100, 100));
		TVLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TVLabel.setVerticalAlignment(SwingConstants.CENTER);
		tvCategoryPanel.add(TVLabel);
		compCategoryPanel = new JPanel();
		compLabel = new JLabel("Computer");
		compLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compLabel.setVerticalAlignment(SwingConstants.CENTER);
		compLabel.setPreferredSize(new Dimension(100, 100));
		compCategoryPanel.add(compLabel);

		// Specifications Panel
		TVSpecPanel = new JPanel();
		TVSpecPanel.setLayout(new GridLayout(1, 0));
		CompSpecPanel = new JPanel();
		CompSpecPanel.setLayout(new GridLayout(1, 0));

		// Type panel inside spec panel
		typePanel = new JPanel();
		typePanel.setLayout(new GridLayout(3, 1));
		typeLabel = new JLabel("Type");
		OLEDrButton = new JRadioButton("OLED");
		LCDrButton = new JRadioButton("LCD");
		// Group type radio buttons
		typeRadioButtonGroup = new ButtonGroup();
		typeRadioButtonGroup.add(OLEDrButton);
		typeRadioButtonGroup.add(LCDrButton);
		typePanel.add(typeLabel);
		typePanel.add(OLEDrButton);
		typePanel.add(LCDrButton);

		// Screen size panel for TV inside spec panel
		tvScreenPanel = new JPanel();
		tvScreenPanel.setLayout(new GridLayout(4, 1));
		tvScreenLabel = new JLabel("Screen Size");
		screen40 = new JRadioButton("40");
		screen50 = new JRadioButton("50");
		screen60 = new JRadioButton("60");
		// Group TV screen radio buttons
		screenTVButtonGroup = new ButtonGroup();
		screenTVButtonGroup.add(screen40);
		screenTVButtonGroup.add(screen50);
		screenTVButtonGroup.add(screen60);
		tvScreenPanel.add(tvScreenLabel);
		tvScreenPanel.add(screen40);
		tvScreenPanel.add(screen50);
		tvScreenPanel.add(screen60);

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
		// Group Comp screen radio buttons
		compScreenButtonGroup = new ButtonGroup();
		compScreenButtonGroup.add(screen15);
		compScreenButtonGroup.add(screen20);
		compScreenButtonGroup.add(screen25);
		
		// Check Button for tv and computer
		tvCheckPanel = new JPanel();
		tvCheckButton = new JButton("Check");
		tvCheckButton.setPreferredSize(new Dimension(100, 100));
		tvCheckPanel.add(tvCheckButton);
		compCheckPanel = new JPanel();
		compCheckButton = new JButton("Check");
		compCheckButton.setPreferredSize(new Dimension(100, 100));
		compCheckPanel.add(compCheckButton);

		// Top TV spec panel
		TVSpecPanel.add(typePanel);
		TVSpecPanel.add(tvScreenPanel);
		TVSpecPanel.add(tvCheckPanel);

		// Botton Computer spec panel
		CompSpecPanel.add(compScreenPanel);
		CompSpecPanel.add(compCheckPanel);

		// Exit panel
		exitPanel = new JPanel();
		exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(150, 100));
		exitPanel.add(exitButton);

		// Radio Button Listeners
		OLEDrButton.addActionListener(new tvTypeRadioListener());
		LCDrButton.addActionListener(new tvTypeRadioListener());

		screen40.addActionListener(new tvScreenRadioListener());
		screen50.addActionListener(new tvScreenRadioListener());
		screen60.addActionListener(new tvScreenRadioListener());

		screen15.addActionListener(new compScreenRadioListener());
		screen20.addActionListener(new compScreenRadioListener());
		screen25.addActionListener(new compScreenRadioListener());
		
		tvCheckButton.addActionListener(new tvCheckListener());
		compCheckButton.addActionListener(new compCheckListener());
	}

	/**
	 * Action listener for TV type radio buttons
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
			if (e.getSource() == LCDrButton)
			{
				tvType = "LCD";
			}
		}
	}

	/**
	 * Action listener for TV screen size radio buttons
	 */
	private class tvScreenRadioListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == screen40) tvSize = 40;
			if (e.getSource() == screen50) tvSize = 50;
			if (e.getSource() == screen60) tvSize = 60;
		}
	}

	/**
	 * Action listener for computer screen size radio buttons
	 */
	private class compScreenRadioListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == screen15) compSize = 15;
			if (e.getSource() == screen20) compSize = 20;
			if (e.getSource() == screen25) compSize = 25;
		}
	}

	/**
	 * Action listener to check tv quantity and if tv spec exists in inventory
	 */
	private class tvCheckListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int quantity = system.searchTVInventory("TV", tvSize, tvType);
			if(quantity > 0)
			{
				JOptionPane.showMessageDialog(CheckWindow.this, "Quantity of TV " 
						+ tvSize + "in " + tvType + " is:     " + quantity);
			}
			else
			{
				JOptionPane.showMessageDialog(CheckWindow.this, "Item does not exist");
			}
		}
	}
	
	/**
	 * Action listener to check computer quantity and if tv spec exists in inventory
	 */
	private class compCheckListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int quantity = system.searchComputerInventory("COMPUTER", compSize);
			if(quantity > 0)
			{
				JOptionPane.showMessageDialog(CheckWindow.this, "Quantity of Computer " 
						+ compSize + "in is:     " + quantity);
			}
			else
			{
				JOptionPane.showMessageDialog(CheckWindow.this, "Item does not exist");
			}	
		}
	}
	
	/**
	 * Action listener when user clicks exit button on add window
	 * Takes user back to main view window
	 */
	private class exitButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == exitButton)
			{
				frame.dispose();
				try
				{
					InventoryMainView mWindow = new InventoryMainView(system);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
}
