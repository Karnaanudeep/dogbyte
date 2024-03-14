package org.example.dao;

import org.example.model.VictimPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VictimDaoImp implements VictimDAO{
    private Connection connection ;

    public VictimDaoImp(){
        connection = DBConnection.getDBConnection();
    }



    @Override
    public List<VictimPojo> fetchAllVictims() {
        List<VictimPojo> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                list.add(victimPojo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<VictimPojo> fetchAVictim(int victimAge) {
         List<VictimPojo> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_BY_AGE);
            preparedStatement.setInt(1,victimAge);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                list.add(victimPojo);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated) {
        List<VictimPojo> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_BY_STATUS);
            preparedStatement.setBoolean(1,isVaccinated);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                list.add(victimPojo);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return list;

    }

    @Override
    public void removeById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_DELETE);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("VICTIM DELETED");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public VictimPojo addVictim(VictimPojo victimPojo) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_ADD);
            System.out.println(victimPojo);
            preparedStatement.setString(1,victimPojo.getName());
            preparedStatement.setInt(2,victimPojo.getAge());
            preparedStatement.setString(3, victimPojo.getDogBreed());
            preparedStatement.setBoolean(4,victimPojo.getDogVaccinatedStatus());
            preparedStatement.setString(5,victimPojo.getAddress());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("SUCESS");
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return  victimPojo;
    }

    @Override
    public VictimPojo updateVictim(int id, VictimPojo victimPojo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_UPDATE);
            preparedStatement.setString(1, victimPojo.getName());
            preparedStatement.setInt(2, victimPojo.getAge());
            preparedStatement.setString(3, victimPojo.getDogBreed());
            preparedStatement.setBoolean(4, victimPojo.getDogVaccinatedStatus());
            preparedStatement.setString(5, victimPojo.getAddress());
            preparedStatement.setInt(6, id);
            int result = preparedStatement.executeUpdate();
            if (result > 1) {
                System.out.println("SUCESSFULLY UPDATED");
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }


        return victimPojo;
    }

    @Override
    public String getName() {
        return "Venkatesh";
    }
}
