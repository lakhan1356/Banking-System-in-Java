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

class changePassword{
	JLabel jl1,jl2,jl3;
	JPasswordField jtf1,jtf2,jtf3;
	JButton jb1;
	JFrame jf;
	int accountno;
	changePassword(int accountno){
		this.accountno = accountno;
		
		jf = new JFrame("Change Password");
		jf.setLayout(null);
		
		jl1 = new JLabel("Old Password : ");
		jl1.setBounds(100,100,100,30);
		jf.add(jl1);
		
		jtf1 = new JPasswordField();
		jtf1.setBounds(250, 100, 140, 30);
		jf.add(jtf1);
		jtf1.addKeyListener(new confirm());

		jl2 = new JLabel("New Password : ");
		jl2.setBounds(100,160,120,30);
		jf.add(jl2);
		
		jtf2 = new JPasswordField();
		jtf2.setBounds(250, 160, 140, 30);
		jf.add(jtf2);
		jtf2.addKeyListener(new confirm());

		jl3 = new JLabel("Confirm Password : ");
		jl3.setBounds(100,210,120,30);
		jf.add(jl3);
		
		jtf3 = new JPasswordField();
		jtf3.setBounds(250, 210, 140, 30);
		jf.add(jtf3);
		jtf3.addKeyListener(new confirm());

		jb1 = new JButton("Change ");
		jb1.setBounds(250, 270, 140, 30);
		jf.add(jb1);	
		jb1.addActionListener(new confirm());
		jb1.addKeyListener(new confirm());
		
		
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
	class confirm implements ActionListener, KeyListener{
		public void actionPerformed(ActionEvent e){
			String npass = jtf2.getText();
			String cpass = jtf3.getText();
			String opass = jtf1.getText();
			Connection cnt = DataBaseConnection.javaConnection();
			try {
				Statement stt = cnt.createStatement();
				String ww = "Select pass from logindetails where accountno = '"+accountno+"'";
				ResultSet rs = stt.executeQuery(ww);
				if(rs.next()){
					String j = rs.getString("pass");
					if(j.equals(opass)){
						if(npass.equals(cpass)){
							String qq = "Update logindetails set pass = '"+npass+"' where accountno = '"+accountno+"'";
							int i = stt.executeUpdate(qq);
							if(i>0){
								JOptionPane.showMessageDialog(null, "Password Changed Successfully");
								jf.dispose();
							}
						}
						else
							JOptionPane.showMessageDialog(null, "New and Confirm Password did not match");
					}
					else
						JOptionPane.showMessageDialog(null, "Password did not match");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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
}

