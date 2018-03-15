package com.test3;

public class Demo10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig = new Pig(10);
		Bird bird = new Bird(10);
		
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(bird);	
		
		t1.start();
		t2.start();
	}

}

class Bird implements Runnable{
	
	int n = 0;
	int res = 0;
	int times = 0;
	public Bird(int n){
		this.n = n;
	}
	
	public void run(){
		while(true){
			try{
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
			res += (++times);
			System.out.println("The curr result is " + res);
			if(times == n){
				System.out.println("The result is " + res);
				break;
			}
		}
	}
}

class Pig implements Runnable{
	int n = 0;
	int times = 0;
	
	public Pig(int n){
		this.n = n;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			times++;
			System.out.println("I am a thread, printing " + times + " hellow world..");
			if(times >= n) break;
		}
	}
}
