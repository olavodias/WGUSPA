/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager.models;

import java.util.ArrayList;

/**
 * Represents a Student
 * 
 * @author Olavo Henrique Dias
 */
public class Student {
    
    private String _studentID;
    
    /**
     * Returns the Student ID
     * @return A String containing the Student ID
     */
    public String getStudentID() {
        return _studentID;
    }
    
    /**
     * Sets the Student ID
     * @param studentID A String containing the Student ID
     */
    public final void setStudentID(String studentID) {
        _studentID = studentID;
    }
    
    private String _firstName;
    
    /**
     * Returns the Student's First Name
     * @return A String containing the Student's first name
     */
    public String getFirstName() {
        return _firstName;
    }
    
    /**
     * Sets the Student's First Name
     * @param firstName A String containing the Student's first name
     */
    public final void setFirstName(String firstName) {
        _firstName = firstName;
    }
    
    private String _lastName;
    
    /**
     * Returns the Student's Last Name
     * @return A String containing the Student's last name
     */
    public String getLastName() {
        return _lastName;
    }

    /**
     * Sets the Student's Last Name
     * @param lastName A String containing the Student's last name
     */
    public final void setLastName(String lastName) {
        _lastName = lastName;
    }
    
    private String _emailAddress;
    
    /**
     * Returns the Student's Email Address
     * @return A String containing the Student's email address
     */
    public String getEmailAddress() {
        return _emailAddress;
    }
    
    /**
     * Sets the Student's Email Address
     * @param emailAddress A String containing the Student's email address
     */
    public final void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }
    
    private int _age;
    
    /**
     * Returns the Student's Age
     * @return An integer containing the Student's age
     */
    public int getAge() {
        return _age;
    }
    
    /**
     * Sets the Student's Age
     * @param age An integer containing the Student's age
     */
    public final void setAge(int age) {
        _age = age;
    }
    
    private final ArrayList<Integer> _grades;
    
    /**
     * Returns the List of Student's Grades
     * @return An ArrayList containing the Student's grades
     */
    public ArrayList<Integer> getGrades() {
        return _grades;
    }
    
    /**
     * Initializes an empty student - only for internal usage
     */
    protected Student()
    {
        /* Creates the Array List */
        _grades = new ArrayList<>();
    }
    
    /**
     * Initializes a new instance of a Student
     * @param studentID         The Student ID
     * @param firstName         The Student's First Name
     * @param lastName          The Student's Last Name
     * @param emailAddress      The Student's Email Address
     * @param age               The Student's Age
     * @param grades            A List of Student's Grades
     */
    public Student(String studentID, String firstName, String lastName, String emailAddress, int age, int... grades)
    {
        /* Sets the Properties */
        this.setStudentID(studentID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmailAddress(emailAddress);
        this.setAge(age);
        
        /* Creates the Array List */
        _grades = new ArrayList<>();
        
        /* Add all grades to it */
        for (int grade : grades)
            _grades.add(grade);
    }
    
    /**
     * Prints the Student's Information
     */
    public void print() 
    {
        /* Prints the Student Information to the Console */
        System.out.println(String.format("%s\tFirst Name: %s\tLast Name: %s\tAge: %d\t\tGrades: {%s}.",
                                         this.getStudentID(),
                                         this.getFirstName(),
                                         this.getLastName(),
                                         this.getAge(),
                                         this.getGrades().toString()));
    }
    
    /**
     * Creates a Student based on string parameters
     * @param studentString A string containing the Student Information
     * @return 
     */
    public static Student createFromString(String studentString) 
    {
        /* New Student Variable */
        Student student = new Student();
        
        /* Split the input string */
        String[] studentStringArray = studentString.split(",");
        
        /* Validate number of elements */
        if (studentStringArray.length < 6) {
            System.out.println(String.format("The input string of '%s' is not valid.", studentString));
            return null;
        }

        /* Validate Fields */
        try
        {
            /* Student ID */
            student.setStudentID(studentStringArray[0]);
            
            /* First Name */
            student.setFirstName(studentStringArray[1]);
            
            /* Last Name */
            student.setLastName(studentStringArray[2]);
            
            /* Email Address */
            student.setEmailAddress(studentStringArray[3]);
            
            /* Age */
            student.setAge(Integer.parseInt(studentStringArray[4].trim()));
            
            /* Grades */
            if (studentStringArray.length > 6)
            {
                for (int i = 5; i < studentStringArray.length; i++)
                    student.getGrades().add(Integer.parseInt(studentStringArray[i].trim()));
            }
 
            /* Returns the Student just added */
            return student;
        }
        catch (Exception e)
        {
            System.out.println(String.format("The input string of '%s' is not valid. Error: %s", studentString, e.getStackTrace().toString()));
            return null;
        }
    }
}
