package com.test2;

public class Demo10_5 {

	public static void main(String[] args){
		//Define 3 ticket windows
		TicketWindow tw1 = new TicketWindow();
		
	//	TicketWindow tw2 = new TicketWindow();
	//	TicketWindow tw3 = new TicketWindow();
		
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class TicketWindow implements Runnable{
	
	//2000 tickets in total
	private int nums = 2000;
	private Dog myDog = new Dog();
	public void run(){
		while(true){
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//judge whether sold out
			//guarantee if-else atomic
			synchronized(myDog){
				if(nums >= 0){
					
						// show remaining ticket info
						// Thread.currentThread().getName() get current thread name
						System.out.println(Thread.currentThread().getName() + " selling " + nums + " tickets...");

						
						nums--;
					
				} else {
					// sale ends
					break;
				}
			}
		}
	}
}

class Dog{
	
}