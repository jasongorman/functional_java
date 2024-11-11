package com.codemanship.functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codemanship.functional.Functional.fn;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class StudentsTests {

	private List<Student> students;
	private final Student mike = new Student("Michael", "Stone", 18, "Fine Art");
	private final Student jill = new Student("Jill", "Potter", 18, "Physics");
	private final Student casey = new Student("Casey", "Jones", 22, "Computer Science");
	private final Student lucy = new Student("Lucy", "Chan", 21, "Civil Engineering");

	@BeforeEach
	public void createStudentList() {
		students = asList(new Student[] { mike, jill, casey, lucy });
	}

	@Test
	public void filtersMatureStudents() {
		List<Student> matureStudents = fn(students)
				.filter(student -> student.isMature())
				.asList();

		assertIterableEquals(asList(casey, lucy), matureStudents);
	}

	@Test
	public void mapsMajors() {
		List<String> majors = fn(students)
				.map(student -> student.getMajor())
				.asList();

		assertIterableEquals(asList("Fine Art", "Physics", "Computer Science", "Civil Engineering"), majors);
	}

	@Test
	public void reducesStudentAge() {
		double ageSum = fn(students)
				.map(student -> student.getAge())
				.reduce(0,(sum, age) -> sum + age);
		assertEquals(79, ageSum);
	}

}
