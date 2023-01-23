package servlet;

import DAO.Impl.UniversityDAOImpl;
import DTO.UniversityDTO;
import com.google.gson.Gson;
import model.University;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/UniversityServlet")
public class UniversityServlet extends HttpServlet {

    private Gson gson = new Gson();
    private UniversityDAOImpl universityDAO;

    public void init() {
        universityDAO = new UniversityDAOImpl() {
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        try {

            if (request.getParameter("fullData") != null) {
                Boolean fullData = Boolean.parseBoolean(request.getParameter("fullData"));
                jsondtoUniversity(request, response, fullData);
            } else {

                switch (action) {

                    case "save":
                        saveUniversity(request, response);
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);

                        break;

                    case "delete":
                        if (request.getParameter("id") != null) {
                            University university = universityById(request, response);
                            //request.setAttribute("faculty", faculty);
                            deleteUniversity(request, response);
                            request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", " id dosen't exist so university can't be deleted");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;

                    case "update":
                        updateUniversity(request, response);
                        request.setAttribute("link", "http://localhost:8080/UniversityServlet?action=all");
                        request.getRequestDispatcher("jsp/successful.jsp").forward(request, response);
                        break;

                    case "all":

                        List<University> universitiesListfromMethod = allUniversitys(request, response);

                        if (request.getParameter("jsonFormat") != null) {
                            String universityJsonString = this.gson.toJson(universitiesListfromMethod);
                            PrintWriter pr = response.getWriter();
                            pr.print(universityJsonString);
                            pr.flush();

                        } else {
                            request.setAttribute("universityListfromJsp", universitiesListfromMethod);
                            request.getRequestDispatcher("jsp/universityList.jsp").forward(request, response);
                        }

                        break;

                    case "byId":
                        if (request.getParameter("id") != null) {
                            University university = universityById(request, response);

                            request.setAttribute("university", university);
                            request.getRequestDispatcher("jsp/universityById.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "missing id in query parametar");
                            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);

                        }

                        break;
                    case "new":
                        request.getRequestDispatcher("jsp/universityNew.jsp").forward(request, response);
                        break;
                    default:
                        getUniversity(request, response);
                        break;
                }
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<University> allUniversitys(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<University> universitiesHere = universityDAO.getAll();

        return universitiesHere;
    }

    private University universityById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        University university = universityDAO.getById(id);

        return university;

    }

    private void saveUniversity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        University university = new University(name, description);
        universityDAO.save(university);

    }

    private void updateUniversity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        University uni = universityDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            uni.setName(name);
        }
        String description = request.getParameter("description");
        if (description != null) {
            uni.setDescription(description);
        }

        universityDAO.update(uni);

    }

    private void deleteUniversity(HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        int id = Integer.parseInt(request.getParameter("id"));
        universityDAO.delete(id);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    private void jsondtoUniversity(HttpServletRequest request, HttpServletResponse response, boolean fullData)
            throws SQLException, Exception, IOException {


        Gson gson = new Gson();
        UniversityDAOImpl universityDAO = new UniversityDAOImpl();
        UniversityDTO universityDTO = new UniversityDTO();

        int uni_id = Integer.parseInt(request.getParameter("id"));

        if (fullData) {

            universityDTO = universityDAO.getUniversityDTOwithFac(uni_id);
        } else {

            universityDTO = universityDAO.getUniversityDTOwithOutFac(uni_id);

        }

        String jsonNewUni = "";
        try {
            jsonNewUni = gson.toJson(universityDTO);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewUni";
            response.getWriter().print(errorCreate);
        }

        response.getWriter().print(jsonNewUni);

    } //end of if fulldata

    private void getUniversity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        University university = universityDAO.getById(id);

        String name = request.getParameter("name");
        if (name != null) {
            university.setName(name);
        }
        String description = request.getParameter("description");
        if (description != null) {
            university.setDescription(description);
        }


// convert Java object Professor to Json object
        String jsonNewUni = "";
        try {
            jsonNewUni = gson.toJson(university);

        } catch (Exception e) {
            String errorCreate = "error in jsonNewUni";
            response.getWriter().print(errorCreate);
        }
        response.getWriter().print(jsonNewUni);

        PrintWriter out = response.getWriter();

    }

}



