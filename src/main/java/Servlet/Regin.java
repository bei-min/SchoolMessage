package Servlet;

import DBC.MemberOP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet.Regin")
public class Regin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(email);

        MemberOP memberOP = new MemberOP();
        int cnt = memberOP.add(username , password , email);
        PrintWriter out = response.getWriter();
        boolean flag = cnt != 0;
        out.print(flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
