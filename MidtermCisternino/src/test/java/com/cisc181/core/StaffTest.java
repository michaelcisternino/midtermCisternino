package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class StaffTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSalary() {
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		
		Staff s1 = new Staff();
		s1.setSalary(65000.00);
		StaffList.add(s1);
		
		Staff s2 = new Staff();
		s2.setSalary(80000.00);
		StaffList.add(s2);
		
		Staff s3 = new Staff();
		s3.setSalary(95000.00);
		StaffList.add(s3);
		
		Staff s4 = new Staff();
		s4.setSalary(85000.00);
		StaffList.add(s4);
		
		Staff s5 = new Staff();
		s5.setSalary(70000.00);
		StaffList.add(s5);
		
		double expAvg = 79000.00;
		double avg = ((s1.getSalary() + s2.getSalary() + s3.getSalary() + s4.getSalary() + s5.getSalary()) / StaffList.size());
		
		assertEquals(expAvg, avg, .00001);
		
		
	}
	
	@Test
	public void testDOB() {
		Calendar outOfBounds = Calendar.getInstance();
		outOfBounds.set(1915, 4, 20);
		Date BirthDate = outOfBounds.getTime();
		Staff staffer = new Staff();
		boolean caught = false;
		
		try {
			staffer.setDOB(BirthDate);
		} catch (Exception e) {
			caught = true;
		}
		
		assertTrue(caught);
		
	}
	
	@Test
	public void testNumber() {
		String exampleNumber = "12334588";
		boolean caught = false;
		Staff staffer = new Staff();
		
		try {
			staffer.setPhone(exampleNumber);
		} catch (Exception e) {
			caught = true;
		}
		
		assertTrue(caught);
		
	}
	
	

	
}
