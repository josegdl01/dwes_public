package Dao;

import BBDD.ConnectionBBDD;
import Models.UsuarioBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO {

    final static Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);

    public UsuarioDAOImpl() {}


    @Override
    public UsuarioBean getUsuario(String name) {
        UsuarioBean usuario = null;
        try {
            String sentence = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement preparedStatement = ConnectionBBDD.getConnection().prepareStatement(sentence);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = new UsuarioBean(resultSet.getString("username"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lasstname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role"));
            }
        } catch (SQLException s) {
            log.error(s.toString());
        }
        return usuario;
    }

    @Override
    public void makeAdmin(UsuarioBean usuario) {
        usuario.setRole("admin");
    }

    @Override
    public ArrayList<UsuarioBean> getAllCustomers() {
        return null;
    }

    @Override
    public void deleteUsuario() {

    }

    @Override
    public void modUsuario() {

    }

    @Override
    public boolean addUsuario(UsuarioBean user) {
        boolean userCorrect = false;
        try{
            String query = "INSERT INTO usuarios VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionBBDD.getConnection().prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getPass());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,"user");
            preparedStatement.executeUpdate();
            log.info("Usuario"+ user.getUsername() +" creado con éxito");
            userCorrect = true;
        } catch (SQLException s){
            log.error(s.toString());
        }
        return userCorrect;
    }
}
