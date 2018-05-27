/*
 * the necessity of 'this'
 */
public class Demo3_1 {
	
	public static void main(String[] args) {
		
		Dog dog1 = new Dog(2, "Dahuang");
		
		Person p1 = new Person(dog1, 23, "Guo Degang");
		Person p2 = new Person(dog1, 24, "Liu Qian");
		p1.showInfo();
		p1.dog.showInfo();
		dog1.name = "Xiaohuang";
		p1.dog.showInfo();
		
		int total = 0;
		Child ch1 = new Child(3, "��");
		ch1.join();
		Child ch2 = new Child(4, "СС");
		ch2.join();
		Child ch3 = new Child(4, "���");
		ch3.join();
		
		System.out.println("����=" + Child.total);
	}
}


//Define a 'Person' class
class Person{
	int age;
	String name;
	Dog dog; //��������
	public Person(Dog dog, int age, String name) {
		this.age = age;
		this.name = name;
		this.dog = dog;
	}
	
	/*
	 * Show the person's name
	 */
	public void showInfo() {
		System.out.println("Name: " + name);
	}
	
}

//����С����
class Child{
	
	int age;
	String name;
	
	static int total = 0;
	
	public Child(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void join() {
		System.out.println("��һ��С�������ˡ�");
		total++;
	}
	
}

class Dog{
	int age;
	String name;
	
	public Dog(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("Dog: "+ name);
	}
	
}