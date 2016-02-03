package com.sadd.junit.source;
import java.util.ArrayList;
import java.util.List;
 
public class MockitoSpyEmployee {
    private String firstName;
    private String lastName;
    private int age;
 
    public MockitoSpyEmployee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
 
    public int getAge() {
        return age;
    }
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }  
    public void setAge(int age) {
        this.age = age;
    }
}
