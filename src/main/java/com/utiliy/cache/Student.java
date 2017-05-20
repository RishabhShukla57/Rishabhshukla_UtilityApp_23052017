package com.utiliy.cache;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Student {
	int id;
	Integer marks;
	String subjectEnrolled;
	Date timeStamp;

	public Student(int id, int marks, String subjectEnrolled,Date timeStamp) {
		this.id = id;
		this.marks=marks;
		this.subjectEnrolled = subjectEnrolled;
		this.timeStamp =timeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getSubjectEnrolled() {
		return subjectEnrolled;
	}

	public void setSubjectEnrolled(String subjectEnrolled) {
		this.subjectEnrolled = subjectEnrolled;
	}

	public boolean equals(Student std) {
		return marks.equals(std.getMarks());
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(marks).toHashCode();
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	

}
