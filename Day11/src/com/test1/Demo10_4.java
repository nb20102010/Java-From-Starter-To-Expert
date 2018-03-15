package com.test1;

public class Demo10_4 {

	public static void main(String[] args){
		Cat cat1 = new Cat();
		cat1.start();
		//cat1.start(); Thread cannot start twice
		Dog dog1 = new Dog();
		Thread t = new Thread(dog1);
		Thread t2 = new Thread(dog1);
		t.start();
		t2.start(); //This is allowed
	}
}

//Cat class
class Cat extends Thread{
	public void run(){
		System.out.println("11");
	}
}

class Dog implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("22");
	}
	
}