package Servlet;

import DBC.NewsOP;
import Execute.News;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/Servlet.InquireNews")
public class InquireNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Get");
        doPost(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST , GET");
        String Sum = request.getParameter("sum");
        int sum = Integer.parseInt(Sum);

        ArrayList<News> NewsList = new ArrayList<>();
        NewsOP newsop = new NewsOP();
        for(int i = sum ; i <= (sum + 3) ; i ++){
            NewsList.add(newsop.find(i));
        }
        PrintWriter out = response.getWriter();
        JSON json = new JSONArray(NewsList);
        out.print(json);
    }
}
