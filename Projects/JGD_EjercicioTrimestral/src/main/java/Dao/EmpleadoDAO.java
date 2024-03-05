package Dao;

import Models.EmpleadoBean;

import java.util.ArrayList;

public interface EmpleadoDAO {
    public ArrayList<EmpleadoBean> getAllEmpleados();
    public ArrayList<EmpleadoBean> getAllJefes();
    public EmpleadoBean getEmpleado(int id);
    public boolean insertEmpleado(EmpleadoBean emp);
}
