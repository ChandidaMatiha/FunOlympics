package com.example.olympics.model;

import com.example.olympics.model.bean.*;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
            myConn = dataSource.getConnection();
            if(action.equals("deleting")){

                sql = "Delete from results where(id='"+rs.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
            }else{
                if(action.equals("uploading")){
                    sql = "INSERT INTO results (`sportTitle`, `winnersName`, `country`, `medal`) VALUES (?,?,?,?);";

                }else if(action.equals("updating")){
                    sql = "UPDATE results set `sportTitle`=?, `winnersName`=?, `country`=?, `medal`=? where (id='"+rs.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, rs.getSportTitle());
                myStmt.setString(2, rs.getWinnersName());
                myStmt.setString(3, rs.getCountry());
                myStmt.setString(4, rs.getMedal());

            }
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
        try {  myConn = dataSource.getConnection();
            if(action.equals("deleting")){

                sql = "Delete from news where(id='"+ns.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
            }else{
                if(action.equals("uploading")){
                    sql = "INSERT INTO news (`newsTitle`, `date`, `context`, `image`) VALUES (?,?,?,?);";

                }else if(action.equals("updating")){
                    sql = "UPDATE news set `newsTitle`=?, `date`=?, `context`=?, `image`=? where (id='"+ns.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, ns.getNewsTitle());
                myStmt.setString(2, ns.getDate());
                myStmt.setString(3, ns.getContext());
                myStmt.setString(4, ns.getImage());

            }
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

    public List<event> getEvent(event ev, String action) throws Exception {
        List<event> events= new ArrayList<>();
        String msg="nothing";
        if(action.equals("deleting")||action.equals("updating")||action.equals("uploading")){
            msg=setEvent(ev,action);
        }
        if(msg.equals("Successful")||action.equals("login")||action.equals("login1")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            String sql=null;
            try {
                myConn = dataSource.getConnection();
                LocalDate today=LocalDate.now();
                if(action.equals("login1")) {
                    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    //today = LocalDate.now();
                    String tomorrow = (today.plusDays(1)).format(dateTimeFormatter);
                    sql = "Select * from events where date like '%"+tomorrow+"%';";
                }else {
                    sql = "Select * from events ";
                }
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String eventTitle=myRs.getString("eventTitle");
                    String date=myRs.getString("date");
                    String location=myRs.getString("location");
                    String context=myRs.getString("context");
                    String image=myRs.getString("image");
                    event evt;
                    if(action.equals("login1")) {
                        DateTimeFormatter dateTimeFormatter2=DateTimeFormatter.ofPattern("dd");
                        DateTimeFormatter mouthDa=DateTimeFormatter.ofPattern("MMMM");
                        DateTimeFormatter year=DateTimeFormatter.ofPattern("yyyy");
                        String daynumber = (today.plusDays(1)).format(dateTimeFormatter2);
                        String month = (today.plusDays(1)).format(mouthDa);
                        String yearnum = (today.plusDays(1)).format(year);
                        System.out.println(yearnum);
                        evt=new event(id, eventTitle,date,location,context,image,daynumber,month,yearnum);
                    }else {
                        evt=new event(id, eventTitle,date,location,context,image);
                    }

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

    public User_account getUserInfo(String email, String password) throws Exception {
        String login="login";
        User_account userinfo=null;
        Connection myConn=null;
        ResultSet myRs=null;
        PreparedStatement myStmt=null;
        try{
            myConn=dataSource.getConnection();
            String sql ="SELECT * FROM user_account where `email`='"+email+"' and password='"+password+"'";
            myStmt=myConn.prepareStatement(sql);
            myRs=myStmt.executeQuery();
            while(myRs.next()) {
                String userId="0";
                String  fullName=myRs.getString("full_name");
                String userType=myRs.getString("user_type");
                userinfo=new User_account(userId,fullName,email,"nothing",userType);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            close(myConn,myStmt,myRs);
        }

        return userinfo;
    }

    private String setEvent(event ev, String action) throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        String msg=null;
        String sql=null;
        System.out.println(action);
        try { myConn = dataSource.getConnection();
            if(action.equals("deleting")){
                sql = "Delete from events where(id='"+ev.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
            }else{
                if(action.equals("uploading")){
                    sql = "INSERT INTO events (`eventTitle`, `date`, `location`, `context`, `image`) VALUES (?,?,?,?,?);";
                }else if(action.equals("updating")){
                    sql = "UPDATE events set `eventTitle`=?, `date`=?, `location`=?, `context`=?, `image`=? where (id='"+ev.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, ev.getEventTitle());
                myStmt.setString(2, ev.getDate());
                myStmt.setString(3, ev.getLocation());
                myStmt.setString(4, ev.getContext());
                myStmt.setString(5, ev.getImage());

            }
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

    public List<Broadcast> getBroadcast(Broadcast bc, String action) throws Exception {
        List<Broadcast> broadcastsList= new ArrayList<>();
        String msg="nothing";

        if(action.equals("deleting")||action.equals("updating")||action.equals("uploading")){
            msg=setBroadcast(bc,action);
        }
        if(msg.equals("Successful")||action.equals("login")||action.equals("login1")){
            Connection myConn=null;
            PreparedStatement myStmt=null;
            ResultSet myRs=null;
            String sql;
            try {
                myConn = dataSource.getConnection();
                if(action.equals("login1")){
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String  strDate = formatter.format(date);

                    sql = "Select * from broadcasting b, url u,events e  where b.sport=u.sport and b.sport=e.eventTitle and date like '%"+strDate+"%';";
                }else{
                    sql = "Select * from broadcasting";
                }
                myStmt = myConn.prepareStatement(sql);
                myRs=myStmt.executeQuery();
                int count=0;
                while(myRs.next()){
                    String id=myRs.getString("id");
                    String broadcastname=myRs.getString("broadcastname");
                    String sport=myRs.getString("sport");
                    if(action.equals("login1")&& count<3){
                        count+=1;
                        System.out.println(action);
                        String url=myRs.getString("url");
                        String eventTitle=myRs.getString("eventTitle");
                        String date=myRs.getString("date");
                        String location=myRs.getString("location");
                        String context=myRs.getString("context");
                        String image=myRs.getString("image");
                        Broadcast evt=new Broadcast(id,broadcastname,sport,url.replace("watch?v=", "embed/"),eventTitle,date,location,context,image);
                        broadcastsList.add(evt);
                    }else{
                        Broadcast evt=new Broadcast(id,broadcastname,sport,"Nothing");
                        broadcastsList.add(evt);
                    }

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
                sql = "Delete from broadcasting where(id='"+bc.getId()+"');";
                myStmt = myConn.prepareStatement(sql);
            }else{
                if(action.equals("uploading")){
                    sql = "INSERT INTO broadcasting (`broadcastname`, `sport`) VALUES (?,?);";
                    myStmt = myConn.prepareStatement(sql);
                }else if(action.equals("updating")){
                    sql = "UPDATE broadcasting set `broadcastname`=?, `sport`=? where (id='"+bc.getId()+"')";
                }
                myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1, bc.getBroadcastName());
                myStmt.setString(2, bc.getSportName());


            }
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

    public List<String> countries()throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        List<String> countries= new ArrayList<>();

        try{
            //get a connection
            myConn =dataSource.getConnection();
            String sql3;
            sql3 = " SELECT * FROM results group by country ";
            myStmt = myConn.prepareStatement(sql3);
            System.out.println("sql "+myStmt);
            myRs=myStmt.executeQuery();
            while(myRs.next()){
                String country=myRs.getString("country");
                countries.add(country);
            }

        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println ("This is error: "+e);
        } finally {
            close(myConn,myStmt,null);
        }
        return countries;
    }

    public List<medals> medalsSummary()throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        List<String> countries=countries();
        List<medals> medals=new ArrayList<>();

        for (int i=0;i<countries.size();++i){
            try{
                //get a connection
                myConn =dataSource.getConnection();
                String sql3;
                sql3 = " SELECT COUNT(IF(medal = 'Gold', 1, NULL)) 'Gold',\n" +
                        "    COUNT(IF(medal = 'Silver', 1, NULL)) 'Silver',\n" +
                        "    COUNT(IF(medal = 'Bronze', 1, NULL)) 'Bronze' FROM results where country='"+countries.get(i)+"'";
                myStmt = myConn.prepareStatement(sql3);
                System.out.println("sql "+myStmt);
                myRs=myStmt.executeQuery();
                while(myRs.next()){
                    //String country=myRs.getString("country");
                    int gold=myRs.getInt("Gold");
                    int silver=myRs.getInt("Silver");
                    int bronze=myRs.getInt("bronze");
                    int total=gold+silver+bronze;
                    medals md=new medals(countries.get(i),String.valueOf(gold),String.valueOf(silver),String.valueOf(bronze),String.valueOf(total));
                    medals.add(md);

                }

            }catch(SQLIntegrityConstraintViolationException e){
                System.out.println ("This is error: "+e);
            } finally {
                close(myConn,myStmt,null);
            }
        }

        return medals;
    }

    public String changePassword(String password, String email) throws Exception{
        Connection myConn=null;
        ResultSet myRs=null;
        PreparedStatement myStmt=null;
        String msg=null;
        try {
            myConn = dataSource.getConnection();
            String sql = "UPDATE `user_account` SET `password` = ? WHERE (`email` = '" + email + "');";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,password);
            myStmt.execute();
            msg="Successful";
        }catch (Exception e){
            System.out.println(e);
            msg="Error";
        }finally {
            close(myConn, myStmt, null);
        }
        return msg;
    }

}

