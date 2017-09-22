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
import com.bimal.model.InboxModel;
import com.bimal.utility.AppConstant;

/**
 * @author bimalthapa
 *
 */
public class InBoxMsg {
	
	private PreparedStatement preStatement;
    private Statement statement;
    private Connection con;
    private ResultSet resultSet;
    String url;
    static boolean status = false;
    
    public InBoxMsg() {
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
    
    public boolean doReadInBoxMsg(String sender) throws SQLException {
		try {
			preStatement  = con.prepareStatement(DBQuery.retriveInboxQuery);
			preStatement.setString(1, sender);
			this.resultSet = preStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (!this.resultSet.next()) {
				status = false;
			} else {
				resultSet.previous();
				status = true;
			}
		}
		return status;
	}
    
    public String getHTMLTable() {
    	String table = "";
    	table += "<table border=1 cellspacing='4' cellpadding='4' bgcolor='#A7A7A7'>";
    	table += "<tr><th>DATE</th> <th>SENDER</th> <th>RECEIVER</th> <th>MESSAGE</th> <th>DELETE</th></tr>";
    	try {
			while(this.resultSet.next()){
			InboxModel inboxModel = new InboxModel();
			inboxModel.setDate(this.resultSet.getString("date"));
			inboxModel.setReceiver(this.resultSet.getString("receiver"));
			inboxModel.setSender(this.resultSet.getString("sender"));
			inboxModel.setMessage(this.resultSet.getString("msg"));
	
			table += "<tr>";
			table += "<td>";
			 table += inboxModel.getDate(); 
			table += "</td>";
			table += "<td>";
			 table += inboxModel.getSender();
			table += "</td>";
			table += "<td>";
			table += inboxModel.getReceiver();
			table += "</td>";
			table += "<td>";
			 table += inboxModel.getMessage();
			table += "</td>";
			table += "<td>";
			 	table += "<a href=deleteMsg?id=" + this.resultSet.getString("id") + ">delete</a>";
			table += "</td>";
			table += "</tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	table += "</table>";
    	
		return table;
    	
    }

}
