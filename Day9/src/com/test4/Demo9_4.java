/**
 * function : better understand event processing
 * move the ball by pressing direction buttons
 */

package com.test4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Demo9_4 extends JFrame{
	
	MyPanel mp = null;
	public static void main(String[] args){
		Demo9_4 demo9_4 = new Demo9_4();
	}
	
	//constructor
	public Demo9_4(){
		mp = new MyPanel();
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

//define my own panel
class MyPanel extends JPanel implements KeyListener{
	
	int x = 10;
	int y = 10;
	
	public void paint(Graphics g){
		
		super.paint(g);		
		
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y++;
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			y--;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x--;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			x++;
		}
		
		//call repaint method
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

