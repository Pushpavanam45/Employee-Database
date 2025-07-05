package elevatelab_intern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
	
	public void addEmployee(Employee emp) throws SQLException{
		String sql = "INSERT INTO employees (name, department, salary) VALUES(?,?,?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, emp.getName());
			stmt.setString(2,  emp.getDepartment());
			stmt.setDouble(3, emp.getSalary());
			stmt.executeUpdate();
			
		}
	
	}
	public List<Employee> getAllEmployees() throws SQLException{
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * from employees";
		
		try(Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery()){
			while(rs.next()) {
				list.add(new Employee(
						rs.getInt("id"),
						rs.getString("department"),
						rs.getString("de[artment"),
						rs.getDouble("salary")
						));
						
			}
			
		}
		return list;
		}
	
		
		public void updateEmployee(Employee emp) throws SQLException {
			String sql = "UPDATE employees SET name = ?, department = ?, salary = ?, WHERE id =?";
			try(Connection conn = DBConnection.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)){
				
				stmt.setString(1,  emp.getName());
				stmt.setString(1,  emp.getDepartment());
				stmt.setDouble(1,  emp.getSalary());
				stmt.setInt(1,  emp.getId());
				stmt.executeUpdate();
				
				
				
		}
		
	}

		public void deleteEmployee(int id) throws SQLException {
			String sql = "DELETE FROM employees WHERE id =?";
			try(Connection conn = DBConnection.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1,  id);
				stmt.executeUpdate();
				
			}
		}
}
