package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class applyLoan{
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1;
	JFrame jf;
	int accountno;
	applyLoan(int accountno){
		this.accountno=accountno;
		
		jf = new JFrame("Apply Loan");
		jf.setLayout(null);
		
		jl1 = new JLabel("Laon Amount : ");
		jl1.setBounds(100,100,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		
		jl2 = new JLabel("Loan Duration : ");
		jl2.setBounds(100,160,120,30);
		jf.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(250, 160, 140, 30);
		jf.add(jtf2);
		
		jb1 = new JButton("Apply ");
		jb1.setBounds(250, 270, 140, 30);
		jf.add(jb1);
		jb1.addActionListener(new AL());
		
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
	
	class AL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String amount = jtf1.getText();
			String duration = jtf2.getText();
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String rr = "insert into loanrequest (accountno,amount,duration,status) values('"+accountno+"','"+amount+"','"+duration+"','pending')";
				
				int i = stt.executeUpdate(rr);
				if(i==1){
					JOptionPane.showMessageDialog(null, "Successfully Applied for Loan");
					jf.dispose();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}