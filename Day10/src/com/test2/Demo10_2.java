package com.test2;

public class Demo10_2 {

	public static void main(String[] args){
		Dog dog = new Dog();
		Thread t = new Thread(dog);
		t.start();
	}
}

class Dog implements Runnable{
	
	int times = 0;
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("Hello world! " + times);
		if(times > 10) break;
		}	
		
	}
}