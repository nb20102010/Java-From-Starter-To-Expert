/**
 * 
 */

/**
 * @author lr
 *
 */
public class Demo3_2 {

	/**
	 * @param args
	 */
	/*static int i = 1;
	
	//静态区域块，在定义类时执行一次
	static {
		System.out.println("a");
		i++;
	}
	
	public Demo3_2() {
		System.out.println("b");
		i++;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Demo3_2 t1 = new Demo3_2();
		System.out.println(t1.i);
		
		Demo3_2 t2 = new Demo3_2();
		System.out.println(t2.i); */
		
	/*	Stu stu1 = new Stu(23, "aa", 340);
		Stu stu2 = new Stu(23, "bb", 240);
		
		System.out.println(Stu.getTotalFee()); */
		
		Clerk c1 = new Clerk("小花", 24, 4567.6f);
		System.out.println("名字是" + c1.name);
	//	System.out.println("年龄是" + c1.age); 错误！不可见变量
		System.out.println("年龄是" + c1.getSal());
		
	}

}



//职员类
class Clerk{
	
	public String name;
	private int age;
	private float salary;
	
	public Clerk(String name, int age, float salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	//通过一个成员方法控制和访问私有属性
	public float getSal() {
		return this.salary;
	}
}


//学生类
class Stu{
	
	int age;
	String name;
	int fee;
	
	static int totalFee;
	
	public Stu(int age, String name, int fee) {
		
		this.age = age;
		this.name = name;
		totalFee += fee;
	}
	
	
	//java中规则：类变量原则上用类方法访问
	//静态方法只能访问静态变量
	public static int getTotalFee() {
		//age++; 错误，不能访问非静态变量
		return totalFee;
	}
}

class Stu2 extends Stu{
	public Stu2(){
		super(1, "aa", 1);
		System.out.println(Stu.totalFee);
	}
}
