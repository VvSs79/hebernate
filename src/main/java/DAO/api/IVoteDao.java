package DAO.api;

import DTO.SaveInformationDTO;

import java.util.List;

public interface IVoteDao {
    void save(SaveInformationDTO vote);
    public List<SaveInformationDTO> get();
}
