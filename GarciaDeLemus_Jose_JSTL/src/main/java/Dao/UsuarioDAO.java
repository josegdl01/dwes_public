package Dao;

import Models.UsuarioBean;

import java.util.ArrayList;

public interface UsuarioDAO {
    public UsuarioBean getUsuario(String name);
    public void makeAdmin(UsuarioBean usuario);

    public ArrayList<UsuarioBean> getAllCustomers();
    public void deleteUsuario();
    public void modUsuario();
    public boolean addUsuario(UsuarioBean user);
}
