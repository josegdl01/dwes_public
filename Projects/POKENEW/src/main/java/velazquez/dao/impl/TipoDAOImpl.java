package velazquez.dao.impl;

import velazquez.dao.TipoDAO;
import velazquez.dao.generic.GenericDAOImpl;
import velazquez.models.Tipo;
import org.hibernate.Session;

import java.util.List;

public class TipoDAOImpl extends GenericDAOImpl<Tipo> implements TipoDAO {

    private final Session session;
    public TipoDAOImpl(Session session){
        super(session);
        this.session = session;
    }
    @Override
    public List<String> selectPokeNombresPorTipo(Tipo tipo) {
        String HQL = "SELECT nombre FROM Pokemon p JOIN TipoPokemon tp ON p.id, tp.IdPokemon WHERE tp.IdPokemon =: PARAMETRO";
        return session.createQuery(HQL)
                .setParameter("PARAMETRO", tipo.getId())
                .list();
    }
}
