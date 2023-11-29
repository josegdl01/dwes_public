package Dao;

import BBDD.ConnectionBBDD;
import Models.OficinaBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaDAOImpl implements OficinaDAO {

  static final Logger log = LoggerFactory.getLogger(OficinaDAOImpl.class);

  public OficinaDAOImpl() {}

  @Override
  public OficinaBean getOficina(String id) {
    OficinaBean oficina = null;
    log.info("Buscando Oficina");
    try {
      String sentence = "SELECT * FROM offices WHERE officeCode = ?";
      PreparedStatement preparedStatement =
          ConnectionBBDD.getConnection().prepareStatement(sentence);
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
