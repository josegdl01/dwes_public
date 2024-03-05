package Dao;

import BBDD.PoolDB;
import Models.EmpleadoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    static final Logger log = LoggerFactory.getLogger(EmpleadoDAOImpl.class);

    PoolDB pooldb = new PoolDB();

    @Override
    public ArrayList<EmpleadoBean> getAllEmpleados() {
        ArrayList<EmpleadoBean> empleados = new ArrayList<>();
        EmpleadoBean empleadoBean = null;
        OficinaDAO oficinaDAO = new OficinaDAOImpl();
        try {
            String sentence = "SELECT * FROM employees";
            PreparedStatement preparedStatement =
                    pooldb.getConnection().prepareStatement(sentence);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleadoBean =
                        new EmpleadoBean(
                                resultSet.getString("employeeNumber"),
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName"),
                                resultSet.getString("extension"),
                                resultSet.getString("email"),
                                resultSet.getString("jobTitle"),
                                oficinaDAO.getOficina(resultSet.getString("officeCode")).getCiudad(),
                                resultSet.getString("reportsTo"));
                empleados.add(empleadoBean);
            }

        } catch (SQLException s) {
            log.error(s.toString());
        }
        return empleados;
    }

    @Override
    public EmpleadoBean getEmpleado(int id) {
        EmpleadoBean empleadoBean = null;
        try {
            String sentence = "SELECT * FROM employees WHERE employeeNumber = ?";
            PreparedStatement preparedStatement = pooldb.getConnection().prepareStatement(sentence);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleadoBean =
                        new EmpleadoBean(
                                resultSet.getString("employeeNumber"),
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName"),
                                resultSet.getString("extension"),
                                resultSet.getString("email"),
                                resultSet.getString("jobTitle"),
                                resultSet.getString("officeCode"),
                                resultSet.getString("reportsTo"));
            }
        } catch (SQLException s) {
            log.error(s.toString());
        }
        return empleadoBean;
    }

    @Override
    public ArrayList<EmpleadoBean> getAllJefes() {
        ArrayList<EmpleadoBean> jefes = new ArrayList<>();
        EmpleadoBean jefe = null;
        try {
            String sentence = "SELECT reportsTo FROM employees";
            PreparedStatement preparedStatement =
                    pooldb.getConnection().prepareStatement(sentence);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sentence2 = "SELECT * FROM employees WHERE employeeNumber = ?";
                PreparedStatement preparedStatement2 =
                        pooldb.getConnection().prepareStatement(sentence2);
                preparedStatement2.setString(1, resultSet.getString(1));
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    jefe = new EmpleadoBean(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8));
                    jefes.add(jefe);
                }
            }

            } catch(SQLException s){
                log.error(s.toString());
            }
            return jefes;
        }

    @Override
    public boolean insertEmpleado(EmpleadoBean emp) {
        boolean empCorrect = false;
        try{
            String query = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = pooldb.getConnection().prepareStatement(query);
            preparedStatement.setString(1,emp.getId());
            preparedStatement.setString(2,emp.getApellidos());
            preparedStatement.setString(3,emp.getNombre());
            preparedStatement.setString(4,emp.getExtension());
            preparedStatement.setString(5,emp.getEmail());
            preparedStatement.setString(6,emp.getOficina());
            preparedStatement.setString(7,emp.getJefe());
            preparedStatement.setString(8,emp.getPuesto());
            preparedStatement.executeUpdate();
            log.info("Empleado creado con éxito");
            empCorrect = true;
        } catch (SQLException s){
            log.error(s.toString());
        }
        return empCorrect;
    }
}
