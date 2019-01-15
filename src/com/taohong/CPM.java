package com.taohong;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author taohong on 2019-01-15
 */
public class CPM {
    int tickNumBase = 5000;
    int emptyNum = 0;
    ArrayList<Space> cpmList = new ArrayList<>();
    HashMap<String, Car> carMap = new HashMap<>();
    HashMap<Integer, Ticket> tickMap = new HashMap<>();


    public CPM() {
        for (int i = 0; i < 10; i++) {
            cpmList.add(new Space(i));
            emptyNum++;
        }
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
            System.out.println("No available space!");
            return;
        }

        // return if the give is still parked here
        if (carMap.containsKey(str) && carMap.get(str).isParkedHere) {
            System.out.println("Invalid Car Number: This car '" + str + "' has been parked here!");
            return;
        }

        // park the car, update tickets and spaces
        for (Space sp : cpmList) {
            if (!sp.isOccupied) {
                sp.occupySpace();
                int tickNum = tickNumBase++;
                int spaceNum = sp.getSpaceNum();
                Ticket tick = new Ticket(tickNum, str, spaceNum);

                if (!carMap.containsKey(str)) {
                    Car car = new Car(str, tickNum, spaceNum);
                    carMap.put(str, car);
                } else if (!carMap.get(str).isParkedHere) {
                    carMap.get(str).isParkedHere = true;
                }

                tickMap.put(tickNum, tick);
                sp.setCarNum(str);
                sp.setTicketNum(spaceNum);
                sp.isOccupied = true;
                emptyNum--;
                break;
            }
        }
    }

    /**
     * This method unpark the car if car is parked here. And then let the space available again
     *
     * @param str the number of given ticket
     */
    private void unparkCar(String str) {
        Integer tickStrNum = Integer.parseInt(str);
        if (tickMap.containsKey(tickStrNum)) {
            carMap.remove(tickMap.get(tickStrNum).getCarNum());
            cpmList.get(tickMap.get(tickStrNum).spaceNum).isOccupied = false;
            tickMap.remove(tickStrNum);
        } else {
            System.out.println("Invalid Ticket Number: The ticket of given number '" + tickStrNum + "' dose not exist!");
        }
    }

    private void compact() {

    }

    /**
     * This method return the result of given output form
     *
     * @return the string fo result
     */
    public String displayResult() {
        StringBuilder sb = new StringBuilder();
        for (Space sp : cpmList) {
            if (sp.isOccupied) {
                sb.append(sp.getCarNum());
            }
            sb.append(",");
        }

        return sb.toString();
    }
}
