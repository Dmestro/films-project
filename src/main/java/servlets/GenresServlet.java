package servlets;

import com.google.gson.Gson;
import dao.GenreDAO;
import entity.Country;
import entity.Genre;
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
 * Created by Lytki on 15.04.2017.
 */
@WebServlet(name="/genres", urlPatterns="/genres")
public class GenresServlet extends HttpServlet {
    GenreDAO genreDAO = new GenreDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Genre> genres = genreDAO.getAllGenres();
        Map<String,List<Genre>> c = new HashMap<>();
        c.put("genres", genres);
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
            String genreName = req.getParameter("genreName");
            Genre genre = new Genre();
            genre.setName(genreName);
            genreDAO.create(genre);

        }else if(action.equals("UPDATE")){
            Gson gson = new Gson();
            String id = req.getParameter("genre[id]");
            String name=req.getParameter("genre[name]");
            Genre genre = new Genre();
            genre.setName(name);
            genre.setId(Integer.parseInt(id));
            genreDAO.update(genre);
        }else if(action.equals("DELETE")){
            String id=req.getParameter("id");
            genreDAO.delete(Integer.parseInt(id));
        }
    }
}
