package com.example.olympics.controller;

import com.example.olympics.model.Connection_Util;
import com.example.olympics.model.bean.*;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ServletOlympics", value = "/ServletOlympics")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 14, // 10 MB

        maxFileSize = 1024 * 1024 * 1000000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000000)   	// 1 GB

public class ServletOlympics extends HttpServlet {


    private Connection_Util connectionUtil;
    @Resource(name = "jdbc/Olympics")

    private DataSource dataSource;


    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();

        try {
            // Create our StudentDBUtil.... and pass in the conn pool/dataSource
            connectionUtil = new Connection_Util(dataSource);
        }

        catch (Exception e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            if (theCommand == null) {

                theCommand = "display_List";
            }
            switch (theCommand) {
                case "Registering_User":
                    User_Registration(request,response);
                    break;
                case "Login_User":
                    loginUser(request,response);
                    break;
            }
            // listStudents(request, response);
        }
        catch (Exception exc) {
            exc.printStackTrace();

        }
    }


    private void changePassword(HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session=request.getSession();
        String email= (String) session.getAttribute("EmailVerified");
        String password =request.getParameter("password");
        String msg=connectionUtil.changePassword(password,email);
        if(msg.equals("Successful")){
            if (session.getAttribute("EmailVerified") != null){
                session.removeAttribute("EmailVerified");
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            session.setAttribute("alertWaring","Something went wrong");
            request.getRequestDispatcher("passwordChange.jsp").forward(request, response);
        }


    }

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session=request.getSession();
        String email =request.getParameter("email");
        otp.emailVerification(email);
        session.setAttribute("EmailSent",email);
        request.getRequestDispatcher("user_passcode_verification.jsp").forward(request, response);
    }

    private void VerifyCode(HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session=request.getSession();
        String email= (String) session.getAttribute("EmailSent");
        String code =request.getParameter("codeVerify");
        System.out.println("email"+email);
        String msg=verifyOtp.sentVerifyEmail(code,email);
        if(msg.equals("Incorrect code")){
            session.setAttribute("alertWaring", "The provided code is incorrect");
            request.getRequestDispatcher("user_passcode_verification.jsp").forward(request, response);
        }else if(msg.equals("error unknown code")){
            session.setAttribute("alertWaring", "The code has expired");
            request.getRequestDispatcher("user_passcode_verification.jsp").forward(request, response);
        }else if(msg.equals("Correct code")){
            if (session.getAttribute("alertWaring") != null){
                session.removeAttribute("alertWaring");
                session.removeAttribute("EmailSent");
            }
            session.setAttribute("EmailVerified",email);
            request.getRequestDispatcher("passwordChange.jsp").forward(request, response);
        }

    }



    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session=request.getSession();
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        User_account userinfo=connectionUtil.getUserInfo(email,password);
        if(userinfo==null){
            session.setAttribute("email",email);
            session.setAttribute("alertErrorLogin","Incorrect password or email");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            if (session.getAttribute("email") != null){
                session.removeAttribute("email");
                session.removeAttribute("alertErrorLogin");
            }
            session.setAttribute("alertSuccessful","Successfully login");
            session.setAttribute("userInfo",userinfo);

            onLogin(request,response);

            if (userinfo.getUser_type().equals("Admin")){
                request.getRequestDispatcher("admin-home.jsp").forward(request, response);
            }else if(userinfo.getUser_type().equals("Representatives")){
                request.getRequestDispatcher("athletes_form.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }
    }

    private void User_Registration(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        String fullName =request.getParameter("FullName");
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        User_account userinfo=new User_account(null,fullName,email,password,"Spector");
        String msg=connectionUtil.setUserInfo(userinfo);
        System.out.println("meee");
        if(msg.equals("Successful")){
            if (session.getAttribute("user_account") != null){
                session.removeAttribute("user_account");
                session.removeAttribute("alertError");
            }
            session.setAttribute("alertSuccessful","Successfully registered");
            request.getRequestDispatcher("user_register.jsp").forward(request, response);
        }else {
            session.setAttribute("user_acc",userinfo);
            session.setAttribute("alertError","Failed registered");
            request.getRequestDispatcher("user_register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String theCommand = request.getParameter("command");
            System.out.println("command "+theCommand);

            if (theCommand == null) {

                theCommand = "display_List";
            }
            switch (theCommand) {
                case "Registering_User":
                    User_Registration(request,response);
                    break;
                case "Login_User":
                    loginUser(request,response);
                    break;
                case "VerifyCode":
                    VerifyCode(request,response);
                    break;
                case "forgotPassword":
                    forgotPassword(request,response);
                    break;
                case "changePassword":
                    changePassword(request,response);
                    break;
                case "Event":
                    Event(request,response);
                    break;
                case "News":
                    News(request,response);
                    break;
                case "Results":
                    Results(request,response);
                    break;
                case "Broadcast":
                    eventBroadcast(request,response);
                    break;
                case "deleteResults":
                    deleteResults(request,response);
                    break;
                case "deleteEvent":
                    deleteEvent(request,response);
                    break;
                case "deleteNews":
                    deleteNews(request,response);
                    break;
                case "deleteBroadcast":
                    deleteBroadcast(request,response);
                    break;
            }
            // listStudents(request, response);
        }
        catch (Exception exc) {
            exc.printStackTrace();

        }
    }

    private void deleteBroadcast(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id =request.getParameter("id");
        Broadcast rs=new Broadcast(id);
        connectionUtil.getBroadcast(rs,"deleting");
        onLogin(request,response);
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
    }

    private void deleteNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id =request.getParameter("id");
        News rs=new News(id);
        connectionUtil.getNews(rs,"deleting");
        onLogin(request,response);
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        String id =request.getParameter("id");
        event rs=new event(id);
        connectionUtil.getEvent(rs,"deleting");
        onLogin(request,response);
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
    }

    private void deleteResults(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        String id =request.getParameter("id");
        results rs=new results(id);
        connectionUtil.getResults(rs,"deleting");
        onLogin(request,response);
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
    }

    private void eventBroadcast(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session= request.getSession();
        String broadcast=request.getParameter("broadcast");
        String sport=request.getParameter("sport");
        String action=request.getParameter("action");
        String id=request.getParameter("id");
        System.out.println(broadcast+"_"+sport);
        Broadcast bc=new Broadcast(id,broadcast,sport,null);
        List<Broadcast> results=connectionUtil.getBroadcast(bc,action);

        if(!results.isEmpty()){
            if(session.getAttribute("AlertError")!= null){
                session.removeAttribute("AlertError");
            }
            System.out.println("works ");
            session.setAttribute("AlertSuccessful","Successfully");
            session.setAttribute("broadcastInfo",results);
            onLogin(request,response);
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);

        }else{
            System.out.println("error ");
            session.setAttribute("AlertError","Error");
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        }
    }

    private void Results(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session= request.getSession();
        String sportTitle=request.getParameter("sportTitle");
        String winnersName=request.getParameter("winnersName");
        String country=request.getParameter("country");
        String medal=request.getParameter("medal");
        String action=request.getParameter("action");
        String id="0";
        if(action.equals("updating") || action.equals("deleting")){
            id=request.getParameter("id");
        }
        results rs=new results(id,sportTitle,winnersName,country,medal);
        List<results> results=connectionUtil.getResults(rs,action);

        if(!results.isEmpty()){
            if(session.getAttribute("AlertError")!= null){
                session.removeAttribute("AlertError");
            }
            session.setAttribute("AlertSuccessful","Successfully");
            session.setAttribute("resultsInfo",results);
            onLogin(request,response);
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);

        }else{
            System.out.println("error ");
            session.setAttribute("AlertError","Error");
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        }

    }

    private void News(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session= request.getSession();
        String newsTitle=request.getParameter("newsTitle");
        System.out.println("lets see"+newsTitle);
        String date=request.getParameter("date");
        String context=request.getParameter("context");
        String action=request.getParameter("action");
        String id="0";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ApplicationDate= String.valueOf(timestamp.getTime());
        if(action.equals("updating") || action.equals("deleting")){
            id=request.getParameter("id");
        }

        String fileName = null;
        String folderName6 = "NewsImage";
        String uploadPath6 = request.getServletContext().getRealPath("") + folderName6;
        File dir6 = new File(uploadPath6);
        if (!dir6.exists()) {
            dir6.mkdirs();
        }

        Part image=request.getPart("image");
        InputStream image1 = image.getInputStream();
        fileName=newsTitle+"_NewsImage"+ApplicationDate+".jpg";
        Files.copy(image1, Paths.get(uploadPath6 + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);


        News ns=new News(id,newsTitle,date,context,fileName);
        List<News> news=connectionUtil.getNews(ns,action);
        if(!news.isEmpty()){
            if(session.getAttribute("AlertError")!= null){
                session.removeAttribute("AlertError");
            }
            session.setAttribute("AlertSuccessful","Successfully");
            session.setAttribute("newsInfo",news);
            onLogin(request,response);
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);

        }else{
            session.setAttribute("AlertError","Error");
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        }

    }

    private void Event(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session= request.getSession();
        String eventTitle=request.getParameter("eventTitle");
        String date=request.getParameter("date");
        String location=request.getParameter("location");
        String context=request.getParameter("context");
        String action=request.getParameter("action");
        String id="0";

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ApplicationDate= String.valueOf(timestamp.getTime());
        if(action.equals("updating") || action.equals("deleting")){
            id=request.getParameter("id");
        }

        String fileName = null;
        String folderName6 = "EventImage";
        String uploadPath6 = request.getServletContext().getRealPath("") + folderName6;
        File dir6 = new File(uploadPath6);
        if (!dir6.exists()) {
            dir6.mkdirs();
        }

        Part image=request.getPart("image");
        InputStream image1 = image.getInputStream();
        fileName=eventTitle+"_EventImage"+ApplicationDate+".jpg";
        Files.copy(image1, Paths.get(uploadPath6 + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);


        event ev=new event(id,eventTitle,date,location,context,fileName);
        List<event> events=connectionUtil.getEvent(ev,action);
        if(!events.isEmpty()){

            if(session.getAttribute("AlertError")!= null){
                session.removeAttribute("AlertError");
            }
            session.setAttribute("AlertSuccessful","Successfully");
            session.setAttribute("eventInfo",events);
            onLogin(request,response);
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);

        }else{
            System.out.println("error");
            session.setAttribute("AlertError","Error");
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        }

    }

    private void onLogin(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        HttpSession session=request.getSession();
        String action="login";


        //Event
        event events=new event();
        List<event> event=connectionUtil.getEvent(events,action);
        session.setAttribute("eventInfo",event);

        //News
        News news=new News();
        List<News> newsList=connectionUtil.getNews(news,action);
        session.setAttribute("newsInfo",newsList);

        //Broadcast
        Broadcast br=new Broadcast();
        List<Broadcast> eventsList3=connectionUtil.getBroadcast(br,action);
        session.setAttribute("broadcastInfo",eventsList3);

        //Results
        results rs=new results();
        List<results> eventsList4=connectionUtil.getResults(rs,action);
        session.setAttribute("resultsInfo",eventsList4);

        //schedule
        List<Broadcast> ls=connectionUtil.getBroadcast(br,"login1");
        session.setAttribute("scheduleInfo",ls);

        //schedule
        List<event> TOMORROW=connectionUtil.getEvent(events,"login1");
        session.setAttribute("scheduleInfo2",TOMORROW);


    }

}

