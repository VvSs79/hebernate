package service;

import DAO.api.IVoteDao;
import DTO.SaveInformationDTO;
import DTO.VoteDTO;
import service.api.IJenreService;
import service.api.ISingerService;
import service.api.IVoteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VoteService implements IVoteService {

    private final IVoteDao dao;
    private final ISingerService singerService;
    private final IJenreService jenreService;

    public VoteService(IVoteDao dao, ISingerService singerService, IJenreService jenreService) {
        this.dao = dao;
        this.singerService = singerService;
        this.jenreService = jenreService;
    }
    @Override
    public void save(VoteDTO vote) {
        this.validate(vote);
        SaveInformationDTO saveInformationDTO=new SaveInformationDTO(vote);
        this.dao.save(saveInformationDTO);
    }

    private void validate(VoteDTO vote){

        int singer= vote.getSingers();
        if (!this.singerService.exist(singer)|| singer<0)
            throw new IllegalArgumentException("Вы не выбрали не одного артиста");
        if (!Character.isDigit(singer)){
            throw new IllegalArgumentException("Некорректный выбор");
        }


        int[] jenres=vote.getJenres();
        if (jenres.length<0 || jenres==null){
            throw new IllegalArgumentException("Вы не выбрали ни одного жанра");
        }
        if (jenres.length< 3 || jenres.length > 5){
            throw new IllegalArgumentException("Количество выбранных жанров дожно быть 3 до 5");
        }
        for (int jenre:jenres )
            if (!this.jenreService.exist(jenre)){
                throw new IllegalArgumentException("Такого жанра:  " + jenre + " не существует");
            }
        Set<Integer> JenreName=new HashSet<>();
            for (int jenre:JenreName ) {
                JenreName.add(jenre);
            }
        if(jenres.length!=JenreName.size()){
            throw new IllegalArgumentException("Есть дублирующие друг друга жанры");
        }

        String information= vote.getInformation();
        if(information==null || information.length()==0||information.isBlank()){
            throw new IllegalArgumentException("Вы ни чего не ввели о себе");
        }
        if(information.length()==1){
            throw new IllegalArgumentException("Введите больше информации о себе");
        }
    }

    public List<SaveInformationDTO> get() {
        return this.dao.get();
    }
}


