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
    
    public static ArrayList<Student> getStudentsList() {
        if (_studentsList == null)
            _studentsList = new ArrayList<>();
        
        return _studentsList;
    }
    
    private static Student lookupStudent(String studentID)
    {
        for (Student student : getStudentsList())
        {
            if (student.getStudentID().equals(studentID)) 
                return student;
        }

        /* Student was not found, throw error */
        System.out.println(String.format("Student '%s' could not be found on the list.",
                                         studentID));
        
        return null;
    }
    
    public static void add(Student student) {
        /* Check for existing Student ID */
        if (lookupStudent(student.getStudentID()) != null)
            getStudentsList().add(student);
        else
            System.out.println(String.format("The Student ID '%s' already exists on the list"));
    }
    
    public static void remove(String studentID) 
    {
        /* Make sure there is a student ID to be removed */
        Student student = lookupStudent(studentID);
                
        /* If Student was found, remove it from list */
        if (student != null)
            getStudentsList().remove(student);
    }
    
    public static void print_all() 
    {
        /* Loop thru all students on the list */
        for (Student student : getStudentsList())
            student.print();
    }

    public static void print_average_grade(String studentID) 
    {
        /* Look for student */
        Student student = lookupStudent(studentID);
        
        if (student != null)
        {
            if (!student.getGrades().isEmpty()) {
                int gradeAccumulated = 0;
                int countOfGrades = 0;
                
                for (Integer grade : student.getGrades())
                {
                    gradeAccumulated += grade;
                    countOfGrades++;
                }
                
                if (countOfGrades > 0)
                    System.out.println(String.format("Average Grade: %d", (gradeAccumulated / countOfGrades)));
            }
            else
            {
                System.out.println("No grades informed");
            }
        }
    }
    
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
