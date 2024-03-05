package test;

import implementacionDao.*;
import modelos.Customer;
import sql.ConexionBBDD;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        SqlCustomerDAO test = new SqlCustomerDAO();
        SQLEmployeeDAO testE = new SQLEmployeeDAO();

       System.out.println("\nTABLA ENTERA \n ------------------------------------------------------------------------------------------------------------------------------------------------");

        for(Customer x: test.getAllCustomers()){
            System.out.println(x.toString());
        }

        System.out.println("\nSELECT INDIVIDUAL \n ------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(test.getCustomer(141).toString());

        System.out.println("\nINSERTAR CLIENTE \n ------------------------------------------------------------------------------------------------------------------------------------------------");
        Customer c = new Customer(1,"asd","asd","asd","asd","asd","asd","asd","asd","asd","asd",1370, 15);
        test.insertCustomer(c);

        System.out.println("\nSELECT INDIVIDUAL PARA COMPROBAR \n ------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(test.getCustomer(1).toString());

        System.out.println("\nBORRAR CLIENTE \n ------------------------------------------------------------------------------------------------------------------------------------------------");
        test.deleteCustomer(1);

        //ESTE SELECT DEBE DEVOLVER UNA EXCEPCIÓN QUE NOS DIGA QUE EL RESULTSET ESTÁ VACÍO
        System.out.println("\nSELECT INDIVIDUAL PARA COMPROBAR \n ------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(test.getCustomer(1).toString());
        System.out.println(testE.getAllEmployees().toString());
    }
}
