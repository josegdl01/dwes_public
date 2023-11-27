package DAO;

import Modelo.UsuarioBean;

import java.util.ArrayList;

public interface UsuarioDAO {
    public UsuarioBean getUsuario(String name);

    public ArrayList<UsuarioDAO> getAllCustomers();
    public void deleteUsuario();
    public void modUsuario();
    public boolean addUsuario(UsuarioBean user);
}
