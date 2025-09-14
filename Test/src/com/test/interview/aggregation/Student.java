package com.test.interview.aggregation;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private int id;
	private String dept;

	Student(String name, int id, String dept) {

		this.name = name;
		this.id = id;
		this.dept = dept;
	}
}

class Department {

	String name;
	private List<Student> students;

	Department(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}

	public List<Student> getStudents() {

		return students;

	}
}

class Institute {

	String instituteName;

	List<Department> departments;

	Institute(String instituteName, List<Department> departments) {

		this.instituteName = instituteName;
		this.departments = departments;
	}

	public int totalStudentInstitues() {

		int noOfStudents = 0;
		List<Student> students;
		for (Department dept : departments) {
			students = dept.getStudents();
			for (Student std : students) {
				System.out.println("Student Name: " + std);
				noOfStudents++;
			}
		}
		return noOfStudents;
	}
}

class GFG {

	// main driver method
	public static void main(String[] args) {

		// Creating object of Student class inside main()
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");
        
     // Creating a List of CSE Students
        List<Student> cse_students = new ArrayList<Student>();
        
        cse_students.add(s1);
        cse_students.add(s2);
        
        List<Student> ee_students = new ArrayList<Student>();
        
        ee_students.add(s3);
        ee_students.add(s4);
        
        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);
        
        List<Department> departments = new ArrayList<Department>();
        departments.add(CSE);
        departments.add(EE);

        Institute institute = new Institute("BITS", departments);
     // Display message for better readability
        System.out.print("Total students in institute: ");

        // Calling method to get total number of students
        // in institute and printing on console
        System.out.print(institute.totalStudentInstitues());
	
	}
}