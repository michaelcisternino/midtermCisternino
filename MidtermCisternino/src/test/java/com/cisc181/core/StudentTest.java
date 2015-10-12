package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class StudentTest {
	
	private static ArrayList<Course> CourseList = new ArrayList<Course>();
	private static ArrayList<Semester> SemList = new ArrayList<Semester>();
	private static ArrayList<Section> SectionList = new ArrayList<Section>();
	private static ArrayList<Student> StuList = new ArrayList<Student>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Course c1 = new Course("Managerial Accounting", 3, eMajor.BUSINESS);
		Course c2 = new Course("Fluid Mechanics", 4, eMajor.PHYSICS);
		Course c3 = new Course("Data Structures", 3, eMajor.COMPSI);
		CourseList.add(c1);
		CourseList.add(c2);
		CourseList.add(c3);
		
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2015, 9, 10);
		Date start1 = date1.getTime();
		Calendar date2 = Calendar.getInstance();
		date2.set(2015, 12, 20);
		Date end1 = date2.getTime();
		Calendar date3 = Calendar.getInstance();
		date3.set(2016, 2, 15);
		Date start2 = date3.getTime();
		Calendar date4 = Calendar.getInstance();
		date4.set(2016, 5, 30);
		Date end2 = date4.getTime();
		
		Semester s1 = new Semester(UUID.randomUUID(), start1, end1);
		Semester s2 = new Semester(UUID.randomUUID(), start2, end2);
		SemList.add(s1);
		SemList.add(s2);
		
		Section sec1 = new Section (c1.getCourseID(), s1.getSemesterID(), 10);
		Section sec2 = new Section (c1.getCourseID(), s2.getSemesterID(), 10);
		Section sec3 = new Section (c2.getCourseID(), s1.getSemesterID(), 341);
		Section sec4 = new Section (c2.getCourseID(), s2.getSemesterID(), 280);
		Section sec5 = new Section (c3.getCourseID(), s1.getSemesterID(), 8);
		Section sec6 = new Section (c3.getCourseID(), s2.getSemesterID(), 12);
		SectionList.add(sec1);
		SectionList.add(sec2);
		SectionList.add(sec3);
		SectionList.add(sec4);
		SectionList.add(sec5);
		SectionList.add(sec6);
		
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1995, 4, 26);
		Date dob = birthDate.getTime();
		
		Student stu1 = new Student("Mike", "Anthony", "Cisternino", dob, eMajor.COMPSI, "602 Bronson Road", "3153967784", "mcistern@udel.edu");
		Student stu2 = new Student("Mike", "Anthony", "James", dob, eMajor.COMPSI, "603 Bronson Road", "3153967785", "mcistern@udel.edu");
		Student stu3 = new Student("Mike", "Anthony", "Jones", dob, eMajor.COMPSI, "604 Bronson Road", "3153967786", "mcistern@udel.edu");
		Student stu4 = new Student("Mike", "Anthony", "Swanson", dob, eMajor.COMPSI, "605 Bronson Road", "3153967787", "mcistern@udel.edu");
		Student stu5 = new Student("Mike", "Anthony", "Wolfe", dob, eMajor.COMPSI, "606 Bronson Road", "3153967788", "mcistern@udel.edu");
		Student stu6 = new Student("Mike", "Anthony", "Fazio", dob, eMajor.COMPSI, "607 Bronson Road", "3153967789", "mcistern@udel.edu");
		Student stu7 = new Student("Mike", "Anthony", "Cherub", dob, eMajor.COMPSI, "608 Bronson Road", "3153967781", "mcistern@udel.edu");
		Student stu8 = new Student("Mike", "Anthony", "Pollack", dob, eMajor.COMPSI, "609 Bronson Road", "315396772", "mcistern@udel.edu");
		Student stu9 = new Student("Mike", "Anthony", "Jameson", dob, eMajor.COMPSI, "610 Bronson Road", "3153967783", "mcistern@udel.edu");
		Student stu10 = new Student("Mike", "Anthony", "Johsnon", dob, eMajor.COMPSI, "611 Bronson Road", "3153967798", "mcistern@udel.edu");
		StuList.add(stu1);
		StuList.add(stu2);
		StuList.add(stu3);
		StuList.add(stu4);
		StuList.add(stu5);
		StuList.add(stu6);
		StuList.add(stu7);
		StuList.add(stu8);
		StuList.add(stu9);
		StuList.add(stu10);
		
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
	public void testEnroll() {
		ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();
		for (int i = 0; i < SectionList.size(); i++) {
			for (int j = 0; j < StuList.size(); j++) {
			Enrollment newEnroll = new Enrollment(StuList.get(j).getStudentID(), SectionList.get(i).getSectionID());
			enrollList.add(newEnroll);
		}
		}
		
		for (int i = 0; i < (enrollList.size()/2); i++) {
			enrollList.get(i).setGrade(85.00);
		}
		
		for (int i = (enrollList.size()/2); i < enrollList.size(); i++) {
			enrollList.get(i).setGrade(80.00);
		}
		
		double gpa1 = 85.00;
		double gpa2 = 80.00;
		
		assertEquals(enrollList.get(0).getGrade(), gpa1, .0001);
		assertEquals(enrollList.get(6).getGrade(), gpa1, .0001);
		assertEquals(enrollList.get(13).getGrade(), gpa1, .0001);
		assertEquals(enrollList.get(20).getGrade(), gpa1, .0001);
		assertEquals(enrollList.get(27).getGrade(), gpa1, .0001);
		assertEquals(enrollList.get(34).getGrade(), gpa2, .0001);
		assertEquals(enrollList.get(41).getGrade(), gpa2, .0001);
		assertEquals(enrollList.get(48).getGrade(), gpa2, .0001);
		assertEquals(enrollList.get(54).getGrade(), gpa2, .0001);
		assertEquals(enrollList.get(59).getGrade(), gpa2, .0001);
		
		
		
	}
	
	@Test
	public void testMajorChange() {
		StuList.get(0).setMajor(eMajor.NURSING);
		
		assertTrue(StuList.get(0).getMajor() == eMajor.NURSING);
	}

}
