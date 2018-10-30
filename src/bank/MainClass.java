package bank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FirstPage();
		Connection cnt = DataBaseConnection.javaConnection();
		try{
			Statement stt = cnt.createStatement();
			String qq = "Select * from employee";
			ResultSet rr = stt.executeQuery(qq);
			while(rr.next()){
				System.out.println(rr.getString("ename") +" "+rr.getString("esalary"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		/*String clientSentence = null;
	       String capitalizedSentence;
	       ServerSocket welcomeSocket = null;
		try {
			welcomeSocket = new ServerSocket(6687);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       while(true)
	       {
	           Socket connectionSocket = null;
			try {
				connectionSocket = welcomeSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	           BufferedReader inFromClient = null;
			try {
				inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	           DataOutputStream outToClient = null;
			try {
				outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	           try {
				clientSentence = inFromClient.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           System.out.println(clientSentence);
	           //capitalizedSentence = clientSentence.toUpperCase() + '\n';
	           try {
				outToClient.writeBytes("Hi");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	           try {
				connectionSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         //  welcomeSocket.close();*/

	}

}






