package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Ticket {
    private int ticketNum;
    private int spaceNum;
    private String carNum;
    private boolean isParking;

    public int getSpaceNum() {
        return spaceNum;
    }

    public Ticket(int ticketNum, String carNum, int sapceNum) {
        this.ticketNum = ticketNum;
        this.carNum = carNum;
        this.spaceNum = sapceNum;
        this.isParking = true;
    }


    public int getTicketNum() {
        return ticketNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public boolean isParking() {
        return isParking;
    }

    public void unparkCar(boolean hasUnparked) {
        this.isParking = false;
    }
}
