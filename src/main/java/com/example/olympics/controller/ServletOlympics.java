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

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
            }
            // listStudents(request, response);
        }
        catch (Exception exc) {
            exc.printStackTrace();

        }
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
            session.setAttribute("AlertSuccessful","Successfully");
            session.setAttribute("broadcastInfo",results);
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
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);

        }else{
            System.out.println("error");
            session.setAttribute("AlertError","Error");
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        }

    }
}

