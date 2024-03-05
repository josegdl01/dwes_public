package implementacionDao;

import interfacesDao.EmployeeDAO;
import modelos.Employee;
import sql.ConexionBBDD;

import java.sql.*;
import java.util.ArrayList;

public class SQLEmployeeDAO implements EmployeeDAO {
  public Connection conexion;

  public SQLEmployeeDAO() {
    conexion = ConexionBBDD.getConex();
  }

  /**
   * @return
   */
  @Override
  public ArrayList<Employee> getAllEmployees() {
    Employee employee;
    ArrayList<Employee> lista = new ArrayList<>();
    try {
      Statement statement = conexion.createStatement();
      ResultSet linea = statement.executeQuery("SELECT * FROM employees;");
      while (linea.next()) {
        employee =
            new Employee(
                linea.getInt(1),
                linea.getString(2),
                linea.getString(3),
                linea.getString(4),
                linea.getString(5),
                linea.getString(6),
                linea.getInt(7),
                linea.getString(8));
        lista.add(employee);
      }
      statement.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
    return lista;
  }

  /**
   * @param employeeNumber
   * @return
   */
  @Override
  public Employee getCustomer(int employeeNumber) {
    return null;
  }

  /**
   * @param e
   */
  @Override
  public void insertCustomer(Employee e) {}

  /**
   * @param employeeNumber
   */
  @Override
  public void deleteCustomer(int employeeNumber) {}
}
