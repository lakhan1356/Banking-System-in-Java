package bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class submitLoan{
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1;
	JFrame jf;
	submitLoan(){
		jf = new JFrame("Submit Loan");
		jf.setLayout(null);
		
		jl1 = new JLabel("Loan ID : ");
		jl1.setBounds(100,100,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		
		jl2 = new JLabel("Loan Amount : ");
		jl2.setBounds(100,160,120,30);
		jf.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(250, 160, 140, 30);
		jf.add(jtf2);
		
		jb1 = new JButton("Submit ");
		jb1.setBounds(250, 270, 140, 30);
		jf.add(jb1);	
		
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}