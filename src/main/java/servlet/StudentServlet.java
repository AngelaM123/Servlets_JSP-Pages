package servlet;


import DAO.Impl.StudentDAOImpl;
import DTO.StudentDTO;
import com.google.gson.Gson;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private Gson gson = new Gson();
    private StudentDAOImpl studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl() {
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        try {

            if (request.getParameter("fullData") != null) {
                Boolean fullData = Boolean.parseBoolean(request.getParameter("fullData"));
                jsondtoStudent(request, response, fullData);
            } else {

                switch (action) {

                    case "save":
                        saveStudent(request, response);
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);

                        break;

                    case "delete":
                        if (request.getParameter("id") != null) {
                            Student student = studentById(request, response);
                            //request.setAttribute("faculty", faculty);
                            deleteStudent(request, response);
                            request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", " id dosen't exist so student can't be deleted");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;

                    case "update":
                        updateStudent(request, response);
                        request.setAttribute("link", "http://localhost:8080/StudentServlet?action=all");

                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        break;

                    case "all":

                        List<Student> studentssListfromMethod = allStudents(request, response);

                        if (request.getParameter("jsonFormat") != null) {
                            String studentJsonString = this.gson.toJson(studentssListfromMethod);
                            PrintWriter pr = response.getWriter();
                            pr.print(studentJsonString);
                            pr.flush();

                        } else {
                            request.setAttribute("studentListfromJsp", studentssListfromMethod);
                            request.getRequestDispatcher("jsp/studentList.jsp").forward(request, response);
                        }

                        break;

                    case "byId":
                        if (request.getParameter("id") != null) {
                            Student student = studentById(request, response);

                            request.setAttribute("student", student);
                            request.getRequestDispatcher("jsp/studentById.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "missing id in query parametar");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;
                    case "new":
                        request.getRequestDispatcher("jsp/studentNew.jsp").forward(request, response);
                        break;
                    default:
                        getStudent(request, response);
                        break;
                }
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Student> allStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> studentHere = studentDAO.getAll();

        return studentHere;

    }

    private Student studentById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.getById(id);

        return student;

    }

    private void saveStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String location = request.getParameter("location");
        int indeks = Integer.parseInt(request.getParameter("indeks"));

        Student student = new Student(name, surname, location, indeks);
        studentDAO.save(student);

    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student stud = studentDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            stud.setName(name);
        }
        String surname = request.getParameter("surname");
        if (surname != null) {
            stud.setSurname(surname);
        }
        String location = request.getParameter("location");
        if (location != null) {
            stud.setLocation(location);
        }
        Integer indeks = Integer.parseInt(request.getParameter("indeks"));
        if (indeks != null) {
            stud.setIndeks(indeks);
        }

        studentDAO.update(stud);

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.delete(id);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    private void jsondtoStudent(HttpServletRequest request, HttpServletResponse response, boolean fullData)
            throws SQLException, Exception, IOException {


        Gson gson = new Gson();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        StudentDTO studentDTO = new StudentDTO();

        int student_id = Integer.parseInt(request.getParameter("id"));

        if (fullData) {

            studentDTO = studentDAO.getStudentDTOwithUni(student_id);
        } else {

            studentDTO = studentDAO.getStudentDTOwithOutUni(student_id);

        }

        String jsonNewStudent = "";
        try {
            jsonNewStudent = gson.toJson(studentDTO);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewStudent";
            response.getWriter().print(errorCreate);
        }

        response.getWriter().print(jsonNewStudent);

    } //end of if fulldata

    private void getStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Student student = studentDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            student.setName(name);
        }
        String location = request.getParameter("location");
        if (location != null) {
            student.setLocation(location);
        }
        String surname = request.getParameter("surname");
        if (surname != null) {
            student.setSurname(surname);
        }

        Integer indeks = Integer.parseInt(request.getParameter("indeks"));
        if (indeks != null) {
            student.setIndeks(indeks);
        }

// convert Java object Professor to Json object
        String jsonNewStudent = "";
        try {
            jsonNewStudent = gson.toJson(student);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewStudent";
            response.getWriter().print(errorCreate);
        }
        response.getWriter().print(jsonNewStudent);

        PrintWriter out = response.getWriter();

    }
}



