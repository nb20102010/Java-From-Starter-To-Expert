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
	
	//��̬����飬�ڶ�����ʱִ��һ��
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
		
		Clerk c1 = new Clerk("С��", 24, 4567.6f);
		System.out.println("������" + c1.name);
	//	System.out.println("������" + c1.age); ���󣡲��ɼ�����
		System.out.println("������" + c1.getSal());
		
	}

}



//ְԱ��
class Clerk{
	
	public String name;
	private int age;
	private float salary;
	
	public Clerk(String name, int age, float salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	//ͨ��һ����Ա�������ƺͷ���˽������
	public float getSal() {
		return this.salary;
	}
}


//ѧ����
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
	
	
	//java�й��������ԭ�������෽������
	//��̬����ֻ�ܷ��ʾ�̬����
	public static int getTotalFee() {
		//age++; ���󣬲��ܷ��ʷǾ�̬����
		return totalFee;
	}
}

class Stu2 extends Stu{
	public Stu2(){
		super(1, "aa", 1);
		System.out.println(Stu.totalFee);
	}
}
