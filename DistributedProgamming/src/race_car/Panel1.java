package race_car;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel1 extends JPanel implements ActionListener, KeyListener{
	Player player = new Player();
	Timer t;
	File f1 = null;
	File f2 = null;
	boolean check = false; 
	String path_1 = null;
	String path_2 = null;
	
	int x_red =  400; 
	int y_red = 500;
	int vx_red,vy_red = 5;
	
	int x_blue = 400; 
	int y_blue = 550;
	int vx_blue,vy_blue = 5;
	
	int[] dir = new int[16]; 
	int i;
	int j = 16;
	int limit = 17;  

	ImageIcon[] image_1 = new ImageIcon[limit]; 
	ImageIcon[] image_2 = new ImageIcon[limit]; 
	
	public Panel1() {	
		
		
		//i = i+1; 
		 for(i = 1; i < limit; i++) 
		 {
			 try {
			 path_1 = "img/blue/Blue"+ i + ".png";
			 path_2 = "img/red/Red"+ i + ".png";
			 
			 f1 = new File(path_1);
			 f2 = new File(path_2);
				
				image_1[i] = new ImageIcon(path_1);
				image_2[i] = new ImageIcon(path_2);
				
				
				System.out.println(image_1[i]); 
				System.out.println(image_2[i]); 
	
			 }
			 catch(Exception e) 
			 {
				 System.out.print("Image not found!" + e.getMessage());
			 }
		 
		 }
		 
		t = new Timer(100,this);
		//t.start();
		addKeyListener(this);
		setFocusable(true); 
		setFocusTraversalKeysEnabled(false); 
		
		
	    }
	

	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);       

	        // Draw Text
	        g.drawString("Racing Game", 120, 90);
	        Color c1 = Color.green;
	        Color c2 = Color.black;
	        Color c3 = Color.yellow;
	        Color c4 = Color.white;
	        g.setColor(c1);
	        g.fillRect( 150, 200, 550, 300 );
	        
	        g.setColor(c2);
	        g.drawRect(50, 100, 750, 500);
	        g.drawRect(150,200, 550, 300);
	        
	        g.setColor(c3);
	        g.drawRect( 100, 150, 650, 400 );
	        
	        g.setColor(c4);
	        ((Graphics2D) g).setStroke(new BasicStroke(10));
	        g.drawLine( 425, 500, 425, 600);
	       
	   //   g.drawImage(image_1[1], 50, 50, null);

			//counter-clockwise rotation
		/*	if(j == 1) {
				j = 16;
			}
			else {
				j = j - 1;
			} */
			
	        //paint icon
	        
			image_1[5].paintIcon(this, g, (x_blue), (y_blue));
			image_2[5].paintIcon(this, g, (x_red), (y_red));

	   }

		@Override
		public void actionPerformed(ActionEvent e) {
		// position change
		if(x_red < 50 || x_blue < 50)  
		{
			vx_red = 0;
			x_red = 50;
		}
		if(x_red > 750 || x_blue >750) 
		{
			vx_red = 0; 
			x_red = 750;
		}
		
		if(y_red < 100 || y_blue < 100) 
		{
			vy_red = 0; 
			y_red = 100;
		} 
		
		if( y_red > 550 || y_blue > 550) 
		{
			vy_red = 0;
			y_red = 550; 		
		}
			
		x_red += vx_red;
		y_red += vy_red;
		
		x_blue += vx_blue; 
		y_blue += vy_blue; 
		
		repaint();
			
		}


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		 
		int c = e.getExtendedKeyCode(); 
		
		// Binding for Red Car
		if (c==KeyEvent.VK_LEFT)
		{ 
			vx_red = -5; 
			vy_red = 0; 	
			t.start();
		}
		if(c == KeyEvent.VK_UP) 
		{
			vx_red = 0; 
			vy_red = -5; 
			t.start();
		}
		if(c == KeyEvent.VK_RIGHT) 
		{
			vx_red = 5; 
			vy_red = 0;
			t.start();
		}
		if(c == KeyEvent.VK_DOWN) 
		{
			vx_red = 0; 
			vy_red = 5; 
			t.start();
		}
		 
		//Binding for Blue Car
		
		if(c == KeyEvent.VK_W) 
		{
			vx_blue = 0; 
			vy_blue = -5; 
			t.start();
		}
		if(c == KeyEvent.VK_S) 
		{
			vx_blue = 0; 
			vy_blue = 5; 
			t.start();
		}
		if(c == KeyEvent.VK_A) 
		{
			vx_blue = -5; 
			vy_blue = 0; 	
			t.start();
		}
		if(c == KeyEvent.VK_D) 
		{
			vx_blue = 5; 
			vy_blue = 0;
			t.start();
		}
		 
		 
		
		}


		@Override
		public void keyReleased(KeyEvent e) {
			// stop vehicle at current location
			vx_red = 0;
			vy_red = 0; 
			
			vx_blue =0; 
			vy_blue = 0; 
	
			}	
		
		}  
	   

