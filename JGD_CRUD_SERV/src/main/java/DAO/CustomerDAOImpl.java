package DAO;

import BBDD.PoolDB;
import Modelo.CustomerBean;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerDAOImpl implements CustomerDAO{
    final static Logger log = LoggerFactory.getLogger(CustomerDAO.class);

    PoolDB pool;

    public CustomerDAOImpl() {
        pool = new PoolDB();
    }

    @Override
    public CustomerBean getCustomer(int cusId){
        CustomerBean customerBean;
        try{
            String query = "SELECT * FROM customer WHERE cus_id = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, cusId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customerBean = new CustomerBean(resultSet.getInt(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getString(4),
                     resultSet.getString(5));

            log.info("CLIENTE " +cusId+ " LEÍDO CON ÉXITO");
        } catch(SQLException a){
            log.error(a +" FALLO EN EL PROCESO DE SELECCIONAR UN CLIENTE");
            customerBean = null;
        }

        return customerBean;
    }

    public ArrayList<CustomerBean> getAllCustomers(){
        CustomerBean customerBean;
        ArrayList<CustomerBean> customerBeans = new ArrayList<>();
        try{
            String query = "SELECT * FROM customer";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customerBean = new CustomerBean(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                customerBeans.add(customerBean);
            }

            log.info("TODOS LOS CLIENTES HAN SIDO LEÍDOS CON ÉXITO");
        } catch(SQLException a){
            log.error(a +" FALLO EN EL PROCESO DE SELECCIONAR UN CLIENTE");
            customerBeans = null;
        }
        return customerBeans;
    }

   public void addCustomer(CustomerBean customerBean){
        try{
            String query = "INSERT INTO customer(cus_id, cus_taxcode,cus_bus_name,cus_address,cus_phone) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, customerBean.getCusId());
            preparedStatement.setString(2, customerBean.getCusTaxCode());
            preparedStatement.setString(3, customerBean.getCusBusName());
            preparedStatement.setString(4, customerBean.getCusAddress());
            preparedStatement.setString(5, customerBean.getCusPhone());
            preparedStatement.executeUpdate();
            log.info("CLIENTE " + customerBean.getCusId()+ " AÑADIDO CON ÉXITO");
        } catch(SQLException sqlException){
            log.error(sqlException+" FALLO EN EL PROCESO DE INSERTAR UN CLIENTE");
        }
   }

   public void deleteCustomer(int id){
        try {
            String query = "DELETE FROM customer WHERE cus_id = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            log.info("ELIMINACIÓN DEL CLIENTE " +id+ " REALIZADA CON ÉXITO");
        } catch(SQLException s){
            log.error(s + " FALLO EN EL PROCESO DE BORRAR UN CLIENTE");
        }
   }
    @Override
    public void editCustomer(CustomerBean customerBean) {
        try{
            //String query = ";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement("UPDATE customer SET cus_taxcode = ?,cus_bus_name = ?,cus_address = ?,cus_phone=? WHERE cus_id=?");
            preparedStatement.setString(1, customerBean.getCusTaxCode());
            preparedStatement.setString(2, customerBean.getCusBusName());
            preparedStatement.setString(3, customerBean.getCusAddress());
            preparedStatement.setString(4, customerBean.getCusPhone());
            preparedStatement.setInt(5, customerBean.getCusId());

            preparedStatement.executeUpdate();
            log.info("CLIENTE "+ customerBean.getCusId()+" EDITADO CON ÉXITO");
        } catch (SQLException s){
            log.error(s + "ERROR EN EL PROCESO DE EDITAR UN CLIENTE");
        }
    }
}
