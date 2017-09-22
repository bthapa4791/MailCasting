/**
 * 
 */
package com.bimal.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bimal.dbquery.DBQuery;
import com.bimal.model.UserModel;
import com.bimal.utility.AppConstant;

/**
 * @author bimalthapa
 *
 */
public class LoginUser {

	private PreparedStatement preStatement;
    private Statement statement;
    private Connection con;
    private ResultSet resultSet;
    String url;
    static boolean status = false;
	
	public LoginUser() {
		//set up the driver
		try {
			Class.forName(AppConstant.jdbcDriver).newInstance();
			url = AppConstant.url.replace("?", "");
			this.con = DriverManager.getConnection(url + AppConstant.dbName, AppConstant.userName, AppConstant.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(UserModel userModel) {
		try {
			preStatement = con.prepareStatement(DBQuery.loginQuery);
			preStatement.setString(1,userModel.getEmail());
			preStatement.setString(2,userModel.getPassword());
			resultSet = preStatement.executeQuery();
			status = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
}
