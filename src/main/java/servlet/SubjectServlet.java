package servlet;

import DAO.Impl.FacultyDAOImpl;
import DAO.Impl.SubjectDAOImpl;
import DAO.SubjectDAO;
import DTO.FacultyDTO;
import DTO.SubjectDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Faculty;
import model.Subject;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {

    private Gson gson = new Gson();
    private SubjectDAOImpl subjectDAO;

    public void init() {
        subjectDAO = new SubjectDAOImpl() {
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            // Boolean.parseBoolean(request.getParameter("fullData"));
            //String jsondtofaculty = request.getParameter("jsondtofaculty");

            if(request.getParameter("fullData") != null){
                Boolean fullData = Boolean.parseBoolean(request.getParameter("fullData"));
                jsondtoSubject(request, response, fullData);
            } else{

                switch (action) {

                    case "save":
                        saveSubject(request, response);
                        request.setAttribute("link","http://localhost:8080/SubjectServlet?action=all");
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request , response);

                        break;

                    case "delete":
                        if(request.getParameter("id") != null){
                            Subject subject =  subjectById(request,response);
                            //request.setAttribute("faculty", faculty);
                            deleteSubject(request, response);
                            request.setAttribute("link","http://localhost:8080/SubjectServlet?action=all");
                            request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message"," id dosen't exist so subject can't be deleted");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);

                        }

                        break;

                    case "update":
                        updateSubject(request, response);
                        request.setAttribute("link","http://localhost:8080/SubjectServlet?action=all");

                        request.getRequestDispatcher("jsp/successful.jsp").forward(request , response);
                        break;

                    case "all":

                        List<Subject> subjectsListfromMethod = allSubjects(request, response);

                        if(request.getParameter("jsonFormat" ) != null) {
                            String subjectJsonString = this.gson.toJson(subjectsListfromMethod);
                            PrintWriter pr = response.getWriter();
                            pr.print(subjectJsonString);
                            pr.flush();

                        } else {
                            request.setAttribute("subjectListfromJsp", subjectsListfromMethod);
                            request.getRequestDispatcher("jsp/subjectList.jsp").forward(request , response);
                        }

                        break;

                    case "byId":
                        if(request.getParameter("id") != null){
                            Subject subject =  subjectById(request,response);
                            request.setAttribute("subject", subject);
                            request.getRequestDispatcher("jsp/subjectById.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message","missing id in query parametar");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);

                        }

                        break;
                    case "new":
                        request.getRequestDispatcher("jsp/subjectNew.jsp").forward(request, response);
                        break;
                    default:
                        getSubject(request, response);
                        break;
                }
            }

        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private List<Subject> allSubjects(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Subject> subjectsHere = subjectDAO.getAll();
        /*String subjectJsonString = this.gson.toJson(subjectsHere);
        PrintWriter pr = response.getWriter();
        pr.print(subjectJsonString);
        pr.flush();*/
        return subjectsHere;
    }

    private Subject subjectById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Subject subject = subjectDAO.getById(id);
       /* String facultyJsonString = this.gson.toJson(faculty);
        PrintWriter pr = response.getWriter();
        pr.print(facultyJsonString);
        pr.flush();*/
        return subject;

    }
    private void saveSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String semester = request.getParameter("semester");
        int credits = Integer.parseInt(request.getParameter("credits"));
        Subject subject = new Subject(name, semester, credits);
        subjectDAO.save(subject);

    }
    private void updateSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Subject sub = subjectDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            sub.setName(name);
        }
        String semester = request.getParameter("semester");
        if (semester != null) {
            sub.setSemester(semester);
        }
        Integer credits = Integer.parseInt(request.getParameter("credits"));
        if (credits != null) {
            sub.setCredits(credits);
        }

        subjectDAO.update(sub);


    }
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        subjectDAO.delete(id);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    private void jsondtoSubject(HttpServletRequest request, HttpServletResponse response,boolean fullData)
            throws SQLException, Exception, IOException {

        Gson gson = new Gson();
        SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
        SubjectDTO subjectDTO = new SubjectDTO();
        //response.setContentType("application/json");
        int subject_id = Integer.parseInt(request.getParameter("id" ));

        if(fullData) {

            subjectDTO = subjectDAO.getSubjectDTOwithProf(subject_id);
        }else{

            subjectDTO = subjectDAO.getSubjectDTOwithOutProf(subject_id);

        }

        String jsonNewSubject = "";
        try {
            jsonNewSubject = gson.toJson(subjectDTO);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewSubject";
            response.getWriter().print(errorCreate);
        }

        response.getWriter().print(jsonNewSubject);

    } //end of if fulldata

    private void getSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Subject sub = subjectDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            sub.setName(name);
        }

        String semester = request.getParameter("semester");
        if (semester != null) {
            sub.setSemester(semester);
        }

        Integer credits = Integer.parseInt(request.getParameter("credits"));
        if (credits != null) {
            sub.setCredits(credits);
        }

// convert Java object Professor to Json object
        String jsonNewSubject = "";
        try {
            jsonNewSubject = gson.toJson(sub);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewSubject";
            response.getWriter().print(errorCreate);
        }
        response.getWriter().print(jsonNewSubject);

        PrintWriter out = response.getWriter();

    }

}



