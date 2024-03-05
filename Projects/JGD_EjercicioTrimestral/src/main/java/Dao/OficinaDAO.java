package Dao;

import Models.OficinaBean;

import java.util.ArrayList;

public interface OficinaDAO {
    public OficinaBean getOficina(String ciudad);
    public ArrayList<OficinaBean> getAllOficinas();
}
