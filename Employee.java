import java.io.Serializable;

public class Employee implements Serializable {
private static final long serialVersionUID = 1L;

private int id;
private String name;
private String designation;
private double salary;

public Employee(int id, String name, String designation, double salary) {
this.id = id;
this.name = name;
this.designation = designation;
this.salary = salary;
}

public int getId() {
return id;
}

public String getName() {
return name;
}

public String getDesignation() {
return designation;
}

public double getSalary() {
return salary;
}

@Override
public String toString() {
return "ID: " + id + " | Name: " + name + " | Designation: " + designation + " | Salary: $" + salary;
}
}
