package DTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class SaveInformationDTO {
    private LocalDateTime ldtInit;
    private VoteDTO vote;


    public SaveInformationDTO(VoteDTO vote){
        this.ldtInit = LocalDateTime.now();
        this.vote = vote;
    }

    public LocalDateTime getLdtInit() {
        return ldtInit;
    }

    public VoteDTO getVote() {
        return vote;
    }

    public void setLdtInit(LocalDateTime ldtInit) {
        this.ldtInit = ldtInit;
    }

    public void setVote(VoteDTO vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveInformationDTO that = (SaveInformationDTO) o;
        return Objects.equals(ldtInit, that.ldtInit) && Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ldtInit, vote);
    }

    @Override
    public String toString() {
        return "SaveInformationDTO{" +
                "ldtInit=" + ldtInit +
                ", vote=" + vote +
                '}';
    }
}
