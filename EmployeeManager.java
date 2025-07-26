import java.util.*; 

public class EmployeeManager {
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateEmployee(); break;
                case 5: deleteEmployee(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // 1. Add employee
    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employeeList.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully.");
    }

    // 2. View all employees
    public static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    // 3. Search by ID
    public static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                System.out.println("Found: " + e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 4. Update employee
    public static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear newline
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                System.out.print("Enter new Department: ");
                String dept = scanner.nextLine();
                System.out.print("Enter new Salary: ");
                double salary = scanner.nextDouble();
                e.setDepartment(dept);
                e.setSalary(salary);
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 5. Delete employee
    public static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
