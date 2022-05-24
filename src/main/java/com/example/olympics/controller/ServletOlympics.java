package com.example.olympics.controller;

import com.example.olympics.model.Connection_Util;
import com.example.olympics.model.bean.User_account;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "ServletOlympics", value = "/ServletOlympics")
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
}

