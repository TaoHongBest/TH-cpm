package com.taohong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author taohong on 2019-01-15
 */
public class CPM {
    private int tickNumBase = 5000; // Starting number of tickets. It increments 1 after a ticket is generated.
    private int emptyNum = 0; // Number of empty spaces in the car park
    private boolean isCompacted; // Boolean value indicates whether the park is compacted. TODO: alter unpark() to auto-update isCompacted
    private ArrayList<Space> cpmList = new ArrayList<>(); // List of ten spaces in the park
    private HashMap<String, Car> carMap = new HashMap<>(); // HashMap of cars
    private HashMap<Integer, Ticket> tickMap = new HashMap<>(); // HashMap of tickets

    /**
     * Constructor of CPM (Car Park Manager)
     */
    public CPM() {
        for (int i = 0; i < 10; i++) {
            cpmList.add(new Space(i));
            emptyNum++;
        }
        isCompacted = true;
    }

    // Accept instructions for parking, unparking & compacting
    public void accept(String str) {
        switch (str.charAt(0)) {
            case 'p':
                parkCar(str.substring(1));
                break;
            case 'u':
                unparkCar(str.substring(1));
                break;
            case 'c':
                compact();
                break;
            default:
        }
    }

    /**
     * This method parks the car if the given car is not parked here and there's a space still available.
     *
     * @param str The licence plate number of the given car
     */
    private void parkCar(String str) {
        // return if no more available space
        if (emptyNum < 1) {
//            System.out.println("No available space!");
            return;
        }

        // return if the give is still parked here
        if (carMap.containsKey(str) && carMap.get(str).isParkedHere()) {
//            System.out.println("Invalid Car Number: This car '" + str + "' has been parked here!");
            return;
        }

        // park the car, update tickets and spaces
        for (Space sp : cpmList) {
            if (!sp.isOccupied()) {
                sp.setOccupied(true);
                // If found an available space, generate a new ticket.
                int tickNum = tickNumBase++;
                int spaceNum = sp.getSpaceNum();
                Ticket tick = new Ticket(tickNum, str, spaceNum);

                if (!carMap.containsKey(str)) {
                    Car car = new Car(str, tickNum, spaceNum);
                    carMap.put(str, car);
                } else if (!carMap.get(str).isParkedHere()) {
                    carMap.get(str).setParkedHere(true);
                }

                // Put the ticket to the HashMap of tickets
                tickMap.put(tickNum, tick);
                sp.setCarNum(str);
                sp.setTickNum(tickNum);
                emptyNum--;
                break;
            }
        }
    }

    /**
     * This method unparks the car if car is parked here. And then let the space available again
     *
     * @param str the number of given ticket
     */
    private void unparkCar(String str) {
        Integer tickStrNum = Integer.parseInt(str);

        if (tickMap.containsKey(tickStrNum)) {
            Ticket tickTmp = tickMap.get(tickStrNum);

            // Remove the car associated with the given ticket from the car HashMap.
            carMap.remove(tickTmp.getCarNum());
            // Set the 'isOccupied' of the space to false, indicating the space is available again.
            cpmList.get((tickTmp).getSpaceNum()).setOccupied(false);
            // Remove the ticket from the HasHmap of tickets.
            tickMap.remove(tickStrNum);
            emptyNum++;
        } else {
//            System.out.println("Invalid Ticket Number: The ticket of given number '" + tickStrNum + "' dose not exist!");
        }
    }

    /**
     * This method compacts the fragmented spaces
     */
    private void compact() {
        isCompacted = false;
        int i = 0;
        while (!isCompacted) {
            if (!cpmList.get(i).isOccupied()) { // Find an empty space.
                boolean findOccupied = false;
                for (int j = i + 1; j < 10; j++) { // Traverse the rest spaces after the above empty space.
                    if (cpmList.get(j).isOccupied()) { // Find the first occupied space after above empty one.
                        Collections.swap(cpmList, i, j); // Swap the first occupied space and the above empty one.
                        updateSpaceCarTicket(i); // Call method to update space number in Space, Car and Ticket.
                        findOccupied = true;
                        i++;
                        break;
                    }
                }
                if (!findOccupied) isCompacted = true; // if findOccupied is false, it means the rest spaces are all empty.
            } else {
                i++;
            }
            if (i == 9) isCompacted = true;
        }
    }

    /**
     * This methods updates space number in Space, Car and Ticket after each swap
     *
     * @param i The new space number after compacting.
     */
    private void updateSpaceCarTicket(int i) {
        String carNum = cpmList.get(i).getCarNum();
        Integer tickNum = cpmList.get(i).getTickNum();
        cpmList.get(i).setSpaceNum(i);
        carMap.get(carNum).setSpaceNum(i);
        tickMap.get(tickNum).setSpaceNum(i);
    }

    /**
     * This method returns the result of given output form
     *
     * @return the string fo result
     */
    public String displayResult() {
        StringBuilder sb = new StringBuilder();
        for (Space sp : cpmList) {
            if (sp.isOccupied()) {
                sb.append(sp.getCarNum());
            }
            sb.append(",");
        }
        return sb.toString();
    }
}
