package velazquez.dao.impl;

import velazquez.dao.PokemonDAO;
import velazquez.dao.generic.GenericDAOImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import velazquez.models.Pokemon;
import org.hibernate.Session;

import java.util.List;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon> implements PokemonDAO{
    private final Session session;
    public PokemonDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public List<Pokemon> getPokemonsByNameOrDescription(String busqueda) {
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

    //SEGUNDO EJEMPLO SOBRE LAS CONSULTAS USANDO CRITERIA QUERY
    @Override
    public List<Pokemon> getPokemonsByImagenOrCategoria(String busqueda) {
        if(!session.getTransaction().isActive()){
            session.getTransaction().begin();
        }

        //CREAMOS EL BUILDER (LLAMANDO A LA SESIÓN SIEMPRE)
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //CREAMOS EL OBJETO QUERY SOBRE EL CUAL REALIZAREMOS TODAS LAS CONSULTAS
        CriteriaQuery<Pokemon> criteriaQuery = criteriaBuilder.createQuery(Pokemon.class);
        //ENTIENDO QUE ESTO ES COMO LA SELECCIÓN DE LA TABLA SOBRE LA QUE OPERAMOS
        Root<Pokemon> baseConsulta = criteriaQuery.from(Pokemon.class);

        //CLÁUSULA WHERE PARA IGUALAR LA IMAGEN AL PARÁMETRO DE BÚSQUEDA
        Predicate imagen = criteriaBuilder.equal(baseConsulta.get("imagen"), busqueda);
        //CLÁUSULA WHERE PARA IGUALAR LA CATEGORÍA AL PARÁMETRO DE BÚSQUEDA
        Predicate categoria = criteriaBuilder.equal(baseConsulta.get("categoria"), busqueda);
        //CLÁUSULA OR
        Predicate puertaLogica = criteriaBuilder.or(imagen, categoria);

        //ASIGNAMOS EL SELECT Y EL WHERE
        criteriaQuery.select(baseConsulta);
        criteriaQuery.where(puertaLogica);

        //DEVOLVEMOS EL RESULTADO EN FORMATO LISTA
        return session.createQuery(criteriaQuery).getResultList();
    }
}
