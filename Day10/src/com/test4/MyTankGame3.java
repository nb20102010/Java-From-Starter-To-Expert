/**
 * function : tank game 1.0
 * draw a tank
 */

package com.test4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame3 extends JFrame{
	
	MyPanel mp = null;
	public static void main(String[] args){
		MyTankGame3 mtg = new MyTankGame3();
	}
	
	//constructor
	public MyTankGame3(){
		mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setVisible(true);
		Thread t = new Thread(mp);
		t.start();
	}
}

//My Panel
class MyPanel extends JPanel implements KeyListener,Runnable{
	
	//define a mytank
	Hero hero = null;
	Vector<EnemyTank> ets = new Vector<>();
	int enSize = 3;
	
	//constructor
	public MyPanel(){
		
		hero = new Hero(100, 100);
		
		for(int i = 0; i < enSize; i++){
			EnemyTank et = new EnemyTank((i+1)*50, 0);
			et.setColor(0);
			et.setDirect(2);
			ets.addElement(et);
		}
	}
	// override paint
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getSpeed());
		
		if(hero.s != null && hero.s.isLive){
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		
		for(int i = 0; i < ets.size(); i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 0);
		}
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
			g.fill3DRect(x + 25, y, 5, 30, false);
			//3 draw the central rectangle
			g.fill3DRect(x + 5, y + 5, 20, 20, false);
			//4 draw the central circle
			g.fillOval(x + 10, y + 10, 10, 10);
			//5 draw the line
			g.drawLine(x + 15, y, x + 15, y + 15);
			break;
		case 1 :
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y + 25, 30, 5, false);
			g.fill3DRect(x + 5, y + 5, 20, 20, false);
			g.fillOval(x + 10, y + 10, 10, 10);
			g.drawLine(x + 15, y + 15, x + 30, y + 15);
			break;
		case 2 :
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x + 25, y, 5, 30, false);
			g.fill3DRect(x + 5, y + 5, 20, 20, false);
			g.fillOval(x + 10, y + 10, 10, 10);
			g.drawLine(x + 15, y + 15, x + 15, y + 30);
			break;
		case 3 :
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y + 25, 30, 5, false);
			g.fill3DRect(x + 5, y + 5, 20, 20, false);
			g.fillOval(x + 10, y + 10, 10, 10);
			g.drawLine(x, y + 15, x + 15, y + 15);
		}
		
			
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W){
			
			this.hero.setDirect(0);
			this.hero.moveUp();
			
		} else if(e.getKeyCode() == KeyEvent.VK_D){
			
			this.hero.setDirect(1);
			this.hero.moveRight();
			
		} else if(e.getKeyCode() == KeyEvent.VK_S){
			
			this.hero.setDirect(2);
			this.hero.moveDown();
			
		} else if(e.getKeyCode() == KeyEvent.VK_A){
			
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_J){
			this.hero.shotEnemy();
		}
	//	this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}

