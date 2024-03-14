package org.example.controller;

import org.example.model.VictimPojo;
import org.example.presentation.Presentation;
import org.example.service.VictimService;
import org.example.service.VictimServiceImp;

import java.util.List;

public class VictimController {
    private VictimService victimService;
    public VictimController(){
        victimService = new VictimServiceImp();
    }
    public void start() {

        // will call the display menu for books
        while(true) {
            int option = Presentation.displayMenu();
            // depending on the menu option selected, controller will call the respective method of service
            switch(option) {
                case 1:
                    List<VictimPojo> allBooks = victimService.fetchAllVictims();
                    Presentation.displayAllVictims(allBooks);
                    break;
                case 2:
                    // get age as input from the user - ask the presentation layer to do it
                    int age = Presentation.scanAge();
                    // then call victimService.fetchABook
                    List<VictimPojo> allVictims = victimService.fetchAVictim(age);
                    if(allVictims.isEmpty()) {
                        System.out.println("There are no victims");

                    }else {
                        for (VictimPojo allVictim : allVictims) {
                            Presentation.disPlayVictim(allVictim);

                        }
                    }
                    break;
                case 3:
                    // get the status as input from the user
                    boolean status = Presentation.scanStatus();
                    // fetch books by genre
                    List<VictimPojo> victims = victimService.fetchByVaccinatedStatus(status);
                    // send the collection to be displayed in presentation
                    if(victims.isEmpty()) {
                        System.out.println("There are no victims");

                    }else {
                        for (VictimPojo allVictim : victims) {
                            Presentation.disPlayVictim(allVictim);

                        }
                    }
                    break;
                case 4:
                    VictimPojo victimPojo = Presentation.addVictim();
                    VictimPojo victimPojo1 = victimService.addVictim(victimPojo);
                    Presentation.disPlayVictim(victimPojo1);
                    break;
                case 5:
                    int id = Presentation.scanId();
                    VictimPojo victimPojo2 = Presentation.addVictim();
                    VictimPojo victimPojo3 = victimService.updateVictim(id,victimPojo2);
                    Presentation.disPlayVictim(victimPojo3);
                    break;

                case 6:
                    int vId = Presentation.scanId();
                    victimService.removeById(vId);
                    break;
                case 7:
                    Presentation.displayExitMessage();
                    System.exit(0);
                default:
                    Presentation.displayInvalidOptionMessage();

            }

        }

    }



}
