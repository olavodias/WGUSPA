/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;
import studentmanager.models.Student;

/**
 * Represents a List of Students
 * @author Olavo Henrique Dias
 */
public class Roster {
    
    private static ArrayList<Student> _studentsList = new ArrayList<>();
    
    /**
     * Gets the List of Students
     * @return An Array List of Students
     */
    public static ArrayList<Student> getStudentsList() {
        if (_studentsList == null)
            _studentsList = new ArrayList<>();
        
        return _studentsList;
    }
    
    /**
     * Look for the student on the list based on the student id
     * @param studentID     The Student ID
     * @param printMessage  A flag to define whether to print or not a message when the student could not be found
     * @return A Student object when the student is found. If the student is not found then returns null
     */
    private static Student lookupStudent(String studentID, boolean printMessage)
    {
        for (Student student : getStudentsList())
        {
            if (student.getStudentID().equals(studentID)) 
                return student;
        }

        /* Student was not found, throw error and return null*/
        if (printMessage) {
            System.out.println(String.format("Student '%s' could not be found on the list.",
                                             studentID));
        }
        
        return null;
    }
    
    /**
     * Adds a student to the list of students.
     * If the student ID is already on the list, throw an error message
     * @param student Reference to the Student Object to be added
     */
    public static void add(Student student) {
        /* Check for existing Student ID */
        if (lookupStudent(student.getStudentID(), false) == null)
            getStudentsList().add(student);
        else
            System.out.println(String.format("The Student ID '%s' already exists on the list"));
    }
    
    /**
     * Removes the student from the list of students
     * @param studentID The Student ID of the student to be removed
     */
    public static void remove(String studentID) 
    {
        /* Make sure there is a student ID to be removed */
        Student student = lookupStudent(studentID, true);
                
        /* If Student was found, remove it from list */
        if (student != null)
            getStudentsList().remove(student);
    }
    
    /**
     * Prints all students on the System Output
     */
    public static void print_all() 
    {
        /* Loop thru all students on the list */
        for (Student student : getStudentsList())
            student.print();
    }

    /**
     * Prints the Average Grade of a given student on the System Output
     * @param studentID The Student ID to have the average grade printed
     */
    public static void print_average_grade(String studentID) 
    {
        /* Look for student */
        Student student = lookupStudent(studentID, false);
        
        if (student != null)
        {
            /* Make sure there are grades to be calculated */
            if (!student.getGrades().isEmpty()) {
                int gradeAccumulated = 0;
                int countOfGrades = 0;
                
                /* Accumulate each grade */
                for (Integer grade : student.getGrades())
                {
                    gradeAccumulated += grade;
                    countOfGrades++;
                }
                
                /* Prints the Average Grade */
                if (countOfGrades > 0)
                    System.out.println(String.format("Average Grade: %d", (gradeAccumulated / countOfGrades)));
            }
            else
            {
                /* There are no grades, print a message */
                System.out.println("No grades informed");
            }
        }
    }
    
    /**
     * Prints all invalid emails on the list.
     * Emails without the "@" symbol or a "." are considered invalid.
     */
    public static void print_invalid_emails() 
    {
        /* Loop thru list of Students and validate email */
        for (Student student : getStudentsList())
        {
            /* Make sure there is one "@" and "." on the email */
            if ( (!student.getEmailAddress().contains("@")) || (!student.getEmailAddress().contains(".")) )
                /* Either "@" or "." were not found, print as an invalid email */
                System.out.println(student.getEmailAddress());
        }
    }
}
