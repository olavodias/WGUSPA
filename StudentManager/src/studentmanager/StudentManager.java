/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import studentmanager.models.Student;

/**
 *
 * @author Olavo Henrique Dias
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Creates an array of Students represented as a String */
        String [] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59", 
                              "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
                              "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
                              "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
                              "5,Olavo,H Dias,odias@my.wgu.edu,33,84,83,85"};
        
        /* Add each element of the string to the Roster */
        for (String student : students) {
            
            /* Create an Student using a Static Method of the Student Class */
            Student newStudent = Student.createFromString(student);
            
            /* Make sure the system could create a student class instance */
            if (newStudent != null)
                Roster.add(newStudent);
        }
          
        /* Print All Students */
        Roster.print_all();
        
        /* Print Invalid Emails */
        Roster.print_invalid_emails();
        
        /* Print average grade of each student */
        for (Student student : Roster.getStudentsList())
        {
            /* Print the student name (do not append character at the end of the string) */
            System.out.print(String.format("%s\tFirst Name: %s\tLast Name: %s\t",
                                           student.getStudentID(),
                                           student.getFirstName(),
                                           student.getLastName()));
            /* Print the average grade */
            Roster.print_average_grade(student.getStudentID());
        }
        
        /* Remove Student of the List */
        Roster.remove("3");
        
        /* Try again to remove the same student */
        Roster.remove("3");
    }
    
}
