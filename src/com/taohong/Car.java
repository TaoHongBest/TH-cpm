package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Car {
    private String carNum;
    private int spaceNum;
    private int ticketNum;
    private boolean isParkedHere;

    /**
     * Constructor for Car
     *
     * @param carNum    The license plate number of the give car.
     * @param ticketNum The ticket number of the parking
     * @param spaceNum  The number of space where the car is parking
     */
    public Car(String carNum, int ticketNum, int spaceNum) {
        this.carNum = carNum;
        this.ticketNum = ticketNum;
        this.spaceNum = spaceNum;
        isParkedHere = true;
    }


    public String getCarNum() {
        return carNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public boolean isParkedHere() {
        return isParkedHere;
    }

    public void setParkedHere(boolean parkedHere) {
        isParkedHere = parkedHere;
    }
}
