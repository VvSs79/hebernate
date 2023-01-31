package DTO;

public class StatisticDTO {
    private final VoteDTO vtDTO;
    private final int countSinger;
    private final int countJenre;

    public StatisticDTO(VoteDTO vtDTO, int countSinger, int countJenre) {
        this.vtDTO = vtDTO;
        this.countSinger = 0;
        this.countJenre = 0;
    }

    public VoteDTO getVtDTO() {
        return vtDTO;
    }

    public int getCountSinger() {
        return countSinger;
    }

    public int getCountJenre() {
        return countJenre;
    }

    public void addCountSinger(int countSinger){
        countSinger++;
    }
    public void addCountJenre(int countJenre){
        countJenre++;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "vtDTO=" + vtDTO +
                ", количество голосов за данного исполнителя: " + countSinger +
                ", количество госов по данному жанру: " + countJenre +
                '}';
    }
}
