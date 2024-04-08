package Servlet;

import DBC.MemberOP;
import Execute.CharChange;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet.InquireMemberRecord")
public class InquireMemberRecord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader(  "Access-Control-Allow-Origin", "*");
        response.addHeader(  "Access-Control-Allow-Method","POST,GET");

        String username = new CharChange().ISO_to_UTF(request.getParameter("username"));
        username = request.getParameter("username");
        MemberOP memberOP = new MemberOP();
        System.out.println(username);

        PrintWriter out = response.getWriter();
        String json = JSON.toJSONString(memberOP.find(username));
        out.print(json);
    }
}
