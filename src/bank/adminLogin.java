package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class adminLogin{
	JLabel jl1,jl2;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jb1,jb2;
	JFrame jf;
	adminLogin(){
		jf = new JFrame("Admin Login");
		jf.setLayout(null);
		
		jl1 = new JLabel("Admin ID : ");
		jl1.setBounds(100,100,100,30);
		jf.add(jl1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		jtf1.addKeyListener(new AW());

		
		jl2 = new JLabel("Password : ");
		jl2.setBounds(100,160,120,30);
		jf.add(jl2);
		
		jpf = new JPasswordField();
		jpf.setBounds(250, 160, 140, 30);
		jf.add(jpf);
		jpf.addKeyListener(new AW());

		
		jb1 = new JButton("Login ");
		jb1.setBounds(100, 250, 140, 30);
		jf.add(jb1);	
		jb1.addActionListener(new AW());
		jb1.addKeyListener(new AW());
		
		jb2 = new JButton("Clear ");
		jb2.setBounds(260, 250, 140, 30);
		jf.add(jb2);
		jb2.addActionListener(new clear());
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
	class AW implements ActionListener, KeyListener{
		public void actionPerformed(ActionEvent e){
			String uid = jtf1.getText();
			String pwd = jpf.getText();
			Connection cnt = DataBaseConnection.javaConnection();
			try{
				Statement stt = cnt.createStatement();
				String qq= "Select * from adminlogin where adminid='"+uid+"' and pass='"+pwd+"'";
				ResultSet rr = stt.executeQuery(qq);
				if(rr.next()){
					JOptionPane.showMessageDialog(null,"Welcome");
					jf.dispose();
					new AdminWelcome();
				}
				else{
					jtf1.setText(null);
					jpf	.setText(null);
					JOptionPane.showMessageDialog(null, "Invalid Credentials");
					//JOptionPane.showMessageDialog(null, "Enter Valid Details");
					//JOptionPane.showMessageDialog(null,"Enter valid Details You Culprit");
				}
				
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int key = arg0.getKeyCode();
			if(key==arg0.VK_ENTER){
				actionPerformed(null);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	class clear implements ActionListener{
		public void actionPerformed(ActionEvent e){
			jtf1.setText(null);
			jpf.setText(null);
		}
	}
}