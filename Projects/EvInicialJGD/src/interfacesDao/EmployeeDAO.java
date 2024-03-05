package interfacesDao;

import modelos.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    public ArrayList<Employee> getAllEmployees();

    public Employee getCustomer(int employeeNumber);
    public void insertCustomer(Employee e);
    public void deleteCustomer(int employeeNumber);
}
