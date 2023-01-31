package Controllers;

import DTO.VoteDTO;
import service.VoteService;
import service.fabric.VoteServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet (name="VoteServle", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final String Singer_PARAM_NAME="singerName";
    private final String Jenre_PARAM_NAME ="jenreName";
    private final String Information_PARAM_NAME="information";
    private final VoteService voteService;

    public VoteServlet() {
        this.voteService = VoteServiceSingleton.getInstance();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("txt/html; charset=UTF8");

        Map<String, String[]> mpReq=req.getParameterMap();

        String[] Singers=mpReq.get(Singer_PARAM_NAME);
        String[] JenreRAW=mpReq.get(Jenre_PARAM_NAME);
        String[] information=mpReq.get(Information_PARAM_NAME);

        String SingerRAW=(Singers==null)? null:Singers[0];
        String informationRAW= (information==null)? null: information[0];
        int Singer=Integer.parseInt(SingerRAW);
        if(SingerRAW==null){
            throw new IllegalArgumentException(" Вы не выбрали ни одного артиста");
        }
        if(Singers.length<1){
            throw new IllegalArgumentException("Выбирите только одного исполнителя");
        }

        VoteDTO.VoteDTOBuilder builder=VoteDTO.VoteDTOBuilder.init()
                .setSingers(Singer)
                .setInformation(informationRAW);
        for (String jenre:JenreRAW){
            builder.addJenres(Integer.parseInt(jenre));
        }
        this.voteService.save(builder.build());
    }
}



