package service.api;

import DTO.SaveInformationDTO;
import DTO.VoteDTO;

import java.util.List;

public interface IVoteService {
    void save(VoteDTO vote);
    public List<SaveInformationDTO> get();
}
