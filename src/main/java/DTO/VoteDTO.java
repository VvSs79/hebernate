package DTO;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private int Singers;
    private int[] Jenres;
    private  String Information;

    public VoteDTO(int idSingers, int[] idJenres, String Information) {
        this.Singers = idSingers;
        this.Jenres = idJenres;
        this.Information = Information;
    }
    public int getSingers() {
        return Singers;
    }
    public int[] getJenres() {
        return Jenres;
    }

    public String getInformation() {
        return Information;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return Singers == voteDTO.Singers && Arrays.equals(Jenres, voteDTO.Jenres) && Objects.equals(Information, voteDTO.Information);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(Singers, Information);
        result = 31 * result + Arrays.hashCode(Jenres);
        return result;
    }
    @Override
    public String toString() {
        return "VoteDTO{" +
                "Singers: " + Singers +
                ", Jenres: " + Arrays.toString(Jenres) +
                ", Information: ='" + Information + '\'' +
                '}';
    }
    public static class VoteDTOBuilder{
        private  int Singers;
        private int[] Jenres=new int[0];
        private  String Information;
        private String mail;

        public VoteDTOBuilder(int singers, int[] jenres, String information, String mail) {
            Singers = singers;
            Jenres = jenres;
            Information = information;
            this.mail = mail;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        private VoteDTOBuilder(){
        }
        public static VoteDTOBuilder init(){
            return new VoteDTOBuilder();
        }

        public VoteDTOBuilder setSingers(int singers) {
            this.Singers = singers;
            return this;
        }

        public VoteDTOBuilder setJenres(int[] jenres) {
            this.Jenres = jenres;
            return this;
        }
        public VoteDTOBuilder addJenres(int  jenres){
            this.Jenres=Arrays.copyOf(this.Jenres, this.Jenres.length+1);
            this.Jenres[this.Jenres.length-1]=jenres;
            return this;
        }

        public VoteDTOBuilder setInformation(String Information) {
            this.Information = Information;
            return this;
        }

        public VoteDTO build(){
            return new VoteDTO(Singers,Jenres,Information);
        }
    }

}
