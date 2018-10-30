package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bank.AdminWelcome.abc;
import bank.AdminWelcome.al;
import bank.userWelcome.cp;
import bank.userWelcome.depo;
import bank.userWelcome.sl;
import bank.userWelcome.trans;
import bank.userWelcome.withdraw;

class AdminWelcome{
	JFrame jf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11;
	AdminWelcome(){
		
		jf = new JFrame("Admin Welcome");
		jf.setLayout(null);
		
		jb1 = new JButton("Open New Account");
		jb1.setBounds(50, 50, 150, 30);
		jf.add(jb1);
		jb1.addActionListener(new abc());
		
		jb2 = new JButton("Account Request");
		jb2.setBounds(50, 110, 150, 30);
		jf.add(jb2);
		jb2.addActionListener(new Acc_Req());
		
		jb3 = new JButton("Loan Request ");
		jb3.setBounds(50, 170, 150, 30);
		jf.add(jb3);
		jb3.addActionListener(new al());

		
		jb4 = new JButton("Loan Deposit");
		jb4.setBounds(50, 230, 150, 30);
		jf.add(jb4);
		jb4.addActionListener(new sl());
		
		jb5 = new JButton("Edit Account");
		jb5.setBounds(50, 290, 150, 30);
		jf.add(jb5);
		//jb5.addActionListener(new cp());
		
		jb6 = new JButton("Balance Enquiry");
		jb6.setBounds(400, 50, 150, 30);
		jf.add(jb6);
		jb6.addActionListener(new bal_enq());
		
		jb7 = new JButton("Deposit");
		jb7.setBounds(400, 110, 150, 30);
		jf.add(jb7);
		jb7.addActionListener(new depo());
		
		jb8 = new JButton("Withdrawl");
		jb8.setBounds(400, 170, 150, 30);
		jf.add(jb8);
		jb8.addActionListener(new withdraw());
		
		jb9 = new JButton("Transfer");
		jb9.setBounds(400, 230, 150, 30);
		jf.add(jb9);
		jb9.addActionListener(new trans());
		
		jb10 = new JButton("Close Account");
		jb10.setBounds(400, 290, 150, 30);
		jf.add(jb10);
		jb10.addActionListener(new closeAccount());
		
		jb11 = new JButton("Logout");
		jb11.setBounds(230, 370, 150, 30);
		jf.add(jb11);
		jb11.addActionListener(new logout());
		
		jf.setSize(600, 500);
		jf.setVisible(true);
	}
	
	class abc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new AdminUserRegister();
		}
	}
	class Acc_Req implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new AccountRequest();
		}
	}
	class al implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection cnt = DataBaseConnection.javaConnection();
			  try {
				Statement stt= cnt.createStatement();
				String qq="select * from loanrequest where status = 'pending'";
				ResultSet rr= stt.executeQuery(qq);
				ArrayList<LoanRequestList> tlist= new ArrayList<>();
				while(rr.next())
				{
					LoanRequestList ss= new LoanRequestList();
					 ss.setAccountno(rr.getString("accountno"));
					 ss.setAmount(rr.getString("amount"));
					 ss.setDuration(rr.getString("duration"));
					 
					 tlist.add(ss);
					 
				}
				System.out.println(tlist.size());
				new ShowLoanRequestList(tlist);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		}
	}
	class sl implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new submitLoan();
		}
	}
	class trans implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new TransferAdmin();
		}
	}
	class withdraw implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new withdrawl();
			
		}
	}
	class depo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			 new deposit();
		}
	}
	
	class bal_enq implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String accountno = JOptionPane.showInputDialog("Enter Accountno to check balance : ");
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
	class closeAccount implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String accountno = JOptionPane.showInputDialog("Enter Accounr Number");
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq = "Delete from logindetails where accountno = '"+accountno+"'";
				int i = stt.executeUpdate(qq);
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null, "Account Deleted successfully");
					 //jf.dispose();
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "Some error Occurs");
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	class logout implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int res = JOptionPane.showConfirmDialog(null,"Do you really want to logout ?");
			if(res==JOptionPane.YES_OPTION){
			jf.dispose();
			new adminLogin();}
		}
	}
}