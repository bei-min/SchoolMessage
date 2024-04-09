package Servlet;

import DBC.CollectionOP;
import DBC.LikeOP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet.CollectionSum")
public class CollectionSum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        String RID = request.getParameter("RID");
        int rid = Integer.parseInt(RID);

        int cnt = new CollectionOP().sum(rid);
        //System.out.println(cnt);
        PrintWriter out = response.getWriter();
        out.print(cnt);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
