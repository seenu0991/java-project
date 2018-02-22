package test;



import java.sql.Connection;


import services.Dbconnection;




public class TestDbConnectivity {

	public static void main(String[] args) {

		Connection con = null;
		con = Dbconnection.getconnection();
		if (con != null) {
			System.out.println("Connection success");
	
}
}
}
