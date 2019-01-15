package com.taohong;

public class Main {

    public static void main(String[] args) {
        CPM cpm = new CPM();
        if (args.length > 0) {
            String[] inst = args[0].split(",");
            for (String str : inst) {
                cpm.accept(str);
            }
        }
        System.out.println(cpm.displayResult());
    }
}
