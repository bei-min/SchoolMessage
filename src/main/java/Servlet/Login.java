package Servlet;

import DBC.MemberOP;
import DBC.NewsOP;
import Execute.News;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/Servlet.Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        //System.out.println("LoginPost");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        MemberOP memberOP = new MemberOP();
        boolean flag = memberOP.find(username , password);

        PrintWriter out = response.getWriter();
        out.print(flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
