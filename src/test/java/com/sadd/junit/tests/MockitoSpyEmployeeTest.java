package com.sadd.junit.tests;

import com.sadd.junit.source.MockitoSpyEmployee;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MockitoSpyEmployeeTest {
	
	
	  
	
	    private MockitoSpyEmployee emp= new MockitoSpyEmployee(FIRST_NAME, LAST_NAME, AGE);
	    private MockitoSpyEmployee spyEmp=Mockito.spy(emp);

	    private static final String FIRST_NAME = "Joe";
	
	    private static final String LAST_NAME = "M";
	
	    private static final int AGE = 35;

	   
	     


	     

	    @Test
	
	    public void verifySpyEffectOnRealInstance() {
	
	        spyEmp.setAge(20);
	
	        assertFalse(emp.getAge() == spyEmp.getAge());
	
	    }
	
	     
	
	    @Test
	
	    public void verifyEmployeeDetails() {
	
	        System.out.println("Full name:" + spyEmp.getFullName());
	
	        System.out.println("Age:" + spyEmp.getAge());
	
	         
	
	        InOrder inOrder = inOrder(spyEmp);
	
	         
	
	        System.out.println("Verify emp.getFullName() calls getFirstName() and then getLastName()");
	
	        inOrder.verify(spyEmp).getFirstName();
	
	        inOrder.verify(spyEmp).getLastName();
	
	         
	
	        System.out.println("Verify emp.getAge() is called");
	
	        verify(spyEmp).getAge();
	
	         
	
	        assertEquals(spyEmp.getFirstName(), FIRST_NAME);
	
	        assertEquals(spyEmp.getLastName(), LAST_NAME);
	
	        assertEquals(spyEmp.getFullName(), FIRST_NAME + " " + LAST_NAME);
	
	        assertEquals(spyEmp.getAge(), AGE);
	
	        System.out.println("Verify emp.getFullName() called twice");
	
	        verify(spyEmp, times(2)).getFullName();
	
	    }
	
	     
	
	    @Test
	
	    public void spyEmployeeName() {
	
	        final String I_AM = "I am";
	
	        final String THE_SPY = "the Spy";
	
	        System.out.println("Train employee to return " + I_AM + " when emp.getFirstName() is called");
	
	        when(spyEmp.getFirstName()).thenReturn(I_AM);

	        System.out.println("Full Name: " + spyEmp.getFullName());
	
	        assertEquals(I_AM + " M", spyEmp.getFullName());
	
	         
	
	        System.out.println("Train employee to return " + THE_SPY + " when emp.getLastName() is called")	;
	        when(spyEmp.getLastName()).thenReturn(THE_SPY);

	        System.out.println("Full Name: " + spyEmp.getFullName());
	
	        assertEquals(I_AM + " " + THE_SPY, spyEmp.getFullName());
	    }  
	


}
