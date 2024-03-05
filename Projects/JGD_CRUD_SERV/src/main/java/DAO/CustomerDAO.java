package DAO;

import Modelo.CustomerBean;

import java.util.ArrayList;

public interface CustomerDAO {
    void addCustomer(CustomerBean customerBean);
    void deleteCustomer(int id);

    CustomerBean getCustomer(int cusId);
    ArrayList<CustomerBean> getAllCustomers();

    void editCustomer(CustomerBean customerBean);
}
