package com.onlineorder.onlineorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineorder.onlineorder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        String customer = request.getParameter("customer");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "Hello" + customer + "</h1>");
//        out.println("</body></html>");

//        response.setContentType("application/json");
//
//        JSONObject obj = new JSONObject();
//        obj.put("name", "cara");
//        obj.put("age", 29);
//        obj.put("gender", "female");
//
//        PrintWriter out = response.getWriter();
//        out.print(obj);
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setFirstName("cara");
        customer.setLastName("guan");

        PrintWriter out = response.getWriter();
        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String name = jsonRequest.getString("name");
        int age = jsonRequest.getInt("age");
        String gender = jsonRequest.getString("gender");

    }

    public void destroy() {
    }
}