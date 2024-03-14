package org.example.service;

import org.example.model.VictimPojo;

import java.util.List;

public interface VictimService {
    List<VictimPojo> fetchAllVictims();
    List<VictimPojo> fetchAVictim(int victimAge);
    List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated);
    void removeById(int id);
    VictimPojo addVictim(VictimPojo newVictim);
    VictimPojo updateVictim(int id , VictimPojo victimPojo);
    String getName();
}
