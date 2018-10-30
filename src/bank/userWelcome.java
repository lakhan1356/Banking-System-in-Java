package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.GatheringByteChannel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Generated;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.fabric.xmlrpc.base.Data;

import bank.userWelcome.bal_enq;
import bank.userWelcome.appLoan;
import bank.userWelcome.cp;
import bank.userWelcome.depo;
import bank.userWelcome.sl;
import bank.userWelcome.trans;
import bank.userWelcome.withdraw;

class userWelcome{
	JFrame jf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11;
	Integer accountno;

	userWelcome(int accountno){
		this.accountno=accountno;
		
		jf = new JFrame("User Welcome");
		jf.setLayout(null);
		
		jb1 = new JButton("Balance Enquiry");
		jb1.setBounds(50, 50, 150, 30);
		jf.add(jb1);
		jb1.addActionListener(new bal_enq());
		
		jb2 = new JButton("Withdrawl");
		jb2.setBounds(50, 110, 150, 30);
		jf.add(jb2);
		jb2.addActionListener(new withdraw());
		
		jb3 = new JButton("Deposit");
		jb3.setBounds(50, 170, 150, 30);
		jf.add(jb3);
		jb3.addActionListener(new depo());

		
		jb4 = new JButton("Transfer");
		jb4.setBounds(50, 230, 150, 30);
		jf.add(jb4);
		jb4.addActionListener(new trans());
		
		jb5 = new JButton("Change Password");
		jb5.setBounds(50, 290, 150, 30);
		jf.add(jb5);
		jb5.addActionListener(new cp());
		
		jb6 = new JButton("Mini Statement");
		jb6.setBounds(400, 50, 150, 30);
		jf.add(jb6);
		jb6.addActionListener(new minist());
		
		jb7 = new JButton("My Profile");
		jb7.setBounds(400, 110, 150, 30);
		jf.add(jb7);
		
		jb8 = new JButton("Apply Loan");
		jb8.setBounds(400, 170, 150, 30);
		jf.add(jb8);
		jb8.addActionListener(new appLoan());
		
		jb9 = new JButton("Check Loan Status");
		jb9.setBounds(400, 230, 150, 30);
		jf.add(jb9);
		
		jb10 = new JButton("Submit Loan");
		jb10.setBounds(400, 290, 150, 30);
		jf.add(jb10);
		jb10.addActionListener(new sl());
		
		jb11 = new JButton("Logout");
		jb11.setBounds(230, 370, 150, 30);
		jf.add(jb11);
		jb11.addActionListener(new logout());
		
		jf.setSize(600, 500);
		jf.setVisible(true);
	}
	
	class bal_enq implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq= "Select ini_balance from logindetails where accountno='"+accountno+"'";
				ResultSet rr= stt.executeQuery(qq);
				if(rr.next())
				{
					JOptionPane.showMessageDialog(null, "your account balance is " + rr.getString("ini_balance"));
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
	class cp implements ActionListener{
		public void actionPerformed(ActionEvent e){
			changePassword cpa = new changePassword(accountno);
		}
	}
	class appLoan implements ActionListener{
		public void actionPerformed(ActionEvent e){
			applyLoan cpa = new applyLoan(accountno);
		}
	}
	class sl implements ActionListener{
		public void actionPerformed(ActionEvent e){
			submitLoan cpa = new submitLoan();
		}
	}
	class trans implements ActionListener{
		public void actionPerformed(ActionEvent e){
			transfer cpa = new transfer(accountno);
		}
	}
	class withdraw implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String amnt= JOptionPane.showInputDialog("pls enter the amount you want to withdraw");
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt= cnt.createStatement();
				String qq= "select ini_balance from logindetails where accountno='"+accountno+"'";
				ResultSet rr= stt.executeQuery(qq);
				if(rr.next())
				{
					int camnt= Integer.parseInt(rr.getString("ini_balance"));
					int wamnt= Integer.parseInt(amnt);
					 if(wamnt>camnt)
					 {
						 JOptionPane.showMessageDialog(null, "pls enter lesser amount");
					 }
					 else{
						 int namnt= camnt-wamnt;
						 String up= "update logindetails set ini_balance='"+namnt+"' where accountno='"+accountno+"'";
						 int i= stt.executeUpdate(up);
						 if(i==1)
						 {
							 JOptionPane.showMessageDialog(null, "amount withdraw successfully");
							 String inq="insert into transaction (amount, t_type, date,accountno) values ('"+wamnt+"','Debited','"+new Date()+"','"+accountno+"')";
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
			}		}
	}
	class depo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String amnt= JOptionPane.showInputDialog("pls enter the amount you want to deposit");
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq= "select ini_balance from logindetails where accountno='"+accountno+"'";
				ResultSet rr= stt.executeQuery(qq);
				if(rr.next()){
				int camnt= Integer.parseInt(rr.getString("ini_balance"));
				int wamnt= Integer.parseInt(amnt);
				 int namnt= camnt+wamnt;
				 String up= "update logindetails set ini_balance='"+namnt+"' where accountno='"+accountno+"'";
				 int i= stt.executeUpdate(up);
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null, "amount deposited successfully");
					 String inq="insert into transaction (amount, t_type, date,accountno) values ('"+wamnt+"','Credited','"+new Date()+"','"+accountno+"')";
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
	
	class minist implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new MiniStatement(accountno);
		}
	}
	
	class logout implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int res = JOptionPane.showConfirmDialog(null,"Do you really want to logout ?");
			if(res==JOptionPane.YES_OPTION){
			jf.dispose();
			new userLogin();}
		}
	}
}