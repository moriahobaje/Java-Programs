package race_car;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() 
	{

		JFrame MainFrame = new JFrame();
		
		//instantiate panel class
		Panel1 screen = new Panel1();
		
		//edit Frame
		MainFrame.add(screen);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		MainFrame.setSize(850,650);
		MainFrame.setVisible(true);
		
	}
	
}
