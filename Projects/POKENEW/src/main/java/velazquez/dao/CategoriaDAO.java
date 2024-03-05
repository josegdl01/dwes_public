package velazquez.dao;

import velazquez.dao.generic.GenericDAO;
import velazquez.models.Categoria;

import java.util.List;

public interface CategoriaDAO extends GenericDAO<Categoria> {
    public List<Categoria> selectCategoria(String categoria);
}
