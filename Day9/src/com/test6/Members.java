package com.test6;

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
	
	
	public Hero(int x, int y){
		super(x, y);
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
