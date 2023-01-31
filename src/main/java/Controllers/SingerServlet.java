package Controllers;

import DTO.Singer;
import service.api.ISingerService;
import service.fabric.SingerServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="SingerServlet", urlPatterns = "/Singer")
public class SingerServlet extends HttpServlet {
    private final ISingerService singerService;

    public SingerServlet() {

       this.singerService = SingerServiceSingleton.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("txt/html; charset=UTF-8");
        List <Singer> singerDTOS=singerService.get(0);
        PrintWriter writer =resp.getWriter();
        for ( Singer singerDTO:singerDTOS) {
            writer.write("<p>" +singerDTO.getIdSinger()+" : "+ singerDTO.getSingerName() +  "</p>");
        }
    }
}
