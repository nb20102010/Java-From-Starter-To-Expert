/**
 * function : tank game 2.0
 * draw a tank
 * my tank can move
 * my tank can shoot
 * 
 */

package com.test3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame4 extends JFrame{
	
	MyPanel mp = null;
	public static void main(String[] args){
		MyTankGame4 mtg = new MyTankGame4();
	}
	
	//constructor
	public MyTankGame4(){
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
	Vector<Bomb> bombs = new Vector<>();
	int enSize = 3;
	
	//define image;
	Image image = null;
	
	//constructor
	public MyPanel(){
		
		hero = new Hero(100, 100);
		
		for(int i = 0; i < enSize; i++){
			EnemyTank et = new EnemyTank((i+1)*60, 0);
			et.setColor(0);
			et.setDirect(2);
			Thread t = new Thread(et);
			t.start();
			Shot s = new Shot(et.x, et.y, 2);
			
			et.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();
			ets.add(et);
		}
		
		//initialize image
		image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb.gif"));
	}
	// override paint
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getSpeed());
		
		for(int i = 0; i < hero.ss.size(); i++){
			Shot s = hero.ss.get(i);
			if(s != null && s.isLive){
				g.draw3DRect(s.x, s.y, 1, 1, false);
			}
			if(s.isLive == false){
				hero.ss.remove(s);
				i--;
			}
		}
		
		for(int i = 0; i < ets.size(); i++){
			EnemyTank et = ets.get(i);
			if(et.isLive){
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 0);
				for(int j = 0; j <et.ss.size(); j++){
					Shot s = et.ss.get(j);
					if(s.isLive){
						g.draw3DRect(s.x, s.y, 1, 1, false);
					}
				}
			}
		}
		
		for(int i = 0; i < bombs.size(); i++){
			Bomb b = bombs.get(i);
			if(b.life > 0)
				g.drawImage(image, b.x, b.y, 30, 30, this);
			b.lifeDown();
			if(b.life == 0){
				bombs.remove(b);
			}
		}
	}
	//judge whether hit the enemy
	public void hitTank(Shot s, EnemyTank et){
		
		if(s.x > et.x && s.x < et.x+30 && s.y > et.y && s.y < et.y + 30){
			//bullet dies
			s.isLive = false;
			//enemy tank dies
			et.isLive = false;
			//creat a bomb. add it to the vector 
			Bomb b = new Bomb(et.x, et.y);
			bombs.add(b);
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
			if(this.hero.ss.size() <= 5)
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
			//
			for(int i = 0; i < hero.ss.size(); i++){
				Shot s = hero.ss.get(i);
				if(s.isLive){
					for(int j = 0; j < ets.size(); j++){
						EnemyTank et = ets.get(j);
						if(et.isLive){
							this.hitTank(s, et);
						}
					}
				}
			}
			
			
			//repaint
			this.repaint();
		}
	}
}

