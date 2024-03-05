package Dao;

import BBDD.PoolDB;
import Models.EmpleadoBean;
import Models.OficinaBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAOImpl implements OficinaDAO {

    static final Logger log = LoggerFactory.getLogger(OficinaDAOImpl.class);

    PoolDB poolDB = new PoolDB();

    public OficinaDAOImpl() {}

    @Override
    public ArrayList<OficinaBean> getAllOficinas() {
        ArrayList<OficinaBean> oficinas = new ArrayList<>();
        OficinaBean oficina = null;
        try {
            String sentence = "SELECT * FROM offices";
            PreparedStatement preparedStatement =
                    poolDB.getConnection().prepareStatement(sentence);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                oficina = new OficinaBean(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9));
                oficinas.add(oficina);
            }
        } catch (SQLException s) {
            log.error(s.toString());
        }
        return oficinas;
    }

    @Override
    public OficinaBean getOficina(String id) {
        OficinaBean oficina = null;
        try {
            String sentence = "SELECT * FROM offices WHERE officeCode = ?";
            PreparedStatement preparedStatement =
                    poolDB.getConnection().prepareStatement(sentence);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                oficina =
                        new OficinaBean(
                                resultSet.getString("officeCode"),
                                resultSet.getString("city"),
                                resultSet.getString("phone"),
                                resultSet.getString("addressLine1"),
                                resultSet.getString("addressLine2"),
                                resultSet.getString("state"),
                                resultSet.getString("country"),
                                resultSet.getString("postalCode"),
                                resultSet.getString("territory"));
            }
        } catch (SQLException s) {
            log.error(s.toString());
        }
        return oficina;
    }
}
