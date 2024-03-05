package implementacionDao;

import interfacesDao.CustomerDAO;
import modelos.Customer;

import sql.ConexionBBDD;

import java.sql.*;
import java.util.ArrayList;

public class SqlCustomerDAO implements CustomerDAO {

  private Connection connection;

  public SqlCustomerDAO() {
    this.connection = ConexionBBDD.getConex();
  }

  @Override
  public ArrayList<Customer> getAllCustomers() {

    ArrayList<Customer> list = new ArrayList<Customer>();
    Statement statement = null;

    try {
      String query = "SELECT * FROM customers";

      statement = connection.createStatement();

      ResultSet line = statement.executeQuery(query);

      while (line.next()) {
        Customer customer =
            new Customer(
                line.getInt(1),
                line.getString(2),
                line.getString(4),
                line.getString(3),
                line.getString(5),
                line.getString(6),
                line.getString(7),
                line.getString(8),
                line.getString(9),
                line.getString(10),
                line.getString(11),
                line.getInt(12),
                line.getFloat(13));

        list.add(customer);
      }
      statement.close();
      return list;

    } catch (SQLException a) {
      System.out.println(a);

      return list;
    }
  }

  @Override
  public Customer getCustomer(int customerNumber) {
    Customer custo;
    try {
      String query = "SELECT * FROM customers WHERE customerNumber = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, customerNumber);
      ResultSet line = preparedStatement.executeQuery();

      line.next();
      custo =
          new Customer(
              line.getInt(1),
              line.getString(2),
              line.getString(4),
              line.getString(3),
              line.getString(5),
              line.getString(6),
              line.getString(7),
              line.getString(8),
              line.getString(9),
              line.getString(10),
              line.getString(11),
              line.getInt(12),
              line.getFloat(13));

      preparedStatement.close();
    } catch (SQLException a) {
      System.out.println(a);

      custo = new Customer();
    }

    return custo;
  }

  @Override
  public void insertCustomer(Customer c) {
    PreparedStatement preparedStatement = null;
    try {
      String query =
          "INSERT INTO customers(customerNumber, customerName, contactLastName, contactFirstName, phone"
              + ", addressLine1,addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      preparedStatement = connection.prepareStatement(query);

      preparedStatement.setInt(1, c.getCustomerNumber());
      preparedStatement.setString(2, c.getCustomerName());
      preparedStatement.setString(3, c.getContactLastName());
      preparedStatement.setString(4, c.getContactFirstName());
      preparedStatement.setString(5, c.getPhone());
      preparedStatement.setString(6, c.getAdressLine1());
      preparedStatement.setString(7, c.getAdressLine2());
      preparedStatement.setString(8, c.getCity());
      preparedStatement.setString(9, c.getState());
      preparedStatement.setString(10, c.getPostalCode());
      preparedStatement.setString(11, c.getCountry());
      preparedStatement.setInt(12, c.getSalesRepEmployeeNumber());
      preparedStatement.setFloat(13, c.getCreditLimit());

      preparedStatement.executeUpdate();

      System.out.println("Cliente añadido a la base de datos con éxito.");

      preparedStatement.close();
    } catch (SQLException a) {
      System.out.println("ERROR AL AÑADIR UN CLIENTE A LA BASE DE DATOS" + a);
    }
  }

  @Override
  public void deleteCustomer(int customerNumber) {
    PreparedStatement preparedStatement;
    String query = "DELETE FROM customers WHERE customerNumber = ?";

    try {
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, customerNumber);
      preparedStatement.executeUpdate();
      System.out.println("Empleado borrado con éxito");
      preparedStatement.close();
    } catch (SQLException a) {
      System.out.println("ERROR EN EL PROCESO DE BORRAR A UN CLIENTE" + a);
    }
  }
}
