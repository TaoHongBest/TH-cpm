package com.taohong;

/**
 * @author taohong on 2019-01-15
 */
public class CPM {

    public CPM() {

    }

    // Accept orders for parking, unparking & compacting
    public void accept(String str) {
        switch (str.charAt(0)) {
            case 'p':
                parkCar(str.substring(1, 4));
            case 'u':
                unparkCar(str.substring(1));
            case 'c':
                compact();
            default:
        }
    }

    private void compact() {
    }

    private void parkCar(String substring) {
    }

    private void unparkCar(String substring) {
    }

    public String displayResult() {
        return null;
    }
}
