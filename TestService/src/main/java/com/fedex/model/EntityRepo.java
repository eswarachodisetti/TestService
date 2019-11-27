package com.fedex.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;


import com.fedex.constants.AccountDao;
import com.fedex.utility.JDBCUtility;

public class EntityRepo {

	public List<AccountDao> getAllDetails() {

		return null;
	}

	Connection con = null;
	Properties prop = new Properties();

	public void addAccount(AccountDao account) {

		try {
//			 Class.forName("com.mysql.jdbc.Driver");
//			 Connection con = DriverManager
//			 .getConnection("jdbc:mysql://c0018679.test.cloud.fedex.com/PSK?user=cvmdb&password=Kubectl1!");

			// the mysql insert statement

			
//			// Context envContext = (Context)
//			// initContext.lookup("jdbc/DB");
		/*	Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("jdbc/DB");
			con = ds.getConnection();*/
			
			con=JDBCUtility.getConnection();
			String query = "INSERT INTO ACCOUNT_NUMBER (EFF_TMSTP, EXTERNAL_ID_NBR, TYPE_CD, EXPR_TMSTP, OBJ_ID) VALUES(?,?,?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, account.getEFF_TMSTP());
			preparedStmt.setString(2, account.getEXTERNAL_ID_NBR());
			preparedStmt.setString(3, account.getTYPE_CD());
			preparedStmt.setString(4, account.getEXPR_TMSTP());
			preparedStmt.setInt(5, account.getOBJ_ID());
			preparedStmt.execute();

			System.out.println("Account_Number Inserted successfully");

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}

	public void addAddress(AccountDao account) {
		try {

	/*		Context initContext = new InitialContext();

			DataSource ds = (DataSource) initContext.lookup("jdbc/DB");
			con = ds.getConnection();*/

			// the mysql insert statement
			con=JDBCUtility.getConnection();
			
			
			String sql = "INSERT INTO ADDRESS (EFF_TMSTP,OBJ_ID,CUST_VIEW_CD,CUST_MODEL_CD, TYPE_CD,ADDR_LINE_1_DESC,ADDR_LINE_2_DESC,ADDR_LINE_3_DESC,"
					+ "CITY_NM,STATE_PROVINCE_NM,PSTL_CD,CNTRY_CD,EXPR_TMSTP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, account.getEFF_TMSTP());
			preparedStmt.setInt(2, account.getOBJ_ID());
			preparedStmt.setString(3, account.getCUST_VIEW_CD());
			preparedStmt.setString(4, account.getCUST_MODEL_CD());
			preparedStmt.setString(5, account.getADD_TYPE_CD());
			;
			preparedStmt.setString(6, account.getADDR_LINE_1_DESC());
			preparedStmt.setString(7, account.getADDR_LINE_2_DESC());
			preparedStmt.setString(8, account.getADDR_LINE_3_DESC());
			preparedStmt.setString(9, account.getCITY_NM());
			preparedStmt.setString(10, account.getSTATE_PROVINCE_NM());
			preparedStmt.setString(11, account.getPSTL_CD());
			preparedStmt.setString(12, account.getCNTRY_CD());
			preparedStmt.setString(13, account.getEXPR_TMSTP());
			preparedStmt.execute();
			System.out.println("Address Inserted successfully");

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	public void addCompany(AccountDao account) {
		try {
		//	Context initContext = new InitialContext();

//			DataSource ds = (DataSource) initContext.lookup(prop
//					.getProperty("spring.datasource.jndi-name"));
			/*DataSource ds = (DataSource) initContext.lookup("jdbc/DB");
			con = ds.getConnection();*/

			con=JDBCUtility.getConnection();
			// the mysql insert statement
			String sql = "INSERT INTO COMPANY_NAME (EFF_TMSTP,OBJ_ID,CUST_VIEW_CD,CUST_MODEL_CD, TYPE_CD,EXPR_TMSTP,NAME_DESC) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, account.getEFF_TMSTP());
			preparedStmt.setInt(2, account.getOBJ_ID());
			preparedStmt.setString(3, account.getCUST_VIEW_CD());
			preparedStmt.setString(4, account.getCUST_MODEL_CD());
			preparedStmt.setString(5, account.getCMP_TYPE_CD());
			preparedStmt.setString(6, account.getEXPR_TMSTP());
			preparedStmt.setString(7, account.getNAME_DESC());
			preparedStmt.execute();
			System.out.println("CompanyName Inserted successfully");

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	public void addPhone(AccountDao account) {
		try {
/*			Context initContext = new InitialContext();

			DataSource ds = (DataSource) initContext.lookup("jdbc/DB");
			con = ds.getConnection();*/

			con=JDBCUtility.getConnection();
			String sql = "INSERT INTO PHONE (EFF_TMSTP,OBJ_ID,CUST_VIEW_CD,CUST_MODEL_CD, TYPE_CD,TEL_INTL_CD,TEL_AREA_CD,TEL_NBR,TEL_EXT_NBR,EXPR_TMSTP) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setString(1, account.getEFF_TMSTP());
			preparedStmt.setInt(2, account.getOBJ_ID());
			preparedStmt.setString(3, account.getCUST_VIEW_CD());
			preparedStmt.setString(4, account.getCUST_MODEL_CD());
			preparedStmt.setString(5, account.getPH_TYPE_CD());
			preparedStmt.setString(6, account.getTEL_INTL_CD());
			preparedStmt.setString(7, account.getTEL_AREA_CD());
			preparedStmt.setString(8, account.getTEL_NBR());
			preparedStmt.setString(9, account.getTEL_EXT_NBR());
			preparedStmt.setString(10, account.getEXPR_TMSTP());

			preparedStmt.execute();

			System.out.println("Phone Inserted successfully");

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	public boolean accountExists(int OBJ_ID) {

		try {
			System.out.println("==============================Datasource========================");
			/*Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("jdbc/DB");
			con = ds.getConnection();*/
			System.out.println("==============================Datasource connected========================");
			
			con=JDBCUtility.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select count(*) from ACCOUNT_NUMBER where OBJ_ID = "
							+ OBJ_ID);
			while (rs.next()) {
				System.out.println("count" + rs.getInt("count(*)"));
				int count = rs.getInt("count(*)");

				System.out.println(count);
				if (count == 0) {
					return false;
				}
			}
			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}
		return true;

	}

}
