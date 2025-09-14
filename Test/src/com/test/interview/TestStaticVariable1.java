package com.test.interview;

//Java Program to demonstrate the use of static variable
class Student_{
 int rollno;//instance variable
 String name;
 static String college = "abc";//static variable
 //constructor
 Student_(int r, String n, String c){
 rollno = r;
 name = n;
 college = c;
 }
 //method to display the values
 void display (){
	 System.out.println(rollno+" "+name+" "+college);
	 
 }
}
//Test class to show the values of objects
public class TestStaticVariable1{
public static void main(String args[]){
Student_ s1 = new Student_(111,"Karan","xxx");
Student_ s2 = new Student_(222,"Aryan","yyy");
//we can change the college of all objects by the single line of code
//Student.college="BBDIT";
s1.display();
s2.display();
}
}

class Singleton
{


private static Singleton singleton = null;


public static Singleton getInstance(){

if(singleton == null)
{  
singleton = new Singleton();

}
return singleton;


 }

private Singleton()
{
   
}
}

