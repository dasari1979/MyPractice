package com.test.interview;

public class Temperature
{
    private double temperature;
    public static double maxTemp = 0;

    public Temperature(double t)
    {
        temperature = t;
        if (t > maxTemp)
        {
             maxTemp = t;
        }
    }

    public static void main(String[] args)
    {
        Temperature t1 = new Temperature(75);
        Temperature t2 = new Temperature(100);
        Temperature t3 = new Temperature(65);
        System.out.println("Max Temp: " + Temperature.maxTemp);
    }
}
