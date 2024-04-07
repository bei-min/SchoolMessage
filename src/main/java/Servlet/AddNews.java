package Servlet;

import DBC.NewsOP;
import Execute.News;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/Servlet.AddNews")
public class AddNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");
        String title = request.getParameter("title");
        String F = request.getParameter("f");
        int f = Integer.parseInt(F);
        //System.out.println(f);
        String Imgurl = request.getParameter("imgurl");
        String content = request.getParameter("content");
        String person = request.getParameter("person");

        NewsOP news = new NewsOP();
        int cnt = news.add(title , f , Imgurl , content , person);

        PrintWriter out = response.getWriter();
        boolean flag = cnt != 0;
        out.print(flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
