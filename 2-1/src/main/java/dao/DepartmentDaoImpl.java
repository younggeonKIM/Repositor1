/**
 * 
 */
package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Department;
import model.Employee;
import model.Location;

public class DepartmentDaoImpl implements DepartmentDao {
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<Location> getLocations() {
		List<Location> list=session.selectList("mapper.myhome.getLocation");
		return list;
	}
	
	public List<Employee> getEmployees() {
		List<Employee> list=session.selectList("mapper.myhome.getEmployee");
		return list;
	}

	public List<Department> getDepartments() {
		List<Department> list=
				session.selectList("mapper.myhome.getDepartment");
		return list;
	}

}
