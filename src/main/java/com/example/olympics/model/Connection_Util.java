package com.example.olympics.model;

import com.example.olympics.model.bean.User_account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection_Util {

    private final DataSource dataSource;

    public Connection_Util(DataSource theDataSource) {
        dataSource = theDataSource;

    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {

            if(myRs !=null) {
                myRs.close();
            }
            if (myStmt !=null) {

                myStmt.close();
            }

            if (myConn !=null) {
                myConn.close();//*does not really close it...just put
            }
        }catch(Exception exc) {

            exc.printStackTrace();
        }
    }


    public String setUserInfo(User_account userinfo) throws Exception {
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        try{
            myConn = dataSource.getConnection();
            String sql="INSERT INTO `Olympics`.`user_account` (`full_name`, `email`, `password`, `user_type`) VALUES (?,?,?,?);";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, userinfo.getFull_name());
            myStmt.setString(2, userinfo.getEmail());
            myStmt.setString(3, userinfo.getPassword());
            myStmt.setString(4, userinfo.getUser_type());
            myStmt.execute();
            msg="Successful";

        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn,myStmt,null);
        }
        return msg;
    }
}

