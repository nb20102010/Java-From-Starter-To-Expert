/**
 *  function : show event processing
 */

package com.test3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo9_3 extends JFrame implements ActionListener{

	//define a panel
	JPanel mp = null;
	JButton jb1 = null;
	JButton jb2 = null;
	
	public static void main(String[] args){
		Demo9_3 demo9_3 = new Demo9_3();
	}
	
	public Demo9_3(){
		mp = new JPanel();
		jb1 = new JButton("black");
		jb2 = new JButton("red");
		
		mp.setBackground(Color.BLACK);		
		this.add(jb1, BorderLayout.NORTH);
		this.add(mp);
		this.add(jb2, BorderLayout.SOUTH);
		
		Cat myCat1 = new Cat();
		
		//register listening
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jb1.addActionListener(myCat1);
		jb2.addActionListener(myCat1);
		
		//assign action command
		jb1.setActionCommand("black");		
		jb2.setActionCommand("red");
		
		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent e){
		
		// figure out which button is pressed
		if(e.getActionCommand().equals("black")){
			System.out.println("You pressed black button");
			mp.setBackground(Color.black);
		} else if (e.getActionCommand().equals("red")) {
			System.out.println("You pressed red button");
			mp.setBackground(Color.red);
		} else {
			System.out.println("No idea");
		}
	}
}

class Cat implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("black")){
			System.out.println("Cat also knows you pressed black button");
		} else if(e.getActionCommand().equals("red")){
			System.out.println("Cat also knows you pressed red button");
		}
	}
	
}

/*class MyPanel extends JPanel{
	

	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 200, height);
	}
} */