/**
 * function : tank game 1.0
 * draw a tank
 */

package com.test1;
import javax.swing.*;
import java.awt.*;


public class MyTankGame1 extends JFrame{
	
	MyPanel mp = null;
	public static void main(String[] args){
		MyTankGame1 mtg = new MyTankGame1();
	}
	
	//constructor
	public MyTankGame1(){
		mp = new MyPanel();
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
		
	}
}

//My Panel
class MyPanel extends JPanel{
	
	//define a mytank
	Hero hero = null;
	
	//constructor
	public MyPanel(){
		
		hero = new Hero(10, 10);
	}
	// override paint
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	
	//draw tank function
	public void drawTank(int x, int y, Graphics g, int direct, int type){
		
		//tank type
		switch(type){
		case 0 :
			g.setColor(Color.cyan);
			break;
		case 1 :
			g.setColor(Color.yellow);
			break;
		}
		
		//tank direction
		switch(direct){
		case 0 :
			//1 draw the rectangle on the left
			g.fill3DRect(x, y, 5, 30, false);
			//2 draw the rectangle on the right
			g.fill3DRect(x + 15, y, 5, 30, false);
			//3 draw the central rectangle
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			//4 draw the central circle
			g.fillOval(x + 5, y + 10, 10, 10);
			//5 draw the line
			g.drawLine(x + 10, y, hero.getX() + 10, y + 15);

		}
		
	}
}

// tank class
class Tank{


	// x coordinate
	int x = 0;
	// y coordinate
	int y = 0;
	
	public Tank(int x, int y){
		this.x = x;
		this.y = y;
	}
			
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}

// my tank
class Hero extends Tank{
	
	public Hero(int x, int y){
		super(x, y);
	}
}
