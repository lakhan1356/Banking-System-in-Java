package bank;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShowTransactionList {
	
	JFrame jf;
	JPanel jp;
	JLabel date,t_type,amount,sno,snof[];
	JTextField datef[],t_typef[],amountf[];
	ArrayList<TransactionList> tlist;
	public ShowTransactionList(ArrayList<TransactionList> tlist) {
		
		this.tlist=tlist;
		jf= new JFrame("Mini Statement");
		jp= new JPanel();
		jp.setLayout(null);
		
		datef= new JTextField[tlist.size()];
		t_typef= new JTextField[tlist.size()];
		amountf= new JTextField[tlist.size()];
		snof = new JLabel[tlist.size()];
		
		sno= new JLabel("S.No.");
		sno.setBounds(30, 50, 100, 30);
		jp.add(sno);
		
		
		date= new JLabel("Date");
		date.setBounds(150, 50, 100, 30);
		jp.add(date);
		
		t_type= new JLabel("Transaction Type");
		t_type.setBounds(340,50, 200, 30);
		jp.add(t_type);
		
		amount= new JLabel("Amount");
		amount.setBounds(550, 50, 100, 30);
		jp.add(amount);
		
		
		int i=0,y=85,j=1;
		for(TransactionList ss:tlist)
		{
			snof[i] = new JLabel(""+j);
			snof[i].setBounds(50, y, 100, 30);
			jp.add(snof[i]);
			//snof[i].setEditable(false);
			
			datef[i]= new JTextField(ss.getdate());
			datef[i].setBounds(120,y, 200, 30);
			datef[i].setEditable(false);
			jp.add(datef[i]);
			 
			t_typef[i]= new JTextField(ss.getttype());
			t_typef[i].setBounds(330,y, 200, 30);
			jp.add(t_typef[i]);
			t_typef[i].setEditable(false);

			
			amountf[i]= new JTextField(ss.getamount());
			amountf[i].setBounds(550,y, 100, 30);
			jp.add(amountf[i]);
			amountf[i].setEditable(false);

			
			
			i++;
			y=y+35;
			j++;
		}
		
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(jf.getToolkit().getScreenSize());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}










