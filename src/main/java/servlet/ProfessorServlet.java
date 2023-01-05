package servlet;

import DAO.Impl.FacultyDAOImpl;
import DAO.Impl.ProfessorDAOImpl;
import DTO.FacultyDTO;
import DTO.ProfessorDTO;
import com.google.gson.Gson;
import model.Faculty;
import model.Professor;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {

    private Gson gson = new Gson();
    private ProfessorDAOImpl professorDAO;

    public void init() {
        professorDAO = new ProfessorDAOImpl() {
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {

            if(request.getParameter("fullData") != null){
                Boolean fullData = Boolean.parseBoolean(request.getParameter("fullData"));
                jsondtoprofessor(request, response, fullData);
            } else{

                switch (action) {

                    case "save":
                        saveProfessor(request, response);
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request , response);

                        break;

                    case "delete":
                        if(request.getParameter("id") != null){
                            //request.setAttribute("faculty", faculty);
                            deleteProfessor(request, response);
                            request.setAttribute("link","http://localhost:8080/ProfessorServlet?action=all");
                            request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message"," id dosen't exist so professor can't be deleted");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);

                        }
                        break;

                    case "update":
                        updateProfessor(request, response);
                        request.setAttribute("link","http://localhost:8080/ProfessorServlet?action=all");
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request , response);
                        break;

                    case "all":

                        List<Professor> professorsListfromMethod = allProfessors(request, response);

                        if(request.getParameter("jsonFormat" ) != null) {
                            String professorJsonString = this.gson.toJson(professorsListfromMethod);
                            PrintWriter pr = response.getWriter();
                            pr.print(professorJsonString);
                            pr.flush();

                        } else {
                            request.setAttribute("professorListfromJsp", professorsListfromMethod);
                            request.getRequestDispatcher("jsp/professorList.jsp").forward(request , response);
                        }

                        break;

                    case "byId":
                        if(request.getParameter("id") != null){
                            Professor professor =  professorById(request,response);
                            request.setAttribute("professor", professor);
                            request.getRequestDispatcher("jsp/professorById.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message","missing id in query parametar");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);

                        }

                        break;
                    case "new":
                        request.getRequestDispatcher("jsp/professorNew.jsp").forward(request, response);
                        break;
                    default:
                        getProfessor(request, response);
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
    private List<Professor> allProfessors(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Professor> professorsList = professorDAO.getAll();
      /*  List<Professor> professorsHere = professorDAO.getAll();
        String professorJsonString = this.gson.toJson(professorsHere);
        PrintWriter pr = response.getWriter();
        pr.print(professorJsonString);
        pr.flush();*/
        return professorsList;
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
            dispatcher.forward(request, response);*/
    }

    private Professor professorById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Professor professor = professorDAO.getById(id);
       /* String facultyJsonString = this.gson.toJson(faculty);
        PrintWriter pr = response.getWriter();
        pr.print(facultyJsonString);
        pr.flush();*/
        return professor;

    }

    private void saveProfessor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {


        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String primary_subject1 = request.getParameter("primary_subject1");
        String primary_subject2 = request.getParameter("primary_subject2");
        Professor professor = new Professor( name, surname, age, primary_subject1, primary_subject2);
        professorDAO.save(professor);
       // response.sendRedirect("list");
    }

    private void updateProfessor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
   /*     int id = Integer.parseInt(request.getParameter("id"));
        Professor prof = professorDAO.getById(id);


        if(request.getParameter("age") != null){
            Integer age = Integer.parseInt(request.getParameter("age"));
            prof.setAge(age);
        }
        String name = request.getParameter("name");
        if(name != null){
            prof.setName(name);
        }
        String surname = request.getParameter("surname");
        if(surname != null){
            prof.setSurname(surname);
        }
        String primary_subject1 = request.getParameter("primary_subject1");
        if(primary_subject1 != null){
            prof.setPrimary_subject1(primary_subject1);
        }
        String primary_subject2 = request.getParameter("primary_subject2");
        if(primary_subject2 != null){
            prof.setPrimary_subject2(primary_subject2);
        }

        //Professor professor = new Professor(id, name, surname, age, primary_subject1, primary_subject2);
        professorDAO.update(prof);
        PrintWriter out = response.getWriter();

        out.println("<p>successfully updated</p>");
        //response.sendRedirect("/");*/

        int id = Integer.parseInt(request.getParameter("id"));
        Professor prof = professorDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            prof.setName(name);
        }
        String surname = request.getParameter("surname");
        if (surname != null) {
            prof.setSurname(surname);
        }

        String primary_subject1 = request.getParameter("primary_subject1");
        if (primary_subject1 != null) {
            prof.setPrimary_subject1(primary_subject1);
        }

        String primary_subject2 = request.getParameter("primary_subject2");
        if (primary_subject2!= null) {
            prof.setPrimary_subject2(primary_subject2);
        }

        //proveri dali e vaka za age
        String profesorAge = request.getParameter("age");
        if(profesorAge!= null){
            int age = Integer.parseInt(profesorAge);
            prof.setAge(age);
        }
        professorDAO.update(prof);
    }

    private void deleteProfessor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        professorDAO.delete(id);
       // response.sendRedirect("list");

    }

    private void createProfessor(HttpServletRequest request,HttpServletResponse response) throws ServletException,Exception,IOException{

        Gson gson = new Gson();
        ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();
        Professor professor = new Professor();
        //response.setContentType("application/json");

        if(request.getParameter("id")!= null){
            String profesorID = request.getParameter("id");
            int id = Integer.parseInt(profesorID);
            professor.setId(id);
        }
        if(request.getParameter("age")!= null){
            String profesorAge = request.getParameter("age");
            int age = Integer.parseInt(profesorAge);
            professor.setAge(age);
        }
        if(request.getParameter("name")!= null){
            String name = request.getParameter("name");
            professor.setName(name);
        }
        if(request.getParameter("surname")!= null){
            String surname = request.getParameter("surname");
            professor.setSurname(surname);
        }
        if(request.getParameter("primary_subject1")!= null){
            String primary_subject1 = request.getParameter("primary_subject1");
            professor.setSurname(primary_subject1);
        }
        if(request.getParameter("primary_subject2")!= null){
            String primary_subject2 = request.getParameter("primary_subject2");
            professor.setSurname(primary_subject2);
        }

        // convert Java object Professor to Json object
        try{
            String jsonNewProfessor = gson.toJson(professor);
            professorDAO.save(professor);
            response.getWriter().print(jsonNewProfessor);

        }
        catch(Exception e){
            String errorCreate = "error in professorDAO.save try";
            response.getWriter().print(errorCreate);
        }

        PrintWriter pwout = response.getWriter();
        pwout.println("<p>TestingCreateMethodInWebServletProfessor!</p>");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
    private void jsondtoprofessor(HttpServletRequest request, HttpServletResponse response,boolean fullData)
            throws SQLException, Exception, IOException {


        Gson gson = new Gson();
        ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();
        ProfessorDTO professorDTO = new ProfessorDTO();
        //response.setContentType("application/json");
        int professor_id = Integer.parseInt(request.getParameter("id" ));

        if(fullData) {

            professorDTO = professorDAO.getProfessorDTOwithFac(professor_id);
        }else{

            professorDTO = professorDAO.getProfessorDTOwithOutFac(professor_id);

        }

        String jsonNewProfessor = "";
        try {
            jsonNewProfessor = gson.toJson(professorDTO);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewProfessor";
            response.getWriter().print(errorCreate);
        }

        response.getWriter().print(jsonNewProfessor);

    } //end of if fulldata

    private void getProfessor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Professor prof = professorDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            prof.setName(name);
        }

        String surname = request.getParameter("surname");
        if (surname != null) {
            prof.setSurname(surname);
        }

        String primary_subject1 = request.getParameter("primary_subject1");
        if (primary_subject1 != null) {
            prof.setPrimary_subject1(primary_subject1);
        }
        String primary_subject2 = request.getParameter("primary_subject2");
        if (primary_subject2 != null) {
            prof.setPrimary_subject2(primary_subject2);
        }

        Integer age = Integer.parseInt(request.getParameter("age"));
        if (age != null) {
            prof.setAge(age);
        }

// convert Java object Professor to Json object
        String jsonNewProfessor = "";
        try {
            jsonNewProfessor = gson.toJson(prof);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewProfessor";
            response.getWriter().print(errorCreate);
        }
        response.getWriter().print(jsonNewProfessor);

        PrintWriter out = response.getWriter();

    }

}



