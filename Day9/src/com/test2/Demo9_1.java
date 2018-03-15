/**
 * java draw fundamental
 */

package com.test2;
import javax.swing.*;
import java.awt.*;

public class Demo9_1 extends JFrame{
	
	/**
	 * @param args
	 */
	MyPanel mp = null;
	public static void main(String[] args) {
		Demo9_1 demo9_1 = new Demo9_1();
	}
	
	public Demo9_1(){
		mp = new MyPanel();
		this.add(mp);
		this.setSize(640, 960);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//Define a MyPanel (My own panel, used for painting and display)
class MyPanel extends JPanel{
	
	//Override paint method of JPanel
	//Graphics is an important class for painting, think it as a pen
	public void paint(Graphics g){
		
		//call parent method for initialization
		//this cannot be omitted
		super.paint(g);
		//System.out.println("paint is called");
		//draw a circle
		//g.drawOval(10, 10, 30, 30);
		//draw a straight line
		//g.drawLine(10, 10, 40, 40);
		//draw rectangle edge
		//g.drawRect(10, 10, 40, 60);
		//draw filled rectangle
		//set rectangle color
//		g.setColor(Color.blue);
//		g.fillRect(10, 10, 40, 60);
//		g.setColor(Color.red);
//		g.fillRect(70, 70, 40, 60);
		
		//draw an image on the panel
		//Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/27a3c15fe4556045d9abf7226235a044.jpg"));
		//display
		//g.drawImage(im, 0, 0, 640, 960, this);
		
		//draw string
		g.setColor(Color.red);
		g.setFont(new Font("ºÚÌå", Font.BOLD, 50));
		g.drawString("×æ¹úÍòËê", 100, 100);
	}
}
