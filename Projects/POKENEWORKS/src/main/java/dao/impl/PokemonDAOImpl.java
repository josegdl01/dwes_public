package dao.impl;

import dao.PokemonDAO;
import dao.generic.GenericDAOImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;

import java.util.List;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon> implements PokemonDAO{
    private final Session session;
    public PokemonDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public List<Pokemon> getPokemonsByTipo(Tipo tipo) {
        if(!session.getTransaction().isActive()){
            session.getTransaction().begin();
        }

        return session.createQuery("FROM Pokemon p JOIN TipoPokemon tp on p.id, tp.IdPokemon WHERE tp.IdPokemon=:IdTipo")
                .setParameter("IdTipo", tipo.getId())
                .list();
    }

    @Override
    public List<Pokemon> getPokemonsByCategoria(String busqueda) {
        if(!session.getTransaction().isActive()){
            session.getTransaction().isActive();
        }

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pokemon> criteria = builder.createQuery(Pokemon.class);
        Root<Pokemon> root = criteria.from(Pokemon.class);

        Predicate pokemonNamePredicate = builder.equal(root.get("nombre"), busqueda);
        Predicate pokemonDescPredicate = builder.equal(root.get("descripcion"), busqueda);
        Predicate orPredicate = builder.or(pokemonNamePredicate, pokemonDescPredicate);

        criteria.select(root);
        criteria.where(orPredicate);

        return session.createQuery(criteria).getResultList();
    }
}
