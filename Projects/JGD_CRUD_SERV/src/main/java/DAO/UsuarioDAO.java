package DAO;

import Modelo.UsuarioBean;

import java.util.ArrayList;

public interface UsuarioDAO {
    public UsuarioBean getUsuario(String name);
    public void makeAdmin(UsuarioBean usuario);

    public ArrayList<UsuarioBean> getAllCustomers();
    public void deleteUsuario();
    public void modUsuario();
    public boolean modContrasena(String oldPass, String newPass);
    public boolean modUsername(String oldName, String newName);
    public boolean modEmail(String oldEmail, String newEmail);

    public boolean addUsuario(UsuarioBean user);
}
