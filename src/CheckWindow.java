import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.awt.*;			// Needed for Color class


public class CheckWindow extends JFrame
{
	// Panels
	private JFrame frame;						// To reference the J frame
	private JPanel mainPanel;					// To reference the main panel
	private JPanel categoryPanel;				// To reference the message panel
	private JPanel specTVPanel;					// To reference the specification panel
	private JPanel specCompPanel;
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
	private JRadioButton screen40;				// To reference 40 inch tv screen size
	private JRadioButton screen50;				// To reference 50 inch tv screen size
	private JRadioButton screen60;				// To reference 60 inch tv screen size
	private ButtonGroup screenTVButtonGroup;	// To reference tv screen size button group
	
	// Comp screen size
	private JPanel compScreenPanel;				// To reference the computer screen size panel
	private JLabel compLabel;					// To reference the computer label
	private JLabel compSizeLabel;				// To reference the computer size label
	private JRadioButton screen15;				// To reference 15 inch computer screen size
	private JRadioButton screen20;				// To reference 15 inch computer screen size
	private JRadioButton screen25;				// To reference 15 inch computer screen size
	private ButtonGroup compScreenButtonGroup;	// To reference computer screen size button group
	
	// Quantity
	private JTextField tvQuantityTextField;		// To reference the tv quantity text field
	private JTextField compQuantityTextField;	// To reference the computer quantity text field
	private JPanel tvQuantityPanel;				// To reference the tv quantity panel
	private JLabel tvQuantityLabel;				// To reference the tv quantity label
	private JPanel compQuantityPanel;			// To reference the computer quantity panel
	private JLabel compQuantityLabel;			// To reference the computer quantity label
	
	// Window size
	final int WINDOW_WIDTH = 500;
	final int WINDOW_HEIGHT = 250;
	
	/**
	 * Constructor
	 */
	public CheckWindow()
	{
		// Create new JFrame
		frame = new JFrame();
		
		// Set the title.
		frame.setTitle("Check");
		
		// Set the size of the window.
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 2, 50, 50));
		
		buildMainPanel();
		
		frame.add(mainPanel);
		
		mainPanel.add(TVLabel);
		mainPanel.add(specTVPanel);
		mainPanel.add(compLabel);
		mainPanel.add(specCompPanel);
		frame.setVisible(true);
	}
	
	private void buildMainPanel()
	{
		// Category Panel
		TVLabel = new JLabel("TV");
		compLabel = new JLabel("Computer");
		
		// Specifications Panel
		specTVPanel = new JPanel();
		specTVPanel.setLayout(new GridLayout(1, 0));
		specCompPanel = new JPanel();
		specCompPanel.setLayout(new GridLayout(1, 0));
		
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
		tvScreenPanel.setLayout(new GridLayout(4,1));
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
		compScreenPanel.setLayout(new GridLayout(4,1));
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
		
		// Quantity panel
		tvQuantityLabel = new JLabel("Quantity");
		tvQuantityTextField = new JTextField(5);
		compQuantityTextField = new JTextField(5);
		tvQuantityPanel = new JPanel();
		tvQuantityPanel.add(tvQuantityLabel);
		tvQuantityPanel.add(tvQuantityTextField);
		
		compQuantityPanel = new JPanel();
		compQuantityLabel = new JLabel("Quantity");
		compQuantityPanel.add(compQuantityLabel);
		compQuantityPanel.add(compQuantityTextField);
		
		// Add panels to spec panel
		specTVPanel.add(typePanel);
		specTVPanel.add(tvScreenPanel);
		specTVPanel.add(tvQuantityPanel);
		
		specCompPanel.add(compScreenPanel);
		specCompPanel.add(compQuantityPanel);
		
	}
	
	private class RadioButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == OLEDrButton)
			{
			}
		}
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
