package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class userRegister{
	JFrame jf;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPasswordField jpf,jpf1;
	JRadioButton jrb1,jrb2,jrb3,jrb4;
	ButtonGroup bb,bb1;
	JComboBox jcb,jcb1,jcb2,jcb3;
	JCheckBox jc1,jc2,jc3,jc4;
	JTextArea jta;
	JButton jb;


	
	userRegister(){
		jf  = new JFrame("New Registration");
		jf.setLayout(null);
		
		jl10 = new JLabel("Registration Form");
		jl10.setBounds(250, 10, 250, 30);
		jf.add(jl10);
		
		jl1 = new JLabel("First Name : ");
		jl1.setBounds(50,50,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(180, 50, 100, 30);
		jf.add(jtf1);
		
		jl2 = new JLabel("Father's Name : ");
		jl2.setBounds(300,50,100,30);
		jf.add(jl2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(400, 50, 100, 30);
		jf.add(jtf2);
		
		jl3 = new JLabel("Password : ");
		jl3.setBounds(50,90,100,30);
		jf.add(jl3);
		
		jpf = new JPasswordField();
		jpf.setBounds(180, 90, 100, 30);
		jf.add(jpf);
		
		jl4 = new JLabel("Confirm Password : ");
		jl4.setBounds(50,130,120,30);
		jf.add(jl4);
		
		jpf1 = new JPasswordField();
		jpf1.setBounds(180, 130, 100, 30);
		jf.add(jpf1);
		
		jl5 = new JLabel("Gender : ");
		jl5.setBounds(50,170,100,30);
		jf.add(jl5);
		
		bb = new ButtonGroup(); 
		
		jrb1 = new JRadioButton("Male");
		jrb1.setBounds(180, 170,100,30);
		jf.add(jrb1);
		bb.add(jrb1);
		jrb1.setSelected(true);
		
		jrb2 = new JRadioButton("Female");
		jrb2.setBounds(290, 170,100,30);
		jf.add(jrb2);
		bb.add(jrb2);
		
		jl6 = new JLabel("Mobile : ");
		jl6.setBounds(50,210,100,30);
		jf.add(jl6);
		
		jtf3 = new JTextField();
		jtf3.setBounds(180, 210, 100, 30);
		jf.add(jtf3);
		
		jl7 = new JLabel("E-Mail ID : ");
		jl7.setBounds(50,250,100,30);
		jf.add(jl7);
		
		jtf4 = new JTextField();
		jtf4.setBounds(180, 250, 100, 30);
		jf.add(jtf4);
		
		jl6 = new JLabel("Account type : ");
		jl6.setBounds(50,300,120,30);
		jf.add(jl6);
		
		bb1 = new ButtonGroup(); 
		
		jrb3 = new JRadioButton("Savings");
		jrb3.setBounds(180, 300,100,30);
		jf.add(jrb3);
		bb1.add(jrb3);
		jrb3.setSelected(true);
		
		jrb4 = new JRadioButton("Current");
		jrb4.setBounds(280, 300,100,30);
		jf.add(jrb4);
		bb1.add(jrb4);
		
		jl8 = new JLabel("Security Question : ");
		jl8.setBounds(50,350,200,30);
		jf.add(jl8);
		
		jcb = new JComboBox<>();
		jcb.setBounds(180,350, 400,30);
		jcb.addItem("Select Question");
		jcb.addItem("What was the name of your elementary / primary school?");
		jcb.addItem("What time of the day were you born? (hh:mm)");
		jcb.addItem("In what city or town does your nearest sibling live?");
		jcb.addItem("What is last name of teacher who gave you your first failing grade?");
		jf.add(jcb);
		jcb.addItemListener(new register());
		
		jl9 = new JLabel("Security Answer : ");
		jl9.setBounds(50,400,120,30);
		jf.add(jl9);
		
		jtf6 = new JTextField();
		jtf6.setBounds(180, 400, 100, 30);
		jf.add(jtf6);
		
		jl10 = new JLabel("Initial Balance : ");
		jl10.setBounds(50,450,100,30);
		jf.add(jl10);
		
		jtf5 = new JTextField();
		jtf5.setBounds(180, 450, 100, 30);
		jf.add(jtf5);
		
		jl10 = new JLabel("DOB: ");
		jl10.setBounds(50,500,100,30);
		jf.add(jl10);
		
		jcb1 = new JComboBox();
		jcb1.setBounds(130, 500, 70, 30);
		for(int i=1;i<=31;i++)
		jcb1.addItem(i);
		jf.add(jcb1);
		
		jcb2 = new JComboBox();
		jcb2.setBounds(220, 500, 70, 30);
		for(int j=1;j<=12;j++){
		jcb2.addItem(j);}
		jf.add(jcb2);
		
		jcb3 = new JComboBox();
		jcb3.setBounds(310, 500, 70, 30);
		for(int i=1990;i<=2050;i++){
		jcb3.addItem(i);}
		jf.add(jcb3);
		
		jl11 = new JLabel("Address: ");
		jl11.setBounds(50,550,100,30);
		jf.add(jl11);
		
		jta = new JTextArea();
		jta.setBounds(180, 550, 200, 80);
		jf.add(jta);
		
		jb = new JButton("Apply");
		jb.setBounds(260, 670, 100, 30);
		jf.add(jb);
		jb.addActionListener(new register());
		
		jf.setVisible(true);
		jf.setSize(700, 750);
	}
	class register implements ActionListener, ItemListener{
		public void actionPerformed(ActionEvent e){
			String username = jtf1.getText();
			String pass = jpf.getText();
			String conf_pass  = jpf1.getText();
			String mobile = jtf3.getText();
			String emailid = jtf4.getText();
			String acc_type = "";
			String ini_balance = jtf5.getText();
			String gender = "";
			String question = (String)jcb.getSelectedItem();
			String answer = jtf6.getText();
			
			if(jrb1.isSelected()){
				gender= "Male";
			}
			else if(jrb2.isSelected()){
				gender = "Female";
			}
			if(jrb3.isSelected()){
				acc_type= "Savings";
			}
			else if(jrb4.isSelected()){
				acc_type = "Current";
			}
				
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String qq = "insert into logindetails(userid,pass,mobile,emailid,ini_balance,gender,acc_type,question,answer,Status) values('"+username+"','"+pass+"','"+mobile+"','"+emailid+"','"+ini_balance+"','"+gender+"','"+acc_type+"','"+question+"','"+answer+"','Pending')";
				int rr = stt.executeUpdate(qq);
				if(rr >0){
					JOptionPane.showMessageDialog(null, "Successfully Registeresd");
					jf.dispose();
					new userLogin();
				}
				else{
					JOptionPane.showMessageDialog(null, "Not registered Successfully");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getStateChange()==1){
				String aa = (String)(jcb.getSelectedItem());
				if(aa.contains("school")){
					jtf6.setText("nvs");
				}
			}
			
		}
	}
}
