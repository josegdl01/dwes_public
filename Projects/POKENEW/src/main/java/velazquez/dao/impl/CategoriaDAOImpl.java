package velazquez.dao.impl;

import velazquez.dao.CategoriaDAO;
import velazquez.dao.generic.GenericDAOImpl;
import velazquez.models.Categoria;
import org.hibernate.Session;

import java.util.List;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria> implements CategoriaDAO {

    private final Session session;

    public CategoriaDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public List<Categoria> selectCategoria(String categoria) {
        return session.createQuery("SELECT nombre FROM categoria WHERE nombre LIKE :PARAMETRO")
                .setParameter("PARAMETRO", '%'+categoria+'%')
                .list();
    }
}
