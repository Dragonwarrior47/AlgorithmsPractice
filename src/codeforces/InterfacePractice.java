import java.util.Arrays;


public class InterfacePractice{
	public static class Employee implements Comparable<Employee>{
		private double salary;
		
		public Employee(double salary){
			this.salary = salary;
		
		}
		
		public int compareTo(Employee other){
			return Double.compare(this.salary, other.salary);
		}
		
		public String toString(){
			return String.format("%s", this.salary);
		}
	
	}

	public static void main(String args []){
		Employee [] es = new  Employee[3];
		es[0] = new Employee(10.0);
		es[1] = new Employee(123.0);
		es[2] = new Employee(1.0);
		System.out.println(Arrays.toString(es));
		Arrays.sort(es);
		System.out.println(Arrays.toString(es));	

	}	


}
