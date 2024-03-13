package org.example.dao;

import org.example.entity.VictimPojo;

import java.util.List;
import java.util.Optional;

public interface VictimDAO {
    List<VictimPojo> fetchAllVictims();
    List<VictimPojo> fetchAVictim(int victimAge);
    List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated);
    void removeById(int id);
    VictimPojo addVictim(VictimPojo newVictim);
    VictimPojo updateVictim(int id , VictimPojo victimPojo);

}
