package com.sadd.junit.tests;
import org.junit.Test;
import org.mockito.Mockito;
import com.sadd.junit.source.MockitoWhenReturn;

public class MockitoWhenReturnTest {
	
		@Test
		public void mockTest() {
			final MockitoWhenReturn mock = Mockito.spy(new MockitoWhenReturn());
	 
			// will be called:
			Mockito.when(mock.doStuff()).thenReturn(1);
	 
			// will not be called:
			Mockito.doReturn(1).when(mock).doStuff();
		}
	}
