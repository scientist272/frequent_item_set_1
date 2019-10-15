package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList[] buckets = FileOperator.readFile("itemlist10000.txt");
        FirstMapper firstMapper = new FirstMapper();
        FirstReducer firstReducer = new FirstReducer();
        SecondMapper secondMapper = new SecondMapper();
        SecondReducer secondReducer = new SecondReducer();

        firstMapper.map(buckets,1000);
        secondMapper.map(buckets,firstReducer.reduce(),1000);
        secondReducer.reduce();
    }
}
