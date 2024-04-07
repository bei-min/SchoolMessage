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
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/Servlet.AddNews")
public class AddNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        CharChange charChange = new CharChange();
        String title = charChange.ISO_to_UTF(request.getParameter("title"));
        String Imgurl = charChange.ISO_to_UTF(request.getParameter("imgurl"));
        String content = charChange.ISO_to_UTF(request.getParameter("content"));
        String person = charChange.ISO_to_UTF(request.getParameter("person"));
        String classify = charChange.ISO_to_UTF(request.getParameter("classify"));

        NewsOP news = new NewsOP();
        int cnt = news.add(title , Imgurl , content , person , classify);

        PrintWriter out = response.getWriter();
        boolean flag = cnt != 0;
        out.print(flag);
    }
}
