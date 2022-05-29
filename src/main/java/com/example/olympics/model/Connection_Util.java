package com.example.olympics.model;

import com.example.olympics.model.bean.*;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<results> getResults(results rs, String action) throws Exception{
        List<results> results= new ArrayList<>();
        String msg="nothing";
        if(!action.equals("login")){
            msg=setResults(rs,action);
        }
        if(msg.equals("Successful")||action.equals("login")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            try {
                myConn = dataSource.getConnection();
                String sql = "Select * from results";
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String sportTitle=myRs.getString("sportTitle");
                    String winnersName=myRs.getString("winnersName");
                    String country=myRs.getString("country");
                    String medal=myRs.getString("medal");
                    results rst=new results(id,sportTitle,winnersName,country,medal);
                    results.add(rst);
                }

            }catch (Exception e){
                System.out.println(e);
                results.clear();
            }finally {
                close(myConn,myStmt,myRs);
            }
        }
        return results;
    }

    private String setResults(results rs, String action) throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        String sql=null;
        try {
            if(action.equals("deleting")){
                myConn = dataSource.getConnection();
                sql = "Delete form results where(id='"+rs.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
                myStmt.execute();
            }else{
                if(action.equals("uploading")){
                    myConn = dataSource.getConnection();
                    sql = "INSERT INTO results (`sportTitle`, `winnersName`, `country`, `medal`) VALUES (?,?,?,?);";

                }else if(action.equals("updating")){
                    myConn = dataSource.getConnection();
                    sql = "UPDATE results set `sportTitle`, `winnersName`, `country`, `medal` where (id='"+rs.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, rs.getSportTitle());
                myStmt.setString(2, rs.getWinnersName());
                myStmt.setString(3, rs.getCountry());
                myStmt.setString(4, rs.getMedal());
                myStmt.execute();
                msg="Successful";
            }

        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn,myStmt,null);
        }
        return msg;
    }

    public List<News> getNews(News ns, String action) throws Exception {
        List<News> news= new ArrayList<>();
        String msg="nothing";
        if(!action.equals("login")){
            msg=setNews(ns,action);
        }
        if(msg.equals("Successful")||action.equals("login")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            try {
                myConn = dataSource.getConnection();
                String sql = "Select * from news";
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String sportTitle=myRs.getString("newsTitle");
                    String winnersName=myRs.getString("date");
                    String country=myRs.getString("context");
                    String medal=myRs.getString("image");
                    News rst=new News(id,sportTitle,winnersName,country,medal);
                    news.add(rst);
                }

            }catch (Exception e){
                System.out.println(e);
                news.clear();
            }finally {
                close(myConn,myStmt,myRs);
            }
        }
        return news;
    }

    private String setNews(News ns, String action) throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        String sql=null;
        try {
            if(action.equals("deleting")){
                myConn = dataSource.getConnection();
                sql = "Delete form news where(id='"+ns.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
                myStmt.execute();
            }else{
                if(action.equals("uploading")){
                    myConn = dataSource.getConnection();
                    sql = "INSERT INTO news (`newsTitle`, `date`, `context`, `image`) VALUES (?,?,?,?);";

                }else if(action.equals("updating")){
                    myConn = dataSource.getConnection();
                    sql = "UPDATE news set `newsTitle`, `date`, `context`, `image` where (id='"+ns.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, ns.getNewsTitle());
                myStmt.setString(2, ns.getDate());
                myStmt.setString(3, ns.getContext());
                myStmt.setString(4, ns.getImage());
                myStmt.execute();
                msg="Successful";
            }

        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn,myStmt,null);
        }
        return msg;
    }

    public List<event> getEvent(event ev, String action) throws Exception {
        List<event> events= new ArrayList<>();
        String msg="nothing";
        if(!action.equals("login")){
            msg=setEvent(ev,action);
        }
        if(msg.equals("Successful")||action.equals("login")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            try {
                myConn = dataSource.getConnection();
                String sql = "Select * from events";
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String eventTitle=myRs.getString("eventTitle");
                    String date=myRs.getString("date");
                    String location=myRs.getString("location");
                    String context=myRs.getString("context");
                    String image=myRs.getString("image");
                    event evt=new event(id, eventTitle,date,location,context,image);
                    events.add(evt);
                }

            }catch (Exception e){
                System.out.println(e);
                events.clear();
            }finally {
                close(myConn,myStmt,myRs);
            }
        }
        return events;
    }

    private String setEvent(event ev, String action) throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        String sql=null;
        System.out.println(action);
        try {
            if(action.equals("deleting")){
                myConn = dataSource.getConnection();
                sql = "Delete form events where(id='"+ev.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
                myStmt.execute();
            }else{
                if(action.equals("uploading")){

                    myConn = dataSource.getConnection();
                    sql = "INSERT INTO events (`eventTitle`, `date`, `location`, `context`, `image`) VALUES (?,?,?,?,?);";

                }else if(action.equals("updating")){
                    myConn = dataSource.getConnection();
                    sql = "UPDATE events set `eventTitle`=?, `date`=?, `location`=?, `context`=?, `image`=? where (id='"+ev.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, ev.getEventTitle());
                myStmt.setString(2, ev.getDate());
                myStmt.setString(3, ev.getLocation());
                myStmt.setString(4, ev.getContext());
                myStmt.setString(5, ev.getImage());
                myStmt.execute();
                msg="Successful";
            }

        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn,myStmt,null);
        }
        return msg;
    }

    public List<Broadcast> getBroadcast(Broadcast bc, String action) throws Exception {
        List<Broadcast> broadcastsList= new ArrayList<>();
        String msg="nothing";
        if(!action.equals("login")){
            msg=setBroadcast(bc,action);
        }
        if(msg.equals("Successful")||action.equals("login")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            try {
                myConn = dataSource.getConnection();
                String sql = "Select * from broadcasting b, url u where b.sport=u.sport";
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String broadcastname=myRs.getString("broadcastname");
                    String sport=myRs.getString("sport");
                    String url=myRs.getString("url");
                    Broadcast evt=new Broadcast(id,broadcastname,sport,url);
                    broadcastsList.add(evt);
                }

            }catch (Exception e){
                System.out.println(e);
                broadcastsList.clear();
            }finally {
                close(myConn,myStmt,myRs);
            }
        }
        return broadcastsList;
    }

    private String setBroadcast(Broadcast bc, String action) throws Exception {
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        String sql=null;
        System.out.println(action);
        try {
            myConn = dataSource.getConnection();
            if(action.equals("deleting")){
                myConn = dataSource.getConnection();
                sql = "Delete form broadcasting where(id='"+bc.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
                myStmt.execute();
            }else{
                if(action.equals("uploading")){
                    sql = "INSERT INTO broadcasting (`broadcastname`, `sport`) VALUES (?,?);";
                    myStmt = myConn.prepareStatement(sql);
                }else if(action.equals("updating")){
                    myConn = dataSource.getConnection();
                    sql = "UPDATE broadcasting set `broadcastname`=?, `sport`=?, where (id='"+bc.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, bc.getBroadcastName());
                myStmt.setString(2, bc.getSportName());

                myStmt.execute();
                msg="Successful";
            }

        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn,myStmt,null);
        }
        return msg;
    }
}

