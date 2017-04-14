package servlets;

import com.google.gson.Gson;
import dao.CountryDAO;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Lytki on 14.04.2017.
 */
@WebServlet(name="/countries", urlPatterns="/countries")
public class CountriesServlet extends HttpServlet{
    private static final CountryDAO countryDAO = new CountryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countries = countryDAO.getAllCountries();
        Map<String,List<Country>> c = new HashMap<>();
        c.put("countries", countries);
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
            String countryName = req.getParameter("countryName");
            countryDAO.create(new Country(countryName));

        }else if(action.equals("UPDATE")){
            Gson gson = new Gson();
            String countryId = req.getParameter("country[id]");
            String countryName=req.getParameter("country[countryName]");
           Country country = new Country(countryName);
            country.setId(Integer.parseInt(countryId));
            countryDAO.update(country);
        }else if(action.equals("DELETE")){
            String id=req.getParameter("id");
            countryDAO.delete(Integer.parseInt(id));
        }
    }

}
