package interfacesDao;

import java.util.ArrayList;
import modelos.Customer;

public interface CustomerDAO {
    public ArrayList<Customer> getAllCustomers();

    public Customer getCustomer(int customerNumber);
    public void insertCustomer(Customer c);
    public void deleteCustomer(int customerNumber);
}
