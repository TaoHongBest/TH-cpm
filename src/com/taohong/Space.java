package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Space {
    int spaceNum;
    String carNum;
    int ticketNum;
    boolean isOccupied;

    public Space(int spaceNum) {
        this.spaceNum = spaceNum;
        this.isOccupied = false;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void releaseSpace() {
        isOccupied = false;
    }

    public void occupySpace() {
        isOccupied = true;
    }

    public void createTicket(String carNum) {

    }
}
