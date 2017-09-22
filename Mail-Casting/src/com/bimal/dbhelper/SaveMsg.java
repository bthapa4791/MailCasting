/**
 * 
 */
package com.bimal.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bimal.dbquery.DBQuery;
import com.bimal.model.InboxModel;
import com.bimal.utility.AppConstant;

/**
 * @author bimalthapa
 *
 */
public class SaveMsg {
	
	private PreparedStatement preStatement;
    private Statement statement;
    private Connection con;
    String url;
    static int status=0;
    
    public SaveMsg() {
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
    
    public int saveMsg(InboxModel inboxModel) {
    	try {
    		preStatement = con.prepareStatement(DBQuery.insertMsgQuery);
			preStatement.setString(1,inboxModel.getDate());
			preStatement.setString(2,inboxModel.getSender());
			preStatement.setString(3, inboxModel.getReceiver());
			preStatement.setString(4, inboxModel.getMessage());
			status = preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return status;
    }

}
