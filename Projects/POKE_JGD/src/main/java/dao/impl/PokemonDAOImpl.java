package dao.impl;

import dao.PokemonDAO;
import dao.generic.GenericDAOImpl;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;

import java.util.List;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon> implements PokemonDAO {
    private final Session session;

    public PokemonDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    /**
*
 * @param tipo
 * @return
*/
    @Override
    public List<String> getPokemonsNamesFromTipo(Tipo tipo) {
        if(!session.getTransaction().isActive()){
            session.getTransaction().begin();
        }
        return session
                .createQuery("FROM Pokemon p JOIN PokemonTipo pt ON p.id, pt.idPokemon WHERE pt.idPopkemon=:idTipo")
                .setParameter("idTipo", tipo.getId())
                .list();
    }

/**
*
 * @param busqueda
 * @return
*/
    @Override
    public List<Pokemon> getAllPokemonsFromNameOrDescription(String busqueda) {
        return null;
    }
}
