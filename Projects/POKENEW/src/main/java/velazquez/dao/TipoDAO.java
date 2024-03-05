package velazquez.dao;

import velazquez.dao.generic.GenericDAO;
import velazquez.models.Tipo;

import java.util.List;

public interface TipoDAO extends GenericDAO<Tipo> {
    public List<String> selectPokeNombresPorTipo(Tipo tipo);
}
