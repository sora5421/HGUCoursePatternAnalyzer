package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		students = new Student[numOfStudents];
		Student student1;
		int i = 0;
		int j = 0;
		while(true) {
			student1 = new Student(lines[j].split(",")[1]);
			if(j != 0) {
				if(studentExist(students,student1)) {
					j++;
				}
				else {
					students[i] = new Student(lines[j].split(",")[1]);
					i++;
					j++;
				}
			}
			else {
				students[i] = new Student(lines[j].split(",")[1]);
				i++;
				j++;
			}
			if(i == numOfStudents) break;
		}
		return students;
		
	
}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		int i = 0;
		// TODO: implement this method
		for (Student student2 : students) {
			Student student3 = student2;
			if(student3 == null) break;
			if(student3.getName().contentEquals(student.getName())) {
				i = 1;
				break;
			}
		}
		if(i == 1) return true;
		else return false;
	}

	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		courses = new Course[numOfCourses];
		Course course1;
		int i = 0;
		int j = 0;
		while(true) {
			course1 = new Course(lines[j].split(",")[2]);
			if(j != 0) {
				if(courseExist(courses,course1)) {
					j++;
				}
				else {
					courses[i] = new Course(lines[j].split(",")[2]);
					i++;
					j++;
				}
			}
			else {
				courses[i] = new Course(lines[j].split(",")[2]);
				i++;
				j++;
			}
			if(i == numOfCourses) break;
		}
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		int i = 0;
		// TODO: implement this method
		for (Course course2 : courses){
			if(course2 == null)break;
			if(course2.getCourseName().contentEquals(course.getCourseName())) {
				i = 1;
				break;
			}
		}
		if(i == 1) return true;				
		else return false;
	}
		
}