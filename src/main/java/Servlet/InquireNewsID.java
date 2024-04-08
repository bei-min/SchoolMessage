package Servlet;

import DBC.NewsOP;
import Execute.CharChange;
import Execute.News;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Servlet.InquireNewsID")
public class InquireNewsID extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        String ID = new CharChange().ISO_to_UTF(request.getParameter("ID"));

        ArrayList<News> ClassList = new NewsOP().find("ID" , ID);

        PrintWriter out = response.getWriter();
        JSON json = new JSONArray(ClassList);
        out.print(json);
    }
}
