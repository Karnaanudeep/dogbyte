package org.example.service;

import org.example.dao.VictimDAO;
import org.example.dao.VictimDaoImp;
import org.example.model.VictimPojo;

import java.util.List;

public class VictimServiceImp implements VictimService{
    private VictimDAO victimDAO;

    public VictimServiceImp(){
        victimDAO = new VictimDaoImp();
    }

    @Override
    public List<VictimPojo> fetchAllVictims() {
        List<VictimPojo> list = victimDAO.fetchAllVictims();
        return list;
    }

    @Override
    public List<VictimPojo> fetchAVictim(int victimAge) {
        List<VictimPojo> list = victimDAO.fetchAVictim(victimAge);
        return list;
    }

    @Override
    public List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated) {
        List<VictimPojo> list = victimDAO.fetchByVaccinatedStatus(isVaccinated);
        return list;
    }

    @Override
    public void removeById(int id) {
        victimDAO.removeById(id);

    }

    @Override
    public VictimPojo addVictim(VictimPojo newVictim) {
        VictimPojo victimPojo = victimDAO.addVictim(newVictim);
        return victimPojo;
    }

    @Override
    public VictimPojo updateVictim(int id, VictimPojo victimPojo) {
        VictimPojo victimPojo1 = victimDAO.updateVictim(id,victimPojo);
        return victimPojo1;
    }

    @Override
    public String getName() {
        return victimDAO.getName();

    }
}
