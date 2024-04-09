package Servlet;

import DBC.CollectionOP;
import DBC.LikeOP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet.Collection")
public class Collection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        String RID = request.getParameter("RID");
        int rid = Integer.parseInt(RID);
        String Name = request.getParameter("Name");
        System.out.println("Collection:" + Name);

        int cnt = new CollectionOP().Add(rid , Name);
        PrintWriter out = response.getWriter();
        boolean flag = cnt != 0;
        out.print(flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
