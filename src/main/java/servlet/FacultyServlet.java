package servlet;

import DAO.Impl.FacultyDAOImpl;
import DAO.FacultyDAO;
import DTO.FacultyDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Faculty;
import service.FacultyService;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {

    private Gson gson = new Gson();

    private FacultyService facultyService;
    private FacultyDAOImpl facultyDAO;

    public void init() {
        facultyDAO = new FacultyDAOImpl() {
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            // Boolean.parseBoolean(request.getParameter("fullData"));
            //String jsondtofaculty = request.getParameter("jsondtofaculty");

            if (request.getParameter("fullData") != null) {
                Boolean fullData = Boolean.parseBoolean(request.getParameter("fullData"));
                jsondtofaculty(request, response, fullData);
            } else {

                switch (action) {

                    case "save":
                        saveFaculty(request, response);
                        request.setAttribute("link", "http://localhost:8080/FacultyServlet?action=all");
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);

                        break;

                    case "delete":
                        if (request.getParameter("id") != null) {
                            //request.setAttribute("faculty", faculty);
                            deleteFaculty(request, response);
                            request.setAttribute("link", "http://localhost:8080/FacultyServlet?action=all");
                            request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", " id dosen't exist so faculty can't be deleted");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;

                    case "update":
                        updateFaculty(request, response);
                        request.setAttribute("link", "http://localhost:8080/FacultyServlet?action=all");
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        break;

                    case "all":

                        List<Faculty> facultiesListfromMethod = allFaculties(request, response);

                        if (request.getParameter("jsonFormat") != null) {
                            String facultyJsonString = this.gson.toJson(facultiesListfromMethod);
                            PrintWriter pr = response.getWriter();
                            pr.print(facultyJsonString);
                            pr.flush();

                        } else {
                            request.setAttribute("facultyListfromJsp", facultiesListfromMethod);//komunikacija jsp so servlet
                            request.getRequestDispatcher("jsp/facultyList.jsp").forward(request, response);
                        }

                        break;

                    case "byId":
                        if (request.getParameter("id") != null) {
                            Faculty faculty = facultyById(request, response);// prva linija
                            //request.getRequestDispatcher("jsp/facultyDetails.jsp").forward(request , response);
                            // primer spojuvanje na edinechen fakultet od metodot so onoj fakultet od JSP
                            // stringot "faculty" doagja od JSP
                            request.setAttribute("faculty", faculty);
                            request.getRequestDispatcher("jsp/facultyById.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "missing id in query parametar");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;
                    case "new":
                        request.getRequestDispatcher("jsp/facultyNew.jsp").forward(request, response);
                        break;
                    default:
                        getFaculty(request, response);
                        break;
                }
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Faculty> allFaculties(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Faculty> facultiesList = facultyDAO.getAll(); // only the left part
        // JSON part
        /*
        String facultyJsonString = this.gson.toJson(facultiesHere);
        PrintWriter pr = response.getWriter();
        pr.print(facultyJsonString);
        pr.flush();
         */
        //now we have to connect word facultiesHere(this list) with the list in JSP file
        return facultiesList;
    }

    private Faculty facultyById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Faculty faculty = facultyDAO.getById(id);
       /* String facultyJsonString = this.gson.toJson(faculty);
        PrintWriter pr = response.getWriter();
        pr.print(facultyJsonString);
        pr.flush();*/
        return faculty;

    }

    private void saveFaculty(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String study_field = request.getParameter("study_field");
        Faculty faculty = new Faculty(name, location, study_field);
        facultyDAO.save(faculty);
        //response.sendRedirect("Indeks");
    }

    private void updateFaculty(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        Faculty fac = facultyDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            fac.setName(name);
        }
        String location = request.getParameter("location");
        if (location != null) {
            fac.setLocation(location);
        }
        String study_field = request.getParameter("study_field");
        if (study_field != null) {
            fac.setStudy_field(study_field);
        }

        facultyDAO.update(fac);
    }

    private void deleteFaculty(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        facultyDAO.delete(id);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    private void jsondtofaculty(HttpServletRequest request, HttpServletResponse response, boolean fullData)
            throws SQLException, Exception, IOException {


        Gson gson = new Gson();
        FacultyDAOImpl facultyDAO = new FacultyDAOImpl();
        FacultyDTO facultyDTO = new FacultyDTO();
        //response.setContentType("application/json");
        int faculty_id = Integer.parseInt(request.getParameter("id"));

        if (fullData) {
            //Query Faculty + university name
            //facultyDTO = dao.getSoUniv(id)
            facultyDTO = facultyDAO.getFacultyDTOwithUni(faculty_id);
        } else {
            // Query only Faculty
            ////facultyDTO = dao.getFaculty(id)
            facultyDTO = facultyDAO.getFacultyDTOwithOutUni(faculty_id);

        }

        String jsonNewFaculty = "";
        try {
            jsonNewFaculty = gson.toJson(facultyDTO);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewFaculty";
            response.getWriter().print(errorCreate);
        }

        response.getWriter().print(jsonNewFaculty);

    } //end of fulldata

    private void getFaculty(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Faculty fac = facultyDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            fac.setName(name);
        }
        String location = request.getParameter("location");
        if (location != null) {
            fac.setLocation(location);
        }
        String study_field = request.getParameter("study_field");
        if (study_field != null) {
            fac.setStudy_field(study_field);
        }

// convert Java object Professor to Json object
        String jsonNewFaculty = "";
        try {
            jsonNewFaculty = gson.toJson(fac);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewFaculty";
            response.getWriter().print(errorCreate);
        }
        response.getWriter().print(jsonNewFaculty);

        PrintWriter out = response.getWriter();

    }
}



