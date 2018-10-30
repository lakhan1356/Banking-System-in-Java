package bank;

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

public class ShowAccountList {
	
	JFrame jf;
	JPanel jp;
	JLabel userid,accountno,mobile,sno,snof[],select;
	JTextField useridf[],accountnof[],mobilef[];
	JCheckBox jcb[];
	JButton jb;
	ArrayList<AccountRequestList> tlist;
	public ShowAccountList(ArrayList<AccountRequestList> tlist) {
		
		this.tlist=tlist;
		jf= new JFrame("Account Request");
		jp= new JPanel();
		jp.setLayout(null);
		
		useridf= new JTextField[tlist.size()];
		accountnof= new JTextField[tlist.size()];
		mobilef= new JTextField[tlist.size()];
		snof = new JLabel[tlist.size()];
		jcb = new JCheckBox[tlist.size()];
		
		sno= new JLabel("S.No.");
		sno.setBounds(30, 50, 100, 30);
		jp.add(sno);
		
		
		userid= new JLabel("User ID");
		userid.setBounds(150, 50, 100, 30);
		jp.add(userid);
		
		accountno= new JLabel("Account No.");
		accountno.setBounds(340,50, 200, 30);
		jp.add(accountno);
		
		mobile= new JLabel("Mobile");
		mobile.setBounds(560, 50, 100, 30);
		jp.add(mobile);
		
		select= new JLabel("Select");
		select.setBounds(670, 50, 100, 30);
		jp.add(select);
		
		jb = new JButton("Approve");
		jb.setBounds(280, 600, 100, 30);
		jp.add(jb);
		jb.addActionListener(new approve());
		
		int i=0,y=85,j=1;
		for(AccountRequestList ss:tlist)
		{
			snof[i] = new JLabel(""+j);
			snof[i].setBounds(50, y, 100, 30);
			jp.add(snof[i]);
			//snof[i].setEditable(false);
			
			jcb[i] = new JCheckBox();
			jcb[i].setBounds(670,y,100,30);
			jp.add(jcb[i]);
			
			
			useridf[i]= new JTextField(ss.getUserid());
			useridf[i].setBounds(120,y, 200, 30);
			useridf[i].setEditable(false);
			jp.add(useridf[i]);
			 
			accountnof[i]= new JTextField(ss.getAccountno());
			accountnof[i].setBounds(330,y, 200, 30);
			jp.add(accountnof[i]);
			accountnof[i].setEditable(false);

			
			mobilef[i]= new JTextField(ss.getMobile());
			mobilef[i].setBounds(550,y, 100, 30);
			jp.add(mobilef[i]);
			mobilef[i].setEditable(false);

			
			
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
						String rr = "Update logindetails set status='approved' where accountno='"+account+"'";
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