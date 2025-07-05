package elevatelab_intern;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String [] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n1. Add Employee\n2. View Employee\n3. Update Empployee\n4. Delete Employee\n5. Exit");
			System.out.println("choose: ");
			int choice = s.nextInt();
			s.nextLine();
			
			
			try {
				switch ( choice) {
				
				case 1:
					System.out.println("Name: ");
					String name = s.nextLine();
					System.out.println("Department: ");
					String dept = s.nextLine();
					System.out.println("Salary: ");
					double sal = s.nextDouble();
					dao.addEmployee(new Employee(name, dept, sal));
					System.out.println("Employee Added");
					break;
					
				case 2:
					List<Employee> employees = dao.getAllEmployees();
					for(Employee e : employees) {
						System.out.printf("ID: %d | Name : %s | Dept : %s | Salary: %.2f\n",
						e.getId(), e.getName(),e.getDepartment(), e.getSalary());
					}
					break;
					
				case 3:
					System.out.print("Enetr Employee ID to Update : ");
					int id = s.nextInt();
					s.nextLine();
					System.out.println("New Name: ");
					name = s.nextLine();
					System.out.println("New Department: ");
					dept = s.nextLine();
					System.out.println("New Salary: ");
					sal = s.nextDouble();
					dao.updateEmployee( new Employee(id, name , dept, sal));
					System.out.println("Employee Updated");
					break;
					
				case 4:
					System.out.println("Enter Employee ID to Delete: ");
					id = s.nextInt();
					dao.deleteEmployee(id);
					System.out.println("Employee Deleted.");
					break;
					
				case 5:
					System.out.println("Exiting!!");
					break;
				default:
					System.out.println("Invalid Choice");
					
				}
			}catch(SQLException e) {
					System.out.println("DataBase Error: "+ e.getMessage());
				}
			}
			
		}
		
		
	}


