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
		Shot s = new Shot(this.x, this.y, this.direct);
		ss.add(s);
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
class EnemyTank extends Tank implements Runnable{
	
	boolean isLive = true;
	Vector<Shot> ss = new Vector<>();
	int cd = 2;
	public EnemyTank(int x, int y){
		super(x, y);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			cd--;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < ss.size(); i++){
				Shot s = ss.get(i);
				if(s.isLive == false){
					ss.remove(s);
				}
			}
			if(ss.size() < 5 && cd < 0){
				Shot s = new Shot(this.x, this.y, this.direct);
				ss.add(s);
				Thread t = new Thread(s);
				t.start();
				cd = 2;
			}
			
			switch(this.direct){
			case 0 :
				for(int i = 0; i < 30; i++){
					if(y > 0) y -= speed;
					else break;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 1 : 
				for(int i = 0; i < 30; i++){
					if(x < 370) x += speed;
					else break;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2 :
				for(int i = 0; i < 30; i++){
					if(y < 270) y += speed;
					else break;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 3 :
				for(int i = 0; i < 30; i++){
					if(x > 0) x -= speed;
					else break;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			
			this.direct = (int)(Math.random() * 4);
			if(this.isLive == false){
				break;
			}
		}
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
		this.direct = direct;
		switch(direct){
		case 0 :
			this.x = x + 15;
			this.y = y;
			break;
		case 1 :
			this.x = x + 30;
			this.y = y + 15;
			break;
		case 2 :
			this.x = x + 15;
			this.y = y + 30;
			break;
		case 3 :
			this.x = x;
			this.y = y + 15;
			break;
		}
		
		
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
			//when should the bullet die?
			
			//judge whether the bullet reaches the panel edge
			if(x < 0 || x > 400 || y < 0 || y > 300){				
				this.isLive = false;
				break;
			}
		}
	}
}

class Bomb{
	int x;
	int y;
	
	int life = 40;
	boolean isLive = true;
	public Bomb(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void lifeDown(){
		if(life > 0) life--;
		else this.isLive = false;
	}
}
