package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Ticket {
    private int tickNum;
    private int spaceNum;
    private String carNum;
    private boolean isParking;

    public Ticket(int tickNum, String carNum, int sapceNum) {
        this.tickNum = tickNum;
        this.carNum = carNum;
        this.spaceNum = sapceNum;
        this.isParking = true;
    }

    public int getTickNum() {
        return tickNum;
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

    public boolean isParking() {
        return isParking;
    }

    public void unparkCar(boolean hasUnparked) {
        this.isParking = false;
    }
}
