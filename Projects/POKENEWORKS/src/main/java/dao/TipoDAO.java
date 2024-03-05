package dao;

import dao.generic.GenericDAO;
import dao.generic.GenericDAOImpl;
import models.Pokemon;
import models.Tipo;

import java.util.List;

public interface TipoDAO extends GenericDAO<Tipo>{
    public List<Pokemon> selectPokesByTipo(Tipo tipo);
}
