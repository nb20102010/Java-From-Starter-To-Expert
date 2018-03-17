package com.test3;

import java.util.*;

//tank class
class Tank{


	// x coordinate
	int x = 0;
	// y coordinate
	int y = 0;	
	//tank direction
	int direct = 0;
	//tank speed
	int speed = 1;
	//tank color
	int color = 0;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

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

//my tank
class Hero extends Tank{
	
	//bullet
	Vector<Shot> ss = new Vector<>();
	
	
	public Hero(int x, int y){
		super(x, y);
		
	}
	
	//shoot
	public void shotEnemy(){
		Shot s = null;
		switch(this.direct){
		case 0 :
			s = new Shot(x + 15, y, 0);
			ss.add(s);
			break;
		case 1 :
			s = new Shot(x + 30, y + 15, 1);
			ss.add(s);
			break;
		case 2 :
			s = new Shot(x + 15, y + 30, 2);
			ss.add(s);
			break;
		case 3 :
			s = new Shot(x, y + 15, 3);
			ss.add(s);			
		}
		
		Thread t = new Thread(s);
		t.start();
	}
	
	public void moveUp(){
		y -= speed;
	}
	public void moveRight(){
		x += speed;
	}
	public void moveDown(){
		y += speed;
	}
	public void moveLeft(){
		x -= speed;
	}
}

//enemy tank
class EnemyTank extends Tank{
	
	public EnemyTank(int x, int y){
		super(x, y);
	}
}


//
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed = 2;
	boolean isLive = true;
	public Shot(int x, int y, int direct){
		this.x = x;
		this.y = y;
		this.direct = direct;
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
			switch(direct){
			case 0 : //up
				y -= speed;
				break;
			case 1 : //right
				x += speed;
				break;
			case 2 : 
				y += speed;
				break;
			case 3 :
				x -= speed;
				break;
			}
			
			System.out.println(x + "," + y);
			//when should the bullet die?
			
			//judge whether the bullet reaches the panel edge
			if(x < 0 || x > 400 || y < 0 || y > 300){				
				this.isLive = false;
				break;
			}
		}
	}
}
