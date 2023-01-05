package servlet;

import com.google.gson.Gson;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WebServletFilter", urlPatterns = "/user")

public class WebServletFilter extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int indeks;
        indeks = Integer.parseInt(request.getParameter("indeks"));
       // Student student = new Student(name, surname, indeks);
        //String studentJsonString = this.gson.toJson(student);
        PrintWriter pr = response.getWriter();
       // pr.print(studentJsonString);
        pr.flush();
    }
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<p>TestingWebServletFilter!</p>");
        }
    }

