package servlets;

import com.google.gson.Gson;
import dao.PeopleDAO;
import entity.Country;
import entity.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lytki on 14.04.2017.
 */
@WebServlet(name="/peoples", urlPatterns="/peoples")
public class PeoplesServlet extends HttpServlet {
    private static PeopleDAO peopleDAO = new PeopleDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<People> peoples = peopleDAO.getAllPeoples();
        Map<String,List<People>> c = new HashMap<>();
        c.put("peoples", peoples);
        Gson gson = new Gson();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String json = gson.toJson(c);
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action.equals("ADD")){
            String name = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            People people = new People();
            people.setFirstName(name);
            people.setLastName(lastName);
            peopleDAO.create(people);

        }else if(action.equals("UPDATE")){
            Gson gson = new Gson();
            String id = req.getParameter("people[id]");
            String name=req.getParameter("people[peopleName]");
            String lastName=req.getParameter("people[peopleLastName]");
            People people = new People();
            people.setId(Integer.parseInt(id));
            people.setFirstName(name);
            people.setLastName(lastName);

            peopleDAO.update(people);
        }else if(action.equals("DELETE")){
            String id=req.getParameter("id");
            peopleDAO.delete(Integer.parseInt(id));
        }
    }
}
