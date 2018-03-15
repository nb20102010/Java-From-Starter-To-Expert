/**
 * show how to develop thread through inherit Thread
 */

package com.test1;

public class Demo10_1 {
	
	public static void main(String[] args){
		
		Cat cat = new Cat();
		// start thread, run() function runs
		cat.start();
	}
}

class Cat extends Thread{
	int times = 0;
	// override run
	public void run(){
		while(true){
			//sleep 1 second
			// sleep will put thread to blocked status,
			// and free resource
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("Hello world! " + times);
			
			if(times == 10) break;
		}
			
	}
}
