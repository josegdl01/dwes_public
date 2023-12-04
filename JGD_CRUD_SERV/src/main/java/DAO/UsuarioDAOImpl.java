package DAO;

import BBDD.PoolDB;
import Modelo.UsuarioBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO {

    final static Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);

    public UsuarioDAOImpl() {}

    PoolDB pool = new PoolDB();


    @Override
    public UsuarioBean getUsuario(String name) {
        UsuarioBean usuario = null;
        try {
            String sentence = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(sentence);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = new UsuarioBean(resultSet.getString("usuario"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"));
            }
        } catch (SQLException s) {
            log.info(s.toString());
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
    public boolean modContrasena(String oldPass, String newPass) {
        boolean correcto = false;
        try{
            String query = "UPDATE usuarios set pswd = ? WHERE pswd = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setString(1,newPass);
            preparedStatement.setString(2,oldPass);
            correcto = true;
            preparedStatement.executeUpdate();

        } catch (SQLException s){
            log.error(s.toString());
        }
        return correcto;
    }

    @Override
    public boolean modUsername(String oldName, String newName) {
        boolean correcto = false;
        try{
            String query = "UPDATE usuarios set username = ? WHERE username = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setString(1,newName);
            preparedStatement.setString(2,oldName);
            correcto = true;
            preparedStatement.executeUpdate();

        } catch (SQLException s){
            log.error(s.toString());
        }
        return correcto;
    }

    @Override
    public boolean modEmail(String oldEmail, String newEmail) {
        boolean correcto = false;
        try{
            String query = "UPDATE usuarios set email = ? WHERE email = ?";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setString(1,newEmail);
            preparedStatement.setString(2,oldEmail);
            correcto = true;
            preparedStatement.executeUpdate();

        } catch (SQLException s){
            log.error(s.toString());
        }
        return correcto;
    }

    @Override
    public boolean addUsuario(UsuarioBean user) {
        boolean userCorrect = false;
        try{
            String query = "INSERT INTO usuarios VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = pool.getConnection().prepareStatement(query);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPass());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,"user");
            preparedStatement.executeUpdate();
            log.info("Usuario"+ user.getName() +" creado con éxito");
            userCorrect = true;
        } catch (SQLException s){
            log.error(s.toString());
        }
        return userCorrect;
    }
}
