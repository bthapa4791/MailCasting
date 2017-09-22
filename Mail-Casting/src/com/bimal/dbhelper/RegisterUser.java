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
public class RegisterUser {
	
	private PreparedStatement preStatement;
    private Statement statement;
    private Connection con;
    String url;
    static int status=0;
	
	public RegisterUser() {
		try {
            Class.forName(AppConstant.jdbcDriver).newInstance();
            this.con = DriverManager.getConnection(AppConstant.url, AppConstant.userName, AppConstant.password);
            System.out.println("connected");
            statement = this.con.createStatement();
            statement.executeUpdate(DBQuery.createDB + AppConstant.dbName);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
           e.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int registerUser(UserModel userModel) throws SQLException {
		String createTablequery = DBQuery.createTableQuery;
		String registerQuery = DBQuery.registerQuery;
		url = AppConstant.url.replace("?", "");
		try {
			this.con = DriverManager.getConnection(url + AppConstant.dbName, AppConstant.userName, AppConstant.password);
			statement = this.con.createStatement();
			statement.executeUpdate(createTablequery);
			statement.executeUpdate(DBQuery.createInboxQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			preStatement = con.prepareStatement(registerQuery);
			preStatement.setString(1, userModel.getEmail());
			preStatement.setString(2, userModel.getPassword());
			preStatement.setString(3, userModel.getName());
			preStatement.setString(4, userModel.getGender());
			preStatement.setString(5, userModel.getContact());
			preStatement.setString(6, userModel.getCountry());
			
			status = preStatement.executeUpdate();
			System.out.println(status);
		}
		return status;
	}
	
	
}
