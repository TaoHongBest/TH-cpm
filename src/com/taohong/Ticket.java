package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Ticket {
    int ticketNum;
    int spaceNum;
    String carNum;
    boolean isParking;

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
