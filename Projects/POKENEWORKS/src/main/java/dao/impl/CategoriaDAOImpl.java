package dao.impl;

import dao.CategoriaDAO;
import dao.generic.GenericDAO;
import dao.generic.GenericDAOImpl;
import models.Categoria;
import org.hibernate.Session;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria> implements CategoriaDAO {

    private final Session session;

    public CategoriaDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public void mismuerto() {

    }
}
