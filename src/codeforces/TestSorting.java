import java.util.*;


public class TestSorting{
	
	public static class Student{
		private String name;
		private int marks;
		Student(String name, int marks){
			this.name = name;
			this.marks = marks;
		}
		
		public String toString(){
			return String.format("{name:%s, marks:%s}", this.name, this.marks);
		}
	}
	public static void main(String args[]){
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("kanhaiya", 100));
		students.add(new Student("mohit", 100));
		students.add(new Student("dharmendra", 100));
		students.add(new Student("shivanshu", 83));
		System.out.println(students);
		Collections.sort(students, (Student s1, Student s2)->{
			return -s1.name.compareTo(s2.name);
		});
		System.out.println(students);
		Collections.sort(students, (Student s1, Student s2)->{
			return s1.marks - s2.marks;
		});
		System.out.println(students);
	}
}
