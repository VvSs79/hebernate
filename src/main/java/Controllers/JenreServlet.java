package Controllers;

import DTO.Jenre;
import service.api.IJenreService;
import service.fabric.JenreServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name="JenreServlet", urlPatterns = "/Jenre")
public class JenreServlet extends HttpServlet {
    private final IJenreService jenreService;

    public JenreServlet() {
        this.jenreService = JenreServiceSingleton.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("URF-8");
        resp.setContentType("txt/html; charset=UTF-8");
        List<Jenre> jenreDTOS=jenreService.get();
        PrintWriter writer =resp.getWriter();
        for(Jenre jenreDTO:jenreDTOS){
            writer.write("<p>" + jenreDTO.getIdJenre()+" : " +jenreDTO.getJenreName() + "</p>");
        }
    }
}
