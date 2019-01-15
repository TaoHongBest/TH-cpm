package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Car {
    String carNum;
    int spaceNum;
    int ticketNum;
    boolean isParkedHere;

    public Car(String carNum, int ticketNum, int spaceNum) {
        this.carNum = carNum;
        this.ticketNum = ticketNum;
        this.spaceNum = spaceNum;
        isParkedHere = true;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }
}
