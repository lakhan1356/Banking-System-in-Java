package bank;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class AccountRequest {
	int accountno;
	AccountRequest(){
	  Connection cnt = DataBaseConnection.javaConnection();
	  try {
		Statement stt= cnt.createStatement();
		String qq="select * from logindetails where status = 'Pending'";
		ResultSet rr= stt.executeQuery(qq);
		ArrayList<AccountRequestList> tlist= new ArrayList<>();
		while(rr.next())
		{
			AccountRequestList ss= new AccountRequestList();
			 ss.setUserid(rr.getString("userid"));
			 ss.setAccountno(rr.getString("accountno"));
			 ss. setMobile(rr.getString("mobile"));
			 
			 tlist.add(ss);
			 
		}
		System.out.println(tlist.size());
		new ShowAccountList(tlist);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  

	}

}



