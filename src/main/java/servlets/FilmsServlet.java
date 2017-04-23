package servlets;

import com.google.gson.Gson;
import dao.FilmDAO;
import entity.Film;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Lytki on 20.04.2017.
 */
@WebServlet(name="/films", urlPatterns="/films")
public class FilmsServlet extends HttpServlet {
    private FilmDAO filmDAO = new FilmDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        if(id!=null){
             filmDAO = new FilmDAO();
            Film film = (Film) filmDAO.read(Integer.parseInt(id));
            Gson gson = new Gson();
            String result = gson.toJson(film);
            PrintWriter out = resp.getWriter();
            out.print(result);
            out.flush();
            out.close();

        }
        else{
            List<Film> films = filmDAO.getAllFilms();
            Gson gson = new Gson();
            String result = gson.toJson(films);
            PrintWriter out = resp.getWriter();
            out.print(result);
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        Gson gson = new Gson();
        if(action.equals("ADD")){
            String teststr=req.getParameter("producers");
            String title = req.getParameter("title");
            int releaseDate = Integer.parseInt(req.getParameter("release"));
            int raiting = Integer.parseInt(req.getParameter("raiting"));
            String description = req.getParameter("description");
            String trailerUrl = req.getParameter("url");
            int[] genresIds = gson.fromJson(req.getParameter("genres"), int[].class);
            int[] actorsIds = gson.fromJson(req.getParameter("actors"), int[].class);
            int[] producersIds = gson.fromJson(req.getParameter("producers"), int[].class);
            int[] countriesIds = gson.fromJson(req.getParameter("countries"), int[].class);


            Film film = new Film();
            film.setTitle(title);
            film.setReleaseDate(releaseDate);
            film.setRaiting(raiting);
            film.setDescription(description);
            film.setTrailerUrl(trailerUrl);

            film = (Film) filmDAO.create(film);

            filmDAO.insertPeoplesById(film.getId(),producersIds,FilmDAO.PRODUCER_ALIAS);
            filmDAO.insertPeoplesById(film.getId(),actorsIds,FilmDAO.ACTOR_ALIAS);
            filmDAO.insertCountriesById(film.getId(),countriesIds);
            filmDAO.insertGenresById(film.getId(),genresIds);

            PrintWriter out = resp.getWriter();
            out.print(film.getId());
            out.flush();
            out.close();
        }else if(action.equals("UPDATE")){

            int id= Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            int releaseDate = Integer.parseInt(req.getParameter("release"));
            int raiting = Integer.parseInt(req.getParameter("raiting"));
            String description = req.getParameter("description");
            String trailerUrl = req.getParameter("url");
            int[] genresIds = gson.fromJson(req.getParameter("genres"), int[].class);
            int[] actorsIds = gson.fromJson(req.getParameter("actors"), int[].class);
            int[] producersIds = gson.fromJson(req.getParameter("producers"), int[].class);
            int[] countriesIds = gson.fromJson(req.getParameter("countries"), int[].class);


            Film film = new Film();
            film.setId(id);
            film.setTitle(title);
            film.setReleaseDate(releaseDate);
            film.setRaiting(raiting);
            film.setDescription(description);
            film.setTrailerUrl(trailerUrl);

//            film = (Film) filmDAO.create(film);

            filmDAO.update(film);
            if(countriesIds.length>0){
                filmDAO.deleteCountriesById(id);
                filmDAO.insertCountriesById(film.getId(),countriesIds);
            }
            if(genresIds.length>0){
                filmDAO.deleteGenresById(id);
                filmDAO.insertGenresById(film.getId(),genresIds);
            }
            if(actorsIds.length>0){
                filmDAO.deletePeoplesById(id, FilmDAO.ACTOR_ALIAS);
                filmDAO.insertPeoplesById(film.getId(),actorsIds,FilmDAO.ACTOR_ALIAS);
            }
            if(producersIds.length>0){
                filmDAO.deletePeoplesById(id, FilmDAO.PRODUCER_ALIAS);
                filmDAO.insertPeoplesById(film.getId(),producersIds,FilmDAO.PRODUCER_ALIAS);
            }
            PrintWriter out = resp.getWriter();
            out.print(film.getId());
            out.flush();
            out.close();

        }
        else if(action.equals("DELETE")){
            int id = Integer.parseInt(req.getParameter("id"));
            filmDAO.delete(id);

        }

    }
}
