import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.awt.*;			// Needed for Color class


public class CheckWindow extends JFrame
{
	private JFrame frame;						// To reference the J frame
	private JPanel mainPanel;					// To reference the main panel
	private JPanel categoryPanel;				// To reference the message panel
	private JPanel specPanel;					// To reference the specification panel
	private JPanel typePanel;					// To reference the TV type panel
	private JLabel TVLabel;						// To reference the TV label
	private JLabel compLabel;					// To reference the computer label
	private JLabel typeLabel;					// To reference the type label
	private JRadioButton OLEDrButton;			// To reference OLED radio button
	private JRadioButton LCDrButton;			// To reference LCD radio button
	private ButtonGroup typeRadioButtonGroup;	// To reference the type radio button group
	
	final int WINDOW_WIDTH = 500;
	final int WINDOW_HEIGHT = 250;
	
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
		mainPanel.setLayout(new BorderLayout());
		
		buildMainPanel();
		
		frame.add(mainPanel);
		
		mainPanel.add(categoryPanel, BorderLayout.WEST);
		mainPanel.add(specPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	private void buildMainPanel()
	{
		// Category Panel
		categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(2, 1, 30, 30));
		TVLabel = new JLabel("TV");
		compLabel = new JLabel("Computer");
		categoryPanel.add(TVLabel);
		categoryPanel.add(compLabel);
		
		// Specifications Panel
		specPanel = new JPanel();
		specPanel.setLayout(new GridLayout(2, 3, 25, 25));
		
		// Type panel inside spec panel
		typePanel = new JPanel();
		typePanel.setLayout(new GridLayout(1, 2, 10, 10));
		typeLabel = new JLabel("Type");
		OLEDrButton = new JRadioButton("OLED");
		LCDrButton = new JRadioButton("LCD");
		// Group type radio buttons
		typeRadioButtonGroup = new ButtonGroup();
		typeRadioButtonGroup.add(OLEDrButton);
		typeRadioButtonGroup.add(LCDrButton);
		specPanel.add(typePanel);
		
		
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
