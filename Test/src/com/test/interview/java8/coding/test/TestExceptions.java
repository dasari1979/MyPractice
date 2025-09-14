package com.test.interview.java8.coding.test;

import java.io.IOException;
 
class Parent {

    public void readData() throws IOException {

        System.out.println("Parent: Reading data...");

    }

}
 
class Child1 extends Parent {

    @Override

    public void readData() throws IOException {

        System.out.println("Child1: Reading data with IOException");

    }

}
 
class Child2 extends Parent {

    @Override

    public void readData() throws java.io.FileNotFoundException {

        System.out.println("Child2: Reading data with FileNotFoundException");

    }

}
 
class Child3 extends Parent {

    @Override

    public void readData()  throws ClassCastException { 

        System.out.println("Child3: Reading data with SQLException");

    }

}
 
public class TestExceptions {

    public static void main(String[] args) {

        Parent p1 = new Child1();

        try {

            p1.readData();

        } catch (IOException e) {

            System.out.println("Handled: " + e.getMessage());

        }
 
        Parent p2 = new Child2();

        try {

            p2.readData();

        } catch (IOException e) {

            System.out.println("Handled: " + e.getMessage());

        }

    }

}

 
