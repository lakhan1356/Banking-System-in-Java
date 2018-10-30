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

import bank.transfer.transf;

class TransferAdmin{
	JLabel jl1,jl2,jl3;
	JTextField jtf1,jtf2,jtf3;
	JButton jb1;
	JFrame jf;
	TransferAdmin(){
		
		jf = new JFrame("Transfer Money");
		jf.setLayout(null);
		
		jl1 = new JLabel("From Account No ");
		jl1.setBounds(100,100,120,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		
		jl3 = new JLabel("To Account no");
		jl3.setBounds(100,150,100,30);
		jf.add(jl3);
		
		jtf3 = new JTextField();
		jtf3.setBounds(250, 150, 140, 30);
		jf.add(jtf3);
		
		jl2 = new JLabel("Amount : ");
		jl2.setBounds(100,200,120,30);
		jf.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(250, 200, 140, 30);
		jf.add(jtf2);
		
		jb1 = new JButton("Transfer");
		jb1.setBounds(250, 270, 140, 30);
		jf.add(jb1);	
		jb1.addActionListener(new transf());
		
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
	class transf implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String faccno = jtf1.getText();
			String amount = jtf2.getText(); 
			String taccno = jtf3.getText();
			int amnt = Integer.parseInt(amount);
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq = "Select ini_balance from logindetails where accountno = '"+taccno+"'";
				ResultSet rr= stt.executeQuery(qq);
				if(rr.next()){
					int camnt= Integer.parseInt(rr.getString("ini_balance"));
					 int namnt= camnt+amnt;
					 String up= "update logindetails set ini_balance='"+namnt+"' where accountno = '"+taccno+"'";
					 int i= stt.executeUpdate(up);
					 if(i==1)
					 {
						 JOptionPane.showMessageDialog(null, "amount deposited successfully");
						 String inq="insert into transaction (amount, t_type, date,accountno) values ('"+amnt+"','transfer','"+new Date()+"','"+taccno+"')";
						 stt.executeUpdate(inq);
					 }
					}
				
				String qr= "select ini_balance from logindetails where accountno='"+faccno+"'";
				ResultSet rq= stt.executeQuery(qr);
				if(rq.next())
				{
					int camnt= Integer.parseInt(rq.getString("ini_balance"));
					 if(amnt>camnt)
					 {
						 JOptionPane.showMessageDialog(null, "pls enter lesser amount");
					 }
					 else{
						 int namnt= camnt-amnt;
						 String up= "update logindetails set ini_balance='"+namnt+"' where accountno='"+faccno+"'";
						 int i = stt.executeUpdate(up);
						 if(i==1)
						 {
							 //JOptionPane.showMessageDialog(null, "amount withdraw successfully");
							 String inq="insert into transaction (amount, t_type, date,accountno) values ('"+amnt+"','withdraw','"+new Date()+"','"+faccno+"')";
							 stt.executeUpdate(inq);
						 }
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
