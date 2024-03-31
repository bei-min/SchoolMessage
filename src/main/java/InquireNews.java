
import DBC.NewsOP;
import Execute.News;
import com.alibaba.fastjson.JSON;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/InquireNews")
public class InquireNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get");
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        ArrayList<News> news = new NewsOP().show();
        PrintWriter out = response.getWriter();
        for (News i:
             news) {
            String jsonstr = JSON.toJSONString(i);
            out.print(jsonstr);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("Post:" + username);
//        System.out.println("Post:" + password);
        System.out.println("Post");
//        response.setContentType( "text/html;charset=utf-8" );
//        PrintWriter out = response.getWriter();
//        out.print("success"); //输出到IO流

    }
}
