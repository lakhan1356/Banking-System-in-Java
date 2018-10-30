package bank;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShowLoanRequestList {
	
	JFrame jf;
	JPanel jp;
	JLabel accountno,amount,duration,sno,snof[],select;
	JTextField amountf[],accountnof[],durationf[];
	JCheckBox jcb[];
	JButton jb;
	ArrayList<LoanRequestList> tlist;
	public ShowLoanRequestList(ArrayList<LoanRequestList> tlist) {
		
		this.tlist=tlist;
		jf= new JFrame("Loan Request");
		jp= new JPanel();
		jp.setLayout(null);
		
		amountf= new JTextField[tlist.size()];
		accountnof= new JTextField[tlist.size()];
		durationf= new JTextField[tlist.size()];
		snof = new JLabel[tlist.size()];
		jcb = new JCheckBox[tlist.size()];
		
		sno= new JLabel("S.No.");
		sno.setBounds(30, 50, 100, 30);
		jp.add(sno);
		
		
		amount= new JLabel("Amount");
		amount.setBounds(340, 50, 200, 30);
		jp.add(amount);
		
		accountno= new JLabel("Account No.");
		accountno.setBounds(150,50, 100, 30);
		jp.add(accountno);
		
		duration= new JLabel("Duration");
		duration.setBounds(560, 50, 100, 30);
		jp.add(duration);
		
		select= new JLabel("Select");
		select.setBounds(670, 50, 100, 30);
		jp.add(select);
		
		jb = new JButton("Approve");
		jb.setBounds(280, 600, 100, 30);
		jp.add(jb);
		jb.addActionListener(new approve());
		
		
		int i=0,y=85,j=1;
		for(LoanRequestList ss:tlist)
		{
			snof[i] = new JLabel(""+j);
			snof[i].setBounds(50, y, 100, 30);
			jp.add(snof[i]);
			//snof[i].setEditable(false);
			
			jcb[i] = new JCheckBox();
			jcb[i].setBounds(670,y,100,30);
			jp.add(jcb[i]);
			
			amountf[i]= new JTextField(ss.getAmount());
			amountf[i].setBounds(330,y, 200, 30);
			amountf[i].setEditable(false);
			jp.add(amountf[i]);
			 
			accountnof[i]= new JTextField(ss.getAccountno());
			accountnof[i].setBounds(120,y, 200, 30);
			jp.add(accountnof[i]);
			accountnof[i].setEditable(false);

			
			durationf[i]= new JTextField(ss.getDuration());
			durationf[i].setBounds(550,y, 100, 30);
			jp.add(durationf[i]);
			durationf[i].setEditable(false);

			i++;
			y=y+35;
			j++;
		}
		
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(jf.getToolkit().getScreenSize());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class approve implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				for(int i=0;i<tlist.size();i++){
					if(jcb[i].isSelected()){
						//System.out.println("hello");
						String account = accountnof[i].getText();
						String rr = "Update loanrequest set status='approved' where accountno='"+account+"'";
						stt.executeUpdate(rr);
					}
					 
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}