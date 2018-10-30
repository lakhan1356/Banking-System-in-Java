package bank;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class MiniStatement {
	int accountno;
	MiniStatement(int accountno){
	this.accountno= accountno;
	  Connection cnt = DataBaseConnection.javaConnection();
	  try {
		Statement stt= cnt.createStatement();
		String qq="select * from transaction where accountno = '"+accountno+"'";
		ResultSet rr= stt.executeQuery(qq);
		ArrayList<TransactionList> tlist= new ArrayList<>();
		while(rr.next())
		{
			 TransactionList ss= new TransactionList();
			 ss.setdate(rr.getString("date"));
			 ss.setttype(rr.getString("t_type"));
			 ss.setamount(rr.getString("amount"));
			 
			 tlist.add(ss);
			 
		}
		System.out.println(tlist.size());
		new ShowTransactionList(tlist);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  

	}

}



