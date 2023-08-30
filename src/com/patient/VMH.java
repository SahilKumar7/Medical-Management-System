package com.patient;

import java.sql.*;
public class VMH {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// creating connection
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pass = "tiger";
			Connection con = DriverManager.getConnection(url,user,pass);
			if(con.isClosed()){
				System.out.println("Connection is closed");
			}
			else {
				PopulateTable pt = new PopulateTable(con);
				pt.createPatientTable();
				pt.createDoctorTable();
				pt.createAdminTable();
				pt.createSlotTable();
				pt.createappointmentTable();
				WelcomeMenu wm = new WelcomeMenu(con);
				wm.printMenu();
			}
		} catch(Exception e)
			{
				e.printStackTrace();
			}	
	}
}


