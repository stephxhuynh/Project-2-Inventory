import javax.swing.*;		// Needed for Swing classes
import java.awt.event.*;	// Needed for ActionListener Interface
import java.awt.*;			// Needed for Color class

public class InventoryMainView extends JFrame
{
	private JFrame frame;			// To reference the J frame
	private JPanel mainPanel;		// To reference the main panel
	private JPanel buttonPanel;		// To reference the button panel
	private JPanel infoPanel;		// To reference the info panel
	private JButton addButton;		// To reference an add button
	private JButton checkButton;	// To reference a check button
	
	final int WINDOW_WIDTH = 1000;		// Window width in pixels
	final int WINDOW_HEIGHT = 500;		// Window height in pixels
	
	/**
	 * Constructor
	 */
	public InventoryMainView()
	{	
		// Crete new JFrame
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
		mainPanel.add(infoPanel, BorderLayout.EAST);
		
		frame.setVisible(true);
	}
	
	private void buildMainPanel()
	{
		// Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1, 30, 30));
		addButton = new JButton("Add");
		checkButton = new JButton("Check");
		buttonPanel.add(addButton);
		buttonPanel.add(checkButton);
		
		addButton.addActionListener(new ButtonListener());
		checkButton.addActionListener(new ButtonListener());
		
		// Info Panel
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == checkButton)
			{
				frame.dispose();
				CheckWindow cWindow = new CheckWindow();
			}
			if(e.getSource() == addButton)
			{
				frame.dispose();
				AddWindow aWindow = new AddWindow();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new InventoryMainView();
	}
}
