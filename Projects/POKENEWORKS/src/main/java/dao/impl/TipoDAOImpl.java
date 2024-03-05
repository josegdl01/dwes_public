package dao.impl;

import dao.TipoDAO;
import dao.generic.GenericDAOImpl;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;

import java.util.List;

public class TipoDAOImpl extends GenericDAOImpl<Tipo> implements TipoDAO {

    private final Session session;
    public TipoDAOImpl(Session session){
        super(session);
        this.session = session;
    }
    @Override
    public List<Pokemon> selectPokesByTipo(Tipo tipo) {
    return session.createQuery("FROM Pokemon p JOIN TipoPokemon tp ON p.Id, tp.IdPokemon WHERE p.Id =: PARAM")
            .setParameter("PARAM", tipo.getId())
            .list();
    }
}
