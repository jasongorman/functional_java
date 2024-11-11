package com.codemanship.functional;

public class Student {

	private final int age;
	private final String major;

	public Student(String firstName, String surname, int age, String major) {
		this.age = age;
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public boolean isMature() {
		return age >= 21;
	}

	public int getAge() {
		return age;
	}
}
