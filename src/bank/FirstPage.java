package bank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import bank.FirstPage.abc;
//import bank.FirstPage.bcd;

class FirstPage{
	JButton jb1,jb2;
	JLabel jl;
	JFrame jf;
	JPanel jp;
	FirstPage(){
		jf = new JFrame("Banking System");
		jf.setLayout(null);
		
		jp=new MyPanel();
		jp.setBounds(100,400,100,100);
		jf.add(jp);
		
		jl = new JLabel("Welcome to Your Bank");
		jl.setBounds(150, 30, 250, 100);
		jf.add(jl);
		
		jb1 = new JButton("Admin ");
		jb1.setBounds(50, 150, 150, 30);
		jf.add(jb1);
		jb1.addActionListener(new abc());
		
		jb2 = new JButton("User ");
		jb2.setBounds(230, 150, 150, 30);
		jf.add(jb2);
		jb2.addActionListener(new bcd());
		
		jf.setSize(jf.getToolkit().getScreenSize());
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class abc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			jf.dispose();
			new adminLogin();
		}
	}
	class bcd implements ActionListener{
		public void actionPerformed(ActionEvent e){
			jf.dispose();
			new userLogin();
		}
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			//g.fillOval(0, 0, 100, 100);
			//g.setColor(Color.white);
			/*Image ii = new ImageIcon("image/Desert.jpg").getImage();
			g.drawImage(ii, 0,0,this.getWidth(),this.getHeight(),this);*/
			//jp.add(ii);
			
		}
	}
}