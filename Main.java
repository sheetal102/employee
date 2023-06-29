import java.util.ArrayList; //ArrayList is a class which provide resizable array.This line import the ArrayList class from java.util package         
import java.util.Scanner; //Scanner is also a class which is used for taking the user input

class Employee { // here Employee is the class name
    private int ID; // here private instance variable ID is declared which is of type int
    private String name; // here private instance variable name is declared which is of type string
    private String designation; // here private instance variable designation is declared which is of type string
    private double salary; // here private instance variable salary is declared which is of type double

    public Employee(int ID, String name, String designation, double salary) { // here a constructor is defined for Employee which takes 4 parameters
        this.ID = ID;  //intialized value to variable Id 
        this.name = name; //intialized value to variable name
        this.designation = designation; //intialized value to variable desination
        this.salary = salary; //intialized value to variable salary
    }

    public int getID() { // this defines a getter method for variable ID
        return ID; // returns the value of the ID
    }

    public String getName() { // this defines a getter method for variable name
        return name; // returns the value of the name
    }

    public String getDesignation() { // this defines a getter method for variable designation
        return designation; // returns the value of the designation
    }

    public double getSalary() { // this defines a getter method for variable salary
        return salary; // returns the value of the salary
    }
}

class Manager { // a new class name i.e manager is defined
    private ArrayList<Employee> employeeList; // hereprivate instance variable employList is declared of type ArrayList<Employee> which is used for storing the data or information of the employees

    public Manager() { // here a constructor is defined for Manager class
        employeeList = new ArrayList<>(); // employeeList is initialized by creating new ArrayList
    }

    public void addEmployee(Employee employee) { // here a method name addEmployee is defined
        employeeList.add(employee); // here parameter is taken as employee and add it to the employeeList
        System.out.println("Employee added successfully!"); // here it prints the successful message
    }

    public void displayEmployees() { // here a method name displayEmployees is defined
        if (employeeList.isEmpty()) { // here it check wheather the list is empty or not
            System.out.println("No employees found."); // if the list is empty it prints no employess found
            return;
        }

        System.out.println("Employee Details:"); // when if condition is not satisfied the it comes to this line for execution
        for (Employee employee : employeeList) { //forEach loop used to display all available employees details.
            System.out.println("ID: " + employee.getID());  // here it prints the message ID with concatination of employee ID
            System.out.println("Name: " + employee.getName());  // here it prints the message name with concatination of employee name
            System.out.println("Designation: " + employee.getDesignation());  // here it prints the message Designation with concatination of employee designation
            System.out.println("Salary: " + employee.getSalary()); // here it prints the message salary with concatination of employee salary
            System.out.println();
        }
    }

    public void searchEmployee(int id) { //Here is method defined for searching employee using Id
        for (Employee employee : employeeList) {  //forEach loop used to display all available employees details.
            if (employee.getID() == id) {    //checking employee id with given id by user
                System.out.println("Employee Details:"); 
                System.out.println("ID: " + employee.getID()); //here printed employee id which is found 
                System.out.println("Name: " + employee.getName()); //here printed employee name for given id
                System.out.println("Designation: " + employee.getDesignation()); //here printed employee designation for given id
                System.out.println("Salary: " + employee.getSalary()); // here printed salary for given id
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found."); //if no employee available with given id this line will be printed.
    }
}

public class Main {   //Main class started 
    
    public static void main(String[] args) {  //main method started
        Manager manager = new Manager();   //object created for manager class
        Scanner scanner = new Scanner(System.in);  //scanner class object for user input.

        while (true) { //used while loop to display following statement repeatedly
            //Interface for User
            System.out.println("Employee Management System"); //this statement print line "employee management system"
            System.out.println("Choose an operation:");  //this statement print line "choose an operation"
            System.out.println("1. Add Employee"); //this statement print line "add employee"
            System.out.println("2. Display Employees"); //this statement print line "display employee"
            System.out.println("3. Search Employee"); //this statement print line "search employee"
            System.out.println("4. Exit"); //this statement print line "exit"
            System.out.print("Enter your choice: "); //this statement print line "enter your choice"

            int choice = scanner.nextInt(); //accepting user Input
            scanner.nextLine(); //it will consume newline character


            //using switch case statements to perform actions based on user input

            switch (choice) { //switch case taking choice as a user input
                case 1:
                    System.out.print("Enter Employee ID: "); //statement to accept ID from user
                    int id = scanner.nextInt(); //nextInt will consume the int input
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Employee Name: "); //statement to accept name from user
                    String name = scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Employee Designation: "); //statement to accept designation from user
                    String designation = scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Employee Salary: "); //statement to accept salary from user
                    double salary = scanner.nextDouble(); //it will consume double value provided by user
                    scanner.nextLine(); // Consume newline character

                    Employee employee = new Employee(id, name, designation, salary); //object create for Employee class and provied all parameters
                    manager.addEmployee(employee); //here employeed objected added to array list created in manager class
                    break;

                //case 2: for display all available empolyees

                case 2:
                    manager.displayEmployees(); //here I have call displayEmployee method to display empoyees
                    break;

                //case 3: search operation

                case 3:
                    System.out.print("Enter Employee ID to search: "); //this statement for taking employee id as inputer from user
                    int searchID = scanner.nextInt(); //this line collect give input in searchId variable
                    scanner.nextLine(); // Consume newline character
                    manager.searchEmployee(searchID); //searchEmployee method called here for searching
                    break;

                //case 4: for exiting program.

                case 4:
                    System.out.println("Exiting the program...");  //exit the program by printing the statement exiting the program
                    System.exit(0);
                    break;

                //default statement for invalid inputes.

                default:
                    System.out.println("Invalid choice. Please try again."); //  print the statement Invalid choice. Please try again
                    break;
            }
        }
    }
}
