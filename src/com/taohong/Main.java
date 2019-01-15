package com.taohong;

public class Main {

    public static void main(String[] args) {

        CPM cpm =new CPM();
        for(String str: args){
            cpm.accept(str);
        }
        System.out.println(cpm.displayResult());
    }
}
