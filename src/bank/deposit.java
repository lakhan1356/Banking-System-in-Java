package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bank.deposit.abc;

class deposit{
	JFrame jf;
	JLabel jl,jl1;
	JTextField jtf,jtf1;
	JButton jb;
	deposit(){
		jf = new JFrame("Deposit");
		jf.setLayout(null);
		
		jl1 = new JLabel("Account no.");
		jl1.setBounds(50,50,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(150,50,100,30);
		jf.add(jtf1);
		
		jl = new JLabel("Amount");
		jl.setBounds(50,100,100,30);
		jf.add(jl);
		
		jtf = new JTextField();
		jtf.setBounds(150,100,100,30);
		jf.add(jtf);
		
		jb = new JButton("Deposit");
		jb.setBounds(100, 150, 100, 30);
		jf.add(jb);
		jb.addActionListener(new abc());
		
		jf.setSize(300, 300);
		jf.setVisible(true);
	}
	class abc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String accountno = jtf1.getText();
			String amount = jtf.getText();
			int amnt = Integer.parseInt(amount);
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq= "select ini_balance from logindetails where accountno='"+accountno+"'";
				ResultSet rr= stt.executeQuery(qq);
				if(rr.next()){
				int camnt= Integer.parseInt(rr.getString("ini_balance"));
				 int namnt= camnt+amnt;
				 String up= "update logindetails set ini_balance='"+namnt+"' where accountno='"+accountno+"'";
				 int i= stt.executeUpdate(up);
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null, "amount deposited successfully");
					 jf.dispose();
					 String inq="insert into transaction (amount, t_type, date,accountno) values ('"+amnt+"','deposit','"+new Date()+"','"+accountno+"')";
					 stt.executeUpdate(inq);
				 }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "some problem pls try again");
				}
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
