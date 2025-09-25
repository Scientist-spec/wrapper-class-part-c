import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

private static final String FILE_NAME = "employees.dat";
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
System.out.println("=== Employee Management System ===");
displayMenu();
}

public static void displayMenu() {
while (true) {
System.out.println("\n===== MENU =====");
System.out.println("1. Add an Employee");
System.out.println("2. Display All Employees");
System.out.println("3. Exit");
System.out.print("Enter your choice (1-3): ");

int choice = getIntInput();

switch (choice) {
case 1:
addEmployee();
break;
case 2:
displayEmployees();
break;
case 3:
exitApplication();
break;
default:
System.out.println("Invalid choice! Please enter 1, 2, or 3.");
}
}
}

public static void addEmployee() {
System.out.println("\n--- Add New Employee ---");

System.out.print("Enter Employee ID: ");
int id = getIntInput();
scanner.nextLine();

System.out.print("Enter Employee Name: ");
String name = scanner.nextLine();

System.out.print("Enter Designation: ");
String designation = scanner.nextLine();

System.out.print("Enter Salary: ");
double salary = getDoubleInput();

Employee newEmployee = new Employee(id, name, designation, salary);

ArrayList<Employee> employees = readEmployeesFromFile();

employees.add(newEmployee);

try {
FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
objectOut.writeObject(employees);
objectOut.close();
fileOut.close();
System.out.println("Employee added successfully!");
} catch (IOException e) {
System.out.println("Error saving employee data: " + e.getMessage());
}
}

public static void displayEmployees() {
System.out.println("\n--- Employee Records ---");

ArrayList<Employee> employees = readEmployeesFromFile();

if (employees.isEmpty()) {
System.out.println("No employee records found.");
return;
}

System.out.println("Total employees: " + employees.size());
System.out.println("--------------------------------------------");
for (int i = 0; i < employees.size(); i++) {
System.out.println((i + 1) + ". " + employees.get(i));
}
System.out.println("--------------------------------------------");
}

public static ArrayList<Employee> readEmployeesFromFile() {
ArrayList<Employee> employees = new ArrayList<>();

try {
File file = new File(FILE_NAME);
if (!file.exists()) {
return employees;
}

FileInputStream fileIn = new FileInputStream(FILE_NAME);
ObjectInputStream objectIn = new ObjectInputStream(fileIn);
employees = (ArrayList<Employee>) objectIn.readObject();
objectIn.close();
fileIn.close();

} catch (IOException | ClassNotFoundException e) {
System.out.println("Error reading employee data: " + e.getMessage());
}

return employees;
}

public static void exitApplication() {
System.out.println("\nThank you for using Employee Management System!");
System.out.println("Goodbye!");
scanner.close();
System.exit(0);
}

public static int getIntInput() {
while (!scanner.hasNextInt()) {
System.out.print("Invalid input! Please enter a number: ");
scanner.next();
}
int input = scanner.nextInt();
return input;
}

public static double getDoubleInput() {
while (!scanner.hasNextDouble()) {
System.out.print("Invalid input! Please enter a valid salary: ");
scanner.next();
}
double input = scanner.nextDouble();
return input;
}
}
