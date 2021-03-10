package PracticeJava.InterfacesAndLambdaExpressions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Experiments{

    public static void main(String args[]){
        ArrayList<String> planets = new ArrayList<>();
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Mercurry");
        System.out.println(planets.toString());
        planets.removeIf(e->e=="Mercurry");
        System.out.println(planets.toString());

    }

}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Compares employees by salary
     *
     * @param other another Employee object
     * @return a negative value if this employee has a lower salary than
     * otherObject, 0 if the salaries are the same, a positive value otherwise
     */
    public int compareTo(Employee other) {
        return -Double.compare(salary, other.salary);
    }
}
