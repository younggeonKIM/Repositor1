package dao;

import java.util.List;

import model.Department;
import model.Employee;
import model.Location;

public interface DepartmentDao {
	public List<Location> getLocations();
	public List<Department> getDepartments(); 
	public List<Employee> getEmployees();
}
