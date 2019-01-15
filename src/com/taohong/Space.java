package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class Space {
    private int spaceNum;
    private String carNum;
    private int tickNum;
    private boolean isOccupied;


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

    public int getTickNum() {
        return tickNum;
    }

    public void setTickNum(int tickNum) {
        this.tickNum = tickNum;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
