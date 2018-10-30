package bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class userForget{
	JLabel jl1,jl2,jl3;
	JTextField jtf1,jtf2,jtf3;
	JButton jb1;
	JFrame jf;
	userForget(){
		jf = new JFrame("Forget Password");
		jf.setLayout(null);
		
		jl1 = new JLabel("User ID : ");
		jl1.setBounds(100,100,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		
		jl2 = new JLabel("Security Question : ");
		jl2.setBounds(100,160,120,30);
		jf.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(250, 160, 400, 30);
		jf.add(jtf2);
		
		jl3 = new JLabel("Security Answer : ");
		jl3.setBounds(100,210,120,30);
		jf.add(jl3);
		
		jtf3 = new JTextField();
		jtf3.setBounds(250, 210, 140, 30);
		jf.add(jtf3);
		
		
		jb1 = new JButton("Get Password ");
		jb1.setBounds(250, 270, 140, 30);
		jf.add(jb1);	
		
		
		jf.setSize(700, 500);
		jf.setVisible(true);
	}
}
